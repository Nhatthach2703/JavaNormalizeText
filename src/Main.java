
import Controller.TextNormalizer;
import Model.Text;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Xuan Vinh
 */
public class Main {
    public static void main(String[] args) {
        Text text = new Text();
        new TextNormalizer(text).run();
    }
}
