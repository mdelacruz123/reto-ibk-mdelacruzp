import { Injectable } from '@nestjs/common';
import * as crypto from 'crypto';

@Injectable()
export class EncryptionService {
  private readonly ENCRYPTION_KEY = process.env.ENCRYPTION_KEY;
  private readonly IV = process.env.IV;

  constructor() {
    if (!this.ENCRYPTION_KEY || !this.IV) {
      throw new Error('Encryption key or IV is not defined in the environment variables.');
    }
  }

  
  decrypt(text: string): string {
    const decipher = crypto.createDecipheriv('aes-256-cbc', Buffer.from(this.ENCRYPTION_KEY), Buffer.from(this.IV));
    let decrypted = decipher.update(text, 'hex', 'utf8');
    decrypted += decipher.final('utf8');
    return decrypted;
  }
}