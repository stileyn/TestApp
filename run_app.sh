#!/bin/bash

echo "Выберите приложение:"
echo "1. TaskOne"
echo "2. TaskTwo"
echo "3. TaskThree"
echo "4. TaskFour"
echo

# Чтение выбора пользователя
read -r -p "Введите номер приложения: " CHOICE

# Запуск соответствующего приложения на основе выбора пользователя
case $CHOICE in
    1)
        java -jar /app/build/libs/TaskOne.jar
        ;;
    2)
        java -jar /app/build/libs/TaskTwo.jar
        ;;
    3)
        java -jar /app/build/libs/TaskThree.jar
        ;;
    4)
        java -jar /app/build/libs/TaskFour.jar
        ;;
    *)
        echo "Неправильный выбор. Попробуйте еще раз."
        ;;
esac
