package ru.goryainov.tm;

import java.util.Scanner;

import static ru.goryainov.tm.constant.TerminalConst.*;

/**
 * Тестовое приложение с поддержкой аргументов запуска
 */

public class App {

    /**
     * Точка входа
     *
     * @param args параметры запуска
     */
    public static void main(final String[] args) {
        run(args);
        displayWelcome();
        final Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!EXIT.equals(command)) {
            command = scanner.nextLine();
            run(command);
        }
    }

    /**
     * Запуск приложения
     *
     * @param args массив параметров запуска
     */
    private static void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    /**
     * Запуск приложения
     *
     * @param param параметр запуска
     */
    private static int run(final String param) {
        if (param == null) return -1;
        switch (param) {
            case VERSION:
                return displayVersion();
            case ABOUT:
                return displayAbout();
            case HELP:
                return displayHelp();
            case EXIT:
                return displayExit();
            default:
                return displayError();
        }
    }

    /**
     * Вывод сведений о разработчике
     */
    private static int displayAbout() {
        System.out.println("Andrey Goryainov");
        System.out.println("goryainov_aa@nlmk.ru");
        return 0;
    }

    /**
     * Вывод версии
     */
    private static int displayVersion() {
        System.out.println("1.0.0");
        return 0;
    }

    /**
     * Вывод списка возможных параметров запуска
     */
    private static int displayHelp() {
        System.out.println("version - Display application version.");
        System.out.println("about - Display developer info.");
        System.out.println("help - Display list of commands.");
        System.out.println("exit - Terminate console application.");
        return 0;
    }

    /**
     * Вывод приветствия
     */
    private static void displayWelcome() {
        System.out.println("-= WELCOME TO TASK MANAGER =-");
    }

    /**
     * Вывод ошибки при вводе параметра запуска не из списка
     */
    private static int displayError() {
        System.out.println("Error! Unknown program argument...");
        return -1;
    }

    /**
     * Вывод завершения приложения
     */
    private static int displayExit() {
        System.out.println("Terminate program...");
        return 0;
    }
}
