package ru.stiffbeards.chess;

import org.fusesource.jansi.AnsiConsole;

public class Main {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();

        AnsiConsole.out.println("Hello World");
        AnsiConsole.out.println(args[0]);
    }
}
