# inmobiliaria
https://www.docker.com/products/docker-desktop/

docker pull postgres

docker run --name inm-container -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=inmobiliaria -d -p 5432:5432 postgres


docker exec -it inm-container psql -U postgres -d inmobiliaria

