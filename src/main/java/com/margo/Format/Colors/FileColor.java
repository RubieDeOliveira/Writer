package com.margo.Format.Colors;

public class FileColor {

    public static String getFileColor(main.java.com.margo.Format.Colors.Color color) {
        if (color == main.java.com.margo.Format.Colors.Color.RED) { return "FF0000"; }
        else if (color == main.java.com.margo.Format.Colors.Color.GREEN) { return "00FF00"; }
        else if (color == main.java.com.margo.Format.Colors.Color.YELLOW) { return "FFFF00"; }
        else if (color == main.java.com.margo.Format.Colors.Color.BLUE) { return "0000FF"; }
        else if (color == main.java.com.margo.Format.Colors.Color.MAGENTA) { return "FF00FF"; }
        else if (color == main.java.com.margo.Format.Colors.Color.CYAN) { return "00FFFF"; }
        else if (color == main.java.com.margo.Format.Colors.Color.WHITE) { return "FFFFFF"; }
        return "000000";
    }
}
