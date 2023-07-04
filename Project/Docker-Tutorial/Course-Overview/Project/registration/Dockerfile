FROM node:13-alpine
ENV MONGO_DB_USERNAME=mongoadmin \
    MONGO_DB_PWD=secret
RUN mkdir -p /home/my-registration
COPY ./my-registration /home/my-registration
CMD ["node", "/home/my-registration/server.js"]


