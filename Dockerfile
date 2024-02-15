# Используем образ с JDK для сборки и запуска Java-приложения
FROM openjdk:11 as builder

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем исходный код проекта внутрь контейнера
COPY . .

# Собираем все JAR-файлы приложения
RUN chmod +x gradlew
RUN ./gradlew clean build

# Копируем скрипт run_app.sh из корня проекта внутрь контейнера
COPY run_app.sh /app/run_app.sh

# Делаем скрипт исполняемым
RUN chmod +x /app/run_app.sh

# Отдельный этап сборки образа, чтобы уменьшить его размер
FROM openjdk:11

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файлы из предыдущего этапа сборки
COPY --from=builder /app/build/libs/*.jar /app/build/libs/

# Копируем скрипт run_app.sh из предыдущего этапа сборки
COPY --from=builder /app/run_app.sh /app/run_app.sh

# Делаем скрипт исполняемым
RUN chmod +x /app/run_app.sh

# Задаем команду для запуска приложения при запуске контейнера
CMD ["/app/run_app.sh"]
