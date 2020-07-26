package main.java.com.margo.Format.Colors;

public class ConsoleColor {

    public static String getConsoleColor(main.java.com.margo.Format.Colors.Color color) {
        switch (color) {
            case BLACK -> {
                return "\033[0;30m";
            }
            case RED -> {
                return "\033[0;31m";
            }
            case GREEN -> {
                return "\033[0;32m";
            }
            case YELLOW -> {
                return "\033[0;33m";
            }
            case BLUE -> {
                return "\033[0;34m";
            }
            case MAGENTA -> {
                return "\033[0;35m";
            }
            case CYAN -> {
                return "\033[0;36m";
            }
            case WHITE -> {
                return "\033[0;37m";
            }
            default -> {
                return "\033[0m";
            }
        }
    }
}
