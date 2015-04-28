package com.alex01010dev.cvtask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Поиск количества вхождений слова в тексте.

public class WordInText
{
    public WordInText (String pathAndFile) throws IOException {
        String[] s = pathAndFile.split(" "); // разделяем путь и название от слова для поиска
        if(s.length>2 || s.length==0) // проверяем наличие аргументов
        {
            System.err.println("Неправильное количество аргументов");
            System.exit(0);
        }
        String path = s[0]; // вынимаем из массива путь к текстовому файлу
        String word = s[1].toLowerCase(); // слово преобразуем к нижнему регистру, чтобы это не влияло на поиск
        Search srch = new Search(path, word); // создаем экземпляр класса Search и в передаем аргументы в конструктор.
        System.out.println(srch.find()); // выводим количество найденных вхождений
    }
}

class Search {
    private String path;
    private BufferedReader br;
    private int count = 0;
    private StringBuilder sb;
    private String str;
    private String examp;

    public Search(String p, String e) // присваеваем переданные аргументы переменным этого класса
    {
        this.path = p;
        this.examp = e;
    }

    private String read(String p) throws IOException // читаем текст из файла
    {
        try
        {
            sb = new StringBuilder();
            br = new BufferedReader(new FileReader(new File(p))); // открываем поток на считывание текста из файла
            String line;
            while((line = br.readLine())!=null) // считываем пока есть текст
            {
                sb.append(line); // в конец строки добавляем подстроку
                sb.append('\n'); // вставляем перенос строки
            }
        } catch(Exception e)
        {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally
        {
            br.close(); // закрываем поток на считывание файла
        }
        str = new String(sb).toLowerCase(); // преобразуем считаную строку из файла в нижний регистр
        return str;
    }

    public int find() throws IOException {
        String res = read(path);
        Pattern p = Pattern.compile(examp);
        Matcher m = p.matcher(res);
        while(m.find()) // подсчитываем количество вхождений слова в тексте
        {
            count++;
        }
        return count;
    }
}