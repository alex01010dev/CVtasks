package com.alex01010dev.cvtask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;

/**
 *    После запуска в консоль необходимо ввести путь к файлу и слово для поиска вхождений
 * 1) Расчитывается факториал
 * 2) Поиск количества вхождений слова в тексте
 * 3) Тест калькулятора (+ - / *)
 * 4) Идет копирование файла, указывается затраченное время.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Открываем поток на считывание с консоли.
        System.out.println("Введите в консоль имя файла и слово для поиска вхождений: \n" +
            "Пример: c:/temp/test.txt text");
        String r = null;
        try {
            r = reader.readLine(); // вводим в консоль строку
        } catch (IOException e) {
            System.err.println("Строка не считана: " + e.getMessage());
        } finally {
            try {
                reader.close(); // закрываем поток
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Factorial
        Factorial f = new Factorial(4); // Создаем екземпляр класса Factorial и в конструктор задаем аргумент для вычисления
        System.out.println("=== Тест 1. Расчет факториала числа:");
        int resFactorial = f.getFactorial(); // Достаем числовое значение
        System.out.println(resFactorial); // Выводим в консоль результат факториала

        //WordInText
        System.out.println("=== Тест 2. Поиск количества вхождений слова в тексте:");
        new WordInText(r); //передаем считаный путь к файлу и слово в конструктор класса WordInText

//      === Calc
        System.out.println("=== Тест 3. Калькулятор:");
        new Calc("410+90");
        new Calc("18-74");
        new Calc("90*18");
        new Calc("987/38");

        //UtilForCopyFiles
        System.out.println("=== Тест 4. Копирование файла:");
        String sourceForCopy = "c:/Temp/ThinkingInJava4thEd.pdf"; // Задаем имя копируемого
        String destinationForCopy = "c:/Temp/ThinkingInJava4thEd_2.pdf"; // и конечного файла
        new UtilForCopyFiles(sourceForCopy, destinationForCopy);
    }
}