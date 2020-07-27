package com.margo.Format;

import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.ColoredFormat;
import main.java.com.margo.Format.Colors.Color;
import main.java.com.margo.Format.Format;
import main.java.com.margo.Format.Style.Style;
import main.java.com.margo.Format.StylizedFormat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.java.com.margo.Format.Colors.Color.BLUE;

public class FormatTest {

    private String textToWrite = "Hello World !" ;

    //Test on STD output

    @Test
    public final void testWithTwoFormats(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, coloredFormat);
        stylizedFormat.setOutput(main.java.com.margo.Output.Output.STD);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("\033[1;34m" + textToWrite + "\033[0m"));
    }
}
