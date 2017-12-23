package controller;

import service.Manacher;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {
    private Manacher manacher;
    private View view = new View();
    public void example() {
        String string = "\"Maps DNA and spam\" is a palindrome with 14 characters.";
        System.out.println("\nExample: " + string);
        manacher = new Manacher(string.trim().toLowerCase());
        view.printMessage(manacher.findLongestPalindrome());
    }

    public void userString(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("\nInput string: ");
            String str = reader.readLine();
            manacher = new Manacher(str.toLowerCase().trim());
            view.printMessage(manacher.findLongestPalindrome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


