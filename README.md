# Утилита SimpleFilter
1. Версия Java: java version "23.0.1" 2024-10-15
2. Тесты: 
!Перед запуском тестов, с помощью команды pwd посмотреть текущую директорию в терминале!
!Через cd перейти в src!

Входные файлы, должны находиться в .\src\testdata

empty.txt пуст

test1.txt 
123
45.67
hello
-99
0
3.14
world

test2.txt
42
apple
-3.5
banana
999

!!Посел каждого теста нужно удалить созданные утилитой файлы .txt!!
Тест1: java .\SimpleFilter.java -o out -s .\testdata\test1.txt .\testdata\test2.txt

Тест2: java .\SimpleFilter.java -o out -s .\testdata\test1.txt .\testdata\test2.txt

Тест3: java .\SimpleFilter.java -o out -a -s .\testdata\test1.txt
       java .\SimpleFilter.java -o out -a -s .\testdata\test2.txt

Тест4: java .\SimpleFilter.java  -o out -p result_ -s .\testdata\test1.txt

Тест5: java .\SimpleFilter.java  -o out -s .\testdata/empty.txt

Тест6: java .\SimpleFilter.java-o out -s .\testdata/does_not_exist.txt




