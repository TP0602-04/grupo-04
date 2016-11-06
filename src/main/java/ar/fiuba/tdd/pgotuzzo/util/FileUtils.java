package ar.fiuba.tdd.pgotuzzo.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {

    public static String readFile(String url) {
        Path path = FileSystems.getDefault().getPath(url);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            lines.forEach(stringBuilder::append);
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
