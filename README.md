# Тестовое задание для компании ООО Синтека

Необходимо написать консольное приложение на Java(главный класс называть Main), в которое читает из файла input.txt входные данные:
Программа должна сопоставить максимально похожие строки из первого множества со строками из второго множества (одна к одной) и вывести результат в файл output.txt.


n - число

далее n строк

m - число

далее m строк

Пример 1:

input.txt:

4

гвоздь

шуруп

краска синяя

ведро для воды

3

краска

корыто для воды

шуруп 3х1.5


ouput.txt:

гвоздь:?

шуруп:шуруп 3х1.5

краска синяя:краска

ведро для воды:корыто для воды



Пример 2:

1

Бетон с присадкой

1

Цемент

ouput.txt:

Бетон с присадкой:Цемент



Пример 3:

1

Бетон с присадкой

2

присадка для бетона

доставка

ouput.txt:

Бетон с присадкой:присадка бля бетона

доставка:?
