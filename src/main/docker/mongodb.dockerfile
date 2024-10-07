# Use uma imagem base do MongoDB com a versão específica
FROM mongo:4.4.6

# Especifica o diretório de trabalho
WORKDIR /usr/src/configs

# Copia os arquivos de configuração para o diretório de trabalho
COPY mongod.conf .

# Expõe a porta 27017 para conexão
EXPOSE 27017

# Executa o comando para iniciar o MongoDB quando o contêiner iniciar
CMD ["mongod", "--config", "./mongod.conf"]
