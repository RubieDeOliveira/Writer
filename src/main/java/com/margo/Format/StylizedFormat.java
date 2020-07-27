package com.margo.Format;

import com.margo.Format.Style.Style;

import java.util.ArrayList;

import static com.margo.Format.Colors.Color.DEFAULT;
import static com.margo.Format.Colors.ConsoleColor.getConsoleColor;
import static com.margo.Output.Output.STD;

public class StylizedFormat extends Format {
    // supported : Bold, underline
    private ArrayList<com.margo.Format.Style.Style> styles;

    public StylizedFormat(ArrayList<Style> styles, Format format){
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

    private String getStyle(Style style, String text){
        if (style == Style.BOLD){
            return "<b>" + text + "</b>";
        }
        return "<u>" + text + "</u>";
    }

    @Override
    public String toFormat(String text) {
        this.internalFormat.setOutput(this.output);
        String result = this.internalFormat.toFormat(text);

        if (this.output == STD){
            return treatStyleOnConsole(result);
        }

        for (Style style : styles){
            result = getStyle(style, result);
        }

        return result;
    }
}
