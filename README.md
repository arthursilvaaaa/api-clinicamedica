# API de Clínica Médica

API REST para gerenciamento de uma clínica médica, desenvolvida com Spring Boot e Spring Data JPA.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- Spring Web MVC
- MySQL
- Docker + docker-compose
- GitHub Actions (CI/CD)
- Trivy (scan de vulnerabilidades)

## Como Rodar

**Pré-requisitos:** Docker instalado.

```bash
docker compose up --build
```

API disponível em `http://localhost:8080`

## Entidades

- Médico, Especialidade, Paciente, Consulta

## Relacionamentos

- Especialidade → Médico (OneToMany)
- Médico → Consulta (OneToMany)
- Paciente → Consulta (OneToMany)

## Endpoints

- `GET/POST /medicos`
- `GET/POST /pacientes`
- `GET/POST /especialidades`
- `GET/POST /consultas`
