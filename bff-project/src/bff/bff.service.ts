import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios'; 
import { AxiosResponse } from 'axios';
import { ClientResponse } from '../interface/client.interface';
import { ProductResponse } from '../interface/product.interface';
import { LoggerService } from '../common/logger.service';

@Injectable()
export class BffService {
  constructor(
    private readonly httpService: HttpService,
    private readonly logger: LoggerService
  ) {}

  private generateTrackingId(): string {
    return `tracking-${Date.now()}`;
  }

  async getClientInfo(codigoUnico: string): Promise<ClientResponse> {
    const trackingId = this.generateTrackingId();
    this.logger.log(`Consultando cliente con código único ${codigoUnico}`);
    try {
      const response: AxiosResponse<ClientResponse> = await this.httpService
        .get(`http://microservicio-cliente:8081/api/v1/clientes/${codigoUnico}`, {
          headers: { 'tracking-id': trackingId },
        })
        .toPromise();
      this.logger.log(`Cliente encontrado: ${JSON.stringify(response.data)}`);
      return response.data;
    } catch (error) {
      this.logger.error('Error al consultar cliente', error.stack);
      throw error;
    }
  }

  async getFinancialProducts(clientId: string): Promise<ProductResponse[]> {
    const trackingId = this.generateTrackingId();
    this.logger.log(`Consultando productos financieros para el cliente ${clientId}`);
    try {
      const response: AxiosResponse<ProductResponse[]> = await this.httpService
        .get(`http://microservicio-producto:8082/api/v1/productos/${clientId}`, {
          headers: { 'tracking-id': trackingId },
        })
        .toPromise();
      this.logger.log(`Productos financieros: ${JSON.stringify(response.data)}`);
      return response.data;
    } catch (error) {
      this.logger.error('Error al consultar productos financieros', error.stack);
      throw error;
    }
  }

  async getClientAndProducts(codigoUnico: string): Promise<any> {
    const clientInfo = await this.getClientInfo(codigoUnico);
    const financialProducts = await this.getFinancialProducts(clientInfo.id);
    return {
      ...clientInfo,
      productosFinancieros: financialProducts,
    };
  }
}