import { Controller, Get, Param, UseGuards } from '@nestjs/common';
import { BffService } from './bff.service';
import { JwtAuthGuard } from '../auth/jwt-auth.guard';
import { EncryptionService } from '../crypt/encryption.service';

@Controller('bff')
export class BffController {
    constructor(private readonly bffService: BffService,
    private readonly encryptionService: EncryptionService,
  ) {}

  @UseGuards(JwtAuthGuard)
  @Get(':codigoUnico')
  async getClientAndProducts(@Param('codigoUnico') codigoUnico: string) {
    const decryptedCodigoUnico = this.encryptionService.decrypt(codigoUnico);
    return this.bffService.getClientAndProducts(decryptedCodigoUnico);
  }
}
