import { Test, TestingModule } from '@nestjs/testing';
import { BffController } from '../src/bff/bff.controller';
import { EncryptionService } from '../src/crypt/encryption.service';
import { BffService } from '../src/bff/bff.service';

describe('BffController (Single Test)', () => {
  let controller: BffController;
  let encryptionService: EncryptionService;
  let bffService: BffService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [BffController],
      providers: [
        EncryptionService,
        {
          provide: BffService,
          useValue: {
            getClientInfo: jest.fn(),
            getFinancialProducts: jest.fn(),
          },
        },
      ],
    }).compile();

    controller = module.get<BffController>(BffController);
    encryptionService = module.get<EncryptionService>(EncryptionService);
    bffService = module.get<BffService>(BffService);
  });

  it('decrypt codigoUnico, client and product data', async () => {
    const mockEncryptedCodigoUnico = 'mockEncryptedCode';
    const mockDecryptedCodigoUnico = 'codigoUnico123';
    const mockClientInfo = {
      id: 'clientId123',
      nombres: 'John',
      apellidoPaterno: 'Doe',
      apellidoMaterno: 'Smith',
      tipoDocumento: 'DNI',
      numeroDocumento: '12345678',
    };
    const mockProductData = [
      { id: 'prod1', tipoProducto: 'Credit', nombre: 'Loan', saldo: 1000 },
    ];

    jest.spyOn(encryptionService, 'decrypt').mockReturnValue(mockDecryptedCodigoUnico);
    jest.spyOn(bffService, 'getClientInfo').mockResolvedValue(mockClientInfo);
    jest.spyOn(bffService, 'getFinancialProducts').mockResolvedValue(mockProductData);

    const result = await controller.getClientAndProducts(mockEncryptedCodigoUnico);

    expect(encryptionService.decrypt).toHaveBeenCalledWith(mockEncryptedCodigoUnico);
    expect(bffService.getClientInfo).toHaveBeenCalledWith(mockDecryptedCodigoUnico);
    expect(bffService.getFinancialProducts).toHaveBeenCalledWith(mockClientInfo.id);

    expect(result).toEqual({
      cliente: mockClientInfo,
      productos: mockProductData,
    });
  });
});