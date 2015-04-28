package com.alex01010dev.cvtask;

// Расчет факториала

public class Factorial
{
    private static int forFact; // Объявляем переменные исходного числа
    private static int fact; // и для факториала

    public Factorial (int a) { // Создаем конструктор
        forFact = a;
        factorial(forFact); // передача исходного числа в метод
    }

    public static int factorial (int x) // передаем методу factorial число для расчета
    {
        if (x<0) {
            throw new IllegalArgumentException("x должен быть >=0"); // бросаем исключение если x<0
        }
        fact=1;
        for (int i=2; i<=x;i++)     // с 2 начинаем умножение, пока i<= числа заданого дял расчета.
            fact*=i;                // fact=fact*i
        return fact;                // возвращаем методу значение факториала
    }

    public int getFactorial() { // метод для получения int или необходимо создать пустой конструктор
        return fact;            // т.к. не выйдет сделать int resFactorial = new Factorial(5).factorial(*нужен аргумент*);
    }


    @Override //переопределение метода toString, чтобы при выводе Factorial в print был понятный текст
    public String toString() {
        return "Факториал числа " + forFact + ": " + fact;
    }
}