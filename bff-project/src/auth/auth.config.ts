import { registerAs } from '@nestjs/config';

export default registerAs('auth', () => ({
  domain: process.env.AUTH0_DOMAIN,
  audience: process.env.AUTH0_AUDIENCE,
  clientId: process.env.AUTH0_CLIENT_ID,
  clientSecret: process.env.AUTH0_CLIENT_SECRET,
  grantType: process.env.AUTH0_GRANT_TYPE,
}));