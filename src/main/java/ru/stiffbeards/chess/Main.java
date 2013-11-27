package ru.stiffbeards.chess;

import org.fusesource.jansi.AnsiConsole;

public class Main {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();

        Desk desk = new Desk();
        for (String arg: args) {
            try {
                desk.move(arg);
            } catch (Exception e) {
                AnsiConsole.out.println(e.getMessage());
            }
        }

        AnsiConsole.out.println(desk.dump());
    }
}
