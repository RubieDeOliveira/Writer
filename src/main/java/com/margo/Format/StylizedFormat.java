package main.java.com.margo.Format;

import main.java.com.margo.Format.Format;
import main.java.com.margo.Format.Style.Style;

import java.util.ArrayList;

import static main.java.com.margo.Format.Colors.Color.DEFAULT;
import static main.java.com.margo.Format.Colors.ConsoleColor.getConsoleColor;

public class StylizedFormat extends Format {
    // supported : Bold, underline
    private ArrayList<main.java.com.margo.Format.Style.Style> styles;

    public StylizedFormat(ArrayList<main.java.com.margo.Format.Style.Style> styles, Format format){
        this.internalFormat = format;
        this.styles = styles;
    }

    // Can't combine bold and underline on std output
    private String treatStyleOnConsole(String text){
        if (styles.get(0) == Style.BOLD){
            if (text.contains("\033[0;3")){
                return text.replace("\033[0;3", "\033[1;3");
            }
            return "\033[1;37m" + text + getConsoleColor(DEFAULT);
        }
        else if (styles.get(0) == Style.UNDERLINE){
            if (text.contains("\033[0;3")){
                return text.replace("\033[0;3", "\033[4;3");
            }
            return "\033[4;37m" + text + getConsoleColor(DEFAULT);
        }
        return text;
    }

    @Override
    public String toFormat(String text) {
        this.internalFormat.setOutput(this.output);

        switch (this.output) {
            case STD -> {
                String tmp = this.internalFormat.toFormat(text);
                return treatStyleOnConsole(tmp);
            }
            // text file by default for start
            default -> {
                return text;
            }
        }
    }
}
