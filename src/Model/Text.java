/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Xuan Vinh
 */
public class Text {
    public String normalizeText(String input) {
        String[] lines = input.split("\n");

        StringBuilder str = new StringBuilder();

        boolean isFirstLine = true;

        for (String line : lines) {
            line = line.trim();

            if (!line.isEmpty()) {
                if (!isFirstLine) {
                    str.append(" ");
                }

                line = normalizeLine(line);

                str.append(line);
                isFirstLine = false;
            }
        }

        str.append(".");

        return str.toString();
    }

    private String normalizeLine(String line) {
        line = line.replaceAll("\\s+", " ");

        line = line.replaceAll("\\s*,\\s*", ", ");
        line = line.replaceAll("\\s*\\.\\s*", ".");
        line = line.replaceAll("\\s*:\\s*", ": ");

        line = capitalizeFirstCharacter(line);

        line = line.replaceAll("\\s*\"\\s*", "\"");

        return line;
    }

    private String capitalizeFirstCharacter(String line) {
        Pattern pattern = Pattern.compile("(^|\\.[\\s\"])([a-z])");
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1) + matcher.group(2).toUpperCase());
        }

        matcher.appendTail(result);

        return result.toString();
    }
}
