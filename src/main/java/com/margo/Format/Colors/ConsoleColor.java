package com.margo.Format.Colors;

public class ConsoleColor {

    public static String getConsoleColor(com.margo.Format.Colors.Color color) {
        if (color == Color.BLACK) { return "\033[0;30m"; }
        else if (color == Color.RED) { return "\033[0;31m"; }
        else if (color == Color.GREEN) { return "\033[0;32m"; }
        else if (color == Color.YELLOW) { return "\033[0;33m"; }
        else if (color == Color.BLUE) { return "\033[0;34m"; }
        else if (color == Color.MAGENTA) { return "\033[0;35m"; }
        else if (color == Color.CYAN) { return "\033[0;36m"; }
        else if (color == Color.WHITE) { return "\033[0;37m"; }
        return "\033[0m";
    }
}
