package main.java.com.margo.Format;

import main.java.com.margo.Format.Colors.Color;

import java.util.ArrayList;

import static com.margo.Format.Colors.FileColor.getFileColor;
import static main.java.com.margo.Format.Colors.Color.DEFAULT;
import static com.margo.Format.Colors.ConsoleColor.getConsoleColor;
import static main.java.com.margo.Output.Output.FILE;
import static main.java.com.margo.Output.Output.STD;

public class ColoredFormat extends Format {
    // supported colors :  Black, White, red, green, blue, yellow, magenta, cyan

    private Color color;

    public ColoredFormat(ArrayList<Color> colors, Format format){
        this.internalFormat = format;
        this.color = mixedColor(colors);
    }

    private Color mixedColor(ArrayList<Color> colors){
        if (colors.contains(Color.BLACK)){
            // white because terminal is black
            return  Color.WHITE;
        }
        if (colors.size() >= 2) {
            if (colors.contains(Color.WHITE) && colors.contains(Color.BLUE)) {
                return Color.CYAN;
            }
            if (colors.contains(Color.WHITE) && colors.contains(Color.RED)) {
                return Color.MAGENTA;
            }
            if (colors.contains(Color.BLUE) && colors.contains(Color.YELLOW)) {
                return Color.GREEN;
            }
            else {
                return colors.get(0);
            }
        }
        return colors.get(0);
    }

    @Override
    public String toFormat(String text) {
        this.internalFormat.setOutput(this.output);
        String tmp = this.internalFormat.toFormat(text);

        if (this.output == STD){
            if (tmp.startsWith("\033[")){
                String rightColor = getConsoleColor(color).substring(4, 6);
                return tmp.replaceAll(";\\d+m", ";" + rightColor + "m");
            }
            return getConsoleColor(color) + tmp + getConsoleColor(DEFAULT);
        }
        // text file by default for start
        return  "<p style=\"color: " + getFileColor(color)+"\">"+ tmp + "</p>";
    }


}
