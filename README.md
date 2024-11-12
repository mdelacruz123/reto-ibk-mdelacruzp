# reto-ibk-mdelacruzp

# PASOS PARA LEVANTAR EL RETO
1. Descargar del repositorio git
2. Tendremos la estructura de carpetas
2. Ejecutar "mvn clean package" en el directorio de cada microservicio ( microservicio-cliente y microservicio-producto)
3. Ejecutar  "docker-compose up --build" en la carpeta donde se encuentre el archivo docker-compose

# PASOS PARA PROBAR LA API DEL BFF
Se adjunta en la misma carpeta una coleccion de Requests
1. Primero ejecutar la peticion "1. OAuth2 Token - Auth0", esta nos generará un token Bearer
2. El token Bearer generado en el paso 1 usarlo como cabecera de Autorization en la peticion "2. API BFF - obtener cliente y productos financieros"
3. Las otras dos peticiones eran de pruebas locales

# DATA DE PRUEBA
Se agregaron datos de prueba en el script de base de datos los cuales al poner como path variable estan ecriptados y dentro lo desencripta para buscarlo en la BD
El dato que aparece en la coleccion corresponde a:
- CodigoUnico Encriptado : 90babd11f28f02d99487235a5bc1691a
- KEY : 0123456789abcdef0123456789abcdef
- IV : abcdef9876543210
- MODE : CBC
- CodigoUnico Desencriptado : ABC123
