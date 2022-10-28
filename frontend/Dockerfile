FROM node:lts-alpine

WORKDIR /app
COPY . ./
RUN npm install

CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]
# docker build -t my-vite-dev .
# docker run --rm -it -p 3000:3000 my-vite-dev