import { Module } from '@nestjs/common';
import { BffService } from './bff.service';
import { BffController } from './bff.controller';
import { HttpModule } from '@nestjs/axios';
import { LoggerService } from 'src/common/logger.service';
import { AuthModule } from '../auth/auth.module'; 
import { JwtService } from '@nestjs/jwt';
import { EncryptionService } from 'src/crypt/encryption.service';

@Module({
  imports: [HttpModule, AuthModule],
  providers: [BffService, LoggerService, JwtService, EncryptionService],
  controllers: [BffController],
})
export class BffModule {}