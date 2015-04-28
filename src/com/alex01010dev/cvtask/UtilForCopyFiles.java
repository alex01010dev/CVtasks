package com.alex01010dev.cvtask;

import java.io.IOException;
import java.nio.file.*;

// Утилита для копирования файлов

public class UtilForCopyFiles {

    public UtilForCopyFiles (String Source, String Destination) { // создаем конструктор
        Path pathSource = Paths.get(Source); // указываем исходный файл
        Path pathDestination = Paths.get(Destination); // задаем назначене
        copy(pathSource, pathDestination); // вызываем метод копирования, подставив аргументы в соответствии с параметрами
    }

    public void copy(Path pathSource, Path pathDestination) { // метод для копирования файлов
        try {
            long t1 = System.nanoTime(); // используем nanoTime(), вместо currentTimeMillis() для более точного значения
            Files.copy(pathSource, pathDestination); // выполняем копирование
            long t2 = System.nanoTime(); // не вкладываем в print, т.к. появится погрешность
            System.out.println(t2 - t1 + "ns. (" + (t2 - t1) / 1000_000 + "ms)"); // вычисляем затраченное время на копирование
        } catch (FileAlreadyExistsException e) {
            System.err.println("Ошибка! Файл с таким именем уже существует.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}