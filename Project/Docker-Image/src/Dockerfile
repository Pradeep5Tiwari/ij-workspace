FROM node:18.13.0
COPY package.json /app/
COPY /src /app/
WORKDIR /app
RUN npm install
CMD ["node", "server.js"]



