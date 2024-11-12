# Usar una imagen base de Node.js
FROM node:18-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY package*.json ./

# Instalar las dependencias
RUN npm install

# Copiar el resto del proyecto
COPY . .

# Exponer el puerto utilizado por la BFF
EXPOSE 3000

# Comando para iniciar la BFF
CMD ["npm", "run", "start:debug"]