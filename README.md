# ShopTour

Это сервис для покупки тура с помощью дебетовой карты и оплата с помощью кредита выданного по данным карты. В ответ на отправку формы должны приходить ответы от сервера согласно ТЗ.

## Начало работы

1. Запуск программы Docker Desktop. Дождаться статуса "Engine running".
2. Запустить проект в Intellej IDEA.

### Prerequisites

1. Docker Desktop.
2. Google Chrome.
3. Intellej IDEA.

### Установка и запуск

1. Запустить через терминал IDEA контейнеры с помощью команды:
```
docker-compose up -d
```
2. Запустить через терминал IDEA jar'ник с помощью команды:
```
java -jar .\artifacts\aqa-shop.jar
```
Запустить тесты:
```
.\gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app
```
Создать отчёт Allure и открыть в браузере
```
.\gradlew allureServe
```
## Ссылки
[План выполнения ТЗ.](https://github.com/Maxxx1254/ShopTour/blob/main/docs/Plan.md)
