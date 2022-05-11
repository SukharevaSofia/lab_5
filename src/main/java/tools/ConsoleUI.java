package tools;

import java.io.BufferedReader;
import java.util.Scanner;


public final class ConsoleUI {
    public static Scanner reader = new Scanner(System.in);
    public static BufferedReader bufferedReader;

    /**
     * ConsoleUI приветствие при запуске
     */
    public static final void greeting() {
        message("Введите 'help' чтобы узнать список доступных команд.");
        message("Введите 'exit' чтобы выйти.");
    }
/*
    /**
     * Подсказки для пользователя

    public static final void prompt() {
        output("> ");
    }
    */

    /**
     * Выводит нужный объект
     * строка начинается с "Системное сообщение:"
     * для облегчения понимания
     */
    public static final void message(Object obj) {
        output("Системное сообщение: " + obj);
    }

    /**
     * Выводит нужный объект
     * строка начинается с "Ошибка:"
     * для облегчения понимания
     */
    public static final void error(Object obj) {
        output("Ошибка:" + obj);
    }

    /**
     * Функция, через которую выводится весь текст
     */
    public static final void output(String str ) {
        System.out.println(str);
    }


}
