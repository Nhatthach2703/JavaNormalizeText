/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Text;
import View.Menu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Xuan Vinh
 */
public class TextNormalizer extends Menu<String>{
    static String[] mc = {"Normalize Text", "Exit"};
    private Text model;

    public TextNormalizer(Text model) {
        super("NORMALIZE TEXT PROGRAMMING", mc);
        this.model = model;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                normalizeText("src\\input.txt", "src\\output.txt");
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
    
    public void normalizeText(String inputFilePath, String outputFilePath) {
        try {
            String inputText = readFile(inputFilePath);

            String normalizedText = model.normalizeText(inputText);

            writeFile(outputFilePath, normalizedText);

            System.out.println("Text normalization completed!!! Output file was saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred when : " + e.getMessage());
        }
    }

    private String readFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

    private void writeFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}
