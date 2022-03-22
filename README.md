# Tasks

## I Can Win
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. 
Автоматизировать следующий сценарий:

- Открыть https://pastebin.com или аналогичный сервис в любом браузере
- Создать New Paste со следующими деталями:
  * Код: "Hello from WebDriver"
  * Paste Expiration: "10 Minutes"
  * Paste Name / Title: "helloweb"

## Bring It On
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. 
Автоматизировать следующий сценарий:

1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
* Код:
```
git config --global user.name  "New Sheriff in Town"
git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
git push origin master --force
```
* Syntax Highlighting: "Bash"

* Paste Expiration: "10 Minutes"

* Paste Name / Title: "how to gain dominance among developers"

3. Сохранить paste и проверить следующее:

* Заголовок страницы браузера соответствует Paste Name / Title

* Синтаксис подcвечен для bash

* Проверить что код соответствует введенному в пункте 2

## Hurt Me Plenty
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. 
Автоматизировать следующий сценарий:

1. Открыть https://cloud.google.com/
2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
3. Запустить поиск, нажав кнопку поиска.
4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
5. Активировать раздел COMPUTE ENGINE вверху страницы
6. Заполнить форму следующими данными:
  * Number of instances: 4
  * What are these instances for?: оставить пустым
  * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
  * VM Class: Regular
  * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
  * Выбрать Add GPUs
    * Number of GPUs: 1
    * GPU type: NVIDIA Tesla V100
  * Local SSD: 2x375 Gb
  * Datacenter location: Frankfurt (europe-west3)
  * Commited usage: 1 Year
7. Нажать Add to Estimate
8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term
9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.

## Hardcore

