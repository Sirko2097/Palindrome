package view;

import controller.MenuController;

public class View {
    public void init() {
        MenuController mainMenu = new MenuController();
        mainMenu.printMenu();
    }

    public void printMessage(String message) {
        System.out.println("Result: " + message + '\n');
    }
}
