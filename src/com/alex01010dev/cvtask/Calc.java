package com.alex01010dev.cvtask;

// Реализация простейшего калькулятора
public class Calc {

    public Calc(String r) {
        String[] arr = r.split("\\+|\\-|\\*|\\/"); // задаем разделители
        try {
            int i1 = Integer.parseInt(arr[0]); // парсим число из строки в int
            int i2 = Integer.parseInt(arr[1]);
            if (r.contains("+")) {              // в зависимости присутствующего арифметического знака выполняется вычисление.
                System.out.println(add(i1,i2));
            } else if (r.contains("-")) {
                System.out.println(sub(i1,i2));
            } else if (r.contains("*")) {
                System.out.println(mul(i1,i2));
            } else if (r.contains("/")) {
                System.out.println(div(i1,i2));
            } else {
                System.err.println("Допущена ошибка, повторите ввод. Пример: 4+5"); // если задан не верный оператор - выводим ошибку
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public int add(int a, int b) { // метод сложения
        return a + b;
    }

    public int sub(int a, int b) { // метод вычитания
        return a - b;
    }

    public int mul(int a, int b) { // // метод умножения
        return a * b;
    }

    public double div(double a, int b) {    // метод деления
        return a / b;
    }
}