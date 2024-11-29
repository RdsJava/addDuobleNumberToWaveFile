package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        NumberToBeginning numberToBeginning = new NumberToBeginning();
        RenameFilesFromTextFile renameFilesFromTextFile = new RenameFilesFromTextFile();

        // Путь с исходным текстом строк с номерами
        List<String> lines = Files.readAllLines(Path.of("C:/temp/listNameFile.txt"), StandardCharsets.UTF_8);
        lines.removeAll(Arrays.asList("", null)); // удаляет пустые строки
        String[] data = lines.toArray(new String[0]);
        String[] data2 = new String[data.length];
        String[] arr2 = new String[data2.length];


        for (int f = 0; f < data.length; f++) {
            String sss = data[f];
            numberToBeginning.toBeginner(sss);
            data2[f] = numberToBeginning.toBeginner(sss);
        }

        // Карта для отслеживания количества повторений каждого номера
        Map<String, Integer> counter = new HashMap<>();

        // Итерация по массиву данных и вывод с дополнительной нумерацией
        for (int i = 0; i < data2.length; i++) {
            String entry = data2[i]; // Инициируем новую строку значением из строкового массива(data[])
            String number = entry.split(" ")[0];  // Получаем номер из строки отсекая(.split) текст после первого пробела В квадр. скобках. пишем какую часть оставить из разделенной строки
            int numberInt = Integer.parseInt(number);
            String number2 = String.format("%03d", numberInt);

            // Получаем текущее количество повторений для этого номера
            int count = counter.getOrDefault(number2, 1);

            // Печать номера с количеством в скобках
            String s = number2 + "(" + count + ") " + entry.split(" ", 2)[1]; // limit: на сколько частей разбить строку по пробелу(" "), а в квадр.скоб. с какой части вставить(     из разделенных)
            arr2[i] = s;
            System.out.println(s);

            // Увеличиваем счетчик после вывода
            counter.put(number2, count + 1);
        }

        FileWriter writer = new FileWriter("C:/temp/listNameFileNumbers.txt");
        String str = "";
        for (int i = 0; i < arr2.length - 1; i++) {
            if (arr2[i].charAt(4) == arr2[i + 1].charAt(4)) {
                str = arr2[i].replace("(1)", "");
            } else {
                str = arr2[i];
            }

            System.out.println("str - " + str);
            writer.write(str + System.lineSeparator());
        }
        str = arr2[data.length - 1];
        writer.write(str + System.lineSeparator());
        writer.close();

        renameFilesFromTextFile.rename();
    }
}
