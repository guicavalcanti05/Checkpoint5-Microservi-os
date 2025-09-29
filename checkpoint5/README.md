# Checkpoint 5 — API Spring Boot + Postgres + Docker

## Como rodar com **docker run** (imagem publicada no Docker Hub)
```bash
docker network create appnet

docker run -d --name db --network appnet \
  -e POSTGRES_DB=appdb -e POSTGRES_USER=app -e POSTGRES_PASSWORD=app \
  -p 5432:5432 -v dbdata:/var/lib/postgresql/data postgres:16

docker run -d --name api --network appnet -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=docker \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/appdb \
  -e SPRING_DATASOURCE_USERNAME=app \
  -e SPRING_DATASOURCE_PASSWORD=app \
  -e SPRING_JPA_HIBERNATE_DDL_AUTO=update \
  guicavalcanti05/checkpoint5:1.0.0
