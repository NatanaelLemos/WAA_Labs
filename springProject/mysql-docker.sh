#!/bin/bash

app="coffeeshop-mysql"

if sudo docker ps | awk -v app="$app" 'NR > 1 && $NF == app{ret=1; exit} END{exit !ret}'; then
  sudo docker rm $app -f
fi

if sudo docker container ls -a | awk -v app="$app" 'NR > 1 && $NF == app{ret=1; exit} END{exit !ret}'; then
  sudo docker container rm $app -f
fi

sudo docker run \
   -e MYSQL_ROOT_PASSWORD=rootP455w0rd \
   -v $app:/var/lib/mysql \
   -p 3306:3306 \
   --name $app \
   -d mysql