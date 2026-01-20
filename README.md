🔧 Инструкция по запуску backend (TaskFlow) локально
1. Что нужно установить
✅ Обязательно

Docker Desktop (с Docker Compose)
https://www.docker.com/products/docker-desktop/

→ после установки перезагрузить ПК

Java JDK 17
Рекомендуется:
[https://adoptium.net/temurin/releases/?version=17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

Проверка:
java -version

Должно быть:
java 17.x

2. Скачать проект
git clone https://github.com/akaha-loks/TaskFlow.git
Переходим в папку проекта:
cd TaskFlow

4. Запуск базы данных (Docker)
В корне проекта лежит docker-compose.yml.

docker compose up -d


Проверка:
docker ps


PostgreSQL должен быть Running.

4. Запуск backend

java -jar target/TaskFlow-0.0.1-SNAPSHOT.jar

После запуска:

Backend доступен:
👉 http://localhost:8080

Swagger:
👉 http://localhost:8080/swagger-ui.html

6. CORS (уже разрешено для разработки)

Для локальной разработки разрешены все origin:

Access-Control-Allow-Origin: *

Фронт может обращаться напрямую:

http://localhost:8080/api/...

7. Типовой флоу запуска (коротко)
cd TaskFlow
docker compose up -d
java -jar target/TaskFlow-0.0.1-SNAPSHOT.jar

8. Частые проблемы
❌ UnsupportedClassVersionError

→ Установлена старая Java
✔ Решение: Java 17, проверить java -version

❌ docker compose up → not found

→ Команда запущена не в корне проекта
✔ Нужно, чтобы рядом был docker-compose.yml

❌ Backend не стартует

✔ Проверить:

Docker запущен
Порт 5438 свободен
Порт 8080 свободен
