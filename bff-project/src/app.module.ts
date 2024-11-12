import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { BffModule } from './bff/bff.module';
import { AuthModule } from './auth/auth.module';

@Module({
  imports: [ConfigModule.forRoot({
    isGlobal: true,
  }),BffModule, AuthModule],
})
export class AppModule {}
