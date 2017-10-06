# NumberToWords
# Перевод числа из цифровой записи в строковую.
<hr>

## Было реализовано:
- ООП
- Перевод дробной части
- Перевод для сколько угодного числа, с возможностью расширения справочника степеней
- Data Driven Test
- Тестирование, как позитивное, так и негативное
- Логирование 


## Изменения:

- Исправлены абсолютные пути к файлам. Теперь файлы в /resourse и путь указан от корня проекта.
- Пути к файлам вынесены в константы.
- Пересмотрены названия тестовых файлов. Теперь исходя из названия можно сделать некоторое представление о их содержании.
- Добавлены JavaDocs.
- Пересмотрено тестирование. Были добавлены негативные тесты. Теперь TestNG вместо JUnit.
- Пересмотрено логгирование. Теперь используется log4j.
- Был выработан шаблон названий тестам.
- Обработка исключений теперь на английском.
- Добавлен .gitignore в который были внесены каталоги .idea ,target & etc.
- Метод main заменен тестовым методом.
- По возможности код не дублируется.
- Исправлены неточности.

## Используемые технологии:

- Перед запуском проверить, что установлены Java 8 и Maven 3.3.9. 
- Проверка версии Java возможна с помощью команды: java -version. 
- Проверка версий Maven возможна с помощью команды: mvn -v.
- Тесты с помощью технологии TestNG
<hr>

## Запуск:

Для перевода числа из цифровой записи в строковую достаточно создать объект типа NumberToWords 
и вызвать у него метод convertNumberToWords

Пример:
" NumberToWords numberToWords = new NumberToWords(); 
  numberToWords.convertNumberToWords("114.011"); "
<hr>
