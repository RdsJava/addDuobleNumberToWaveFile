package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RenameFilesFromTextFile {

    public void rename() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("C:/temp/listNameFileNumbers.txt"), StandardCharsets.UTF_8);
        String[] data = lines.toArray(new String[0]);

        // 1. взять строку из текстового файла и откинуть номер (.split) оставить только текст после номера
        for (int i = 0; i < data.length; i++) {
            String entry = data[i]; // Инициируем новую строку значением из строкового массива(data[])
            String number = entry.split(" ")[0];
            System.out.println("number " + number);
            String NameFile = entry.split(" ", 2)[1];
            System.out.println("NameFile-" + NameFile);

            // 2. найти файл одноименный из п.1 в папке с wav. файлами

            Path source = Paths.get("C:/temp/" + NameFile + ".BMP");

            Files.move(source, source.resolveSibling("C:/temp/" + number + " " + NameFile + ".BMP"));

            // 3. переименовать файл

        }
    }
}




