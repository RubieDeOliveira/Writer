package com.margo.Format;

import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.ColoredFormat;
import main.java.com.margo.Format.Colors.Color;
import main.java.com.margo.Format.Format;
import main.java.com.margo.Output.Output;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.java.com.margo.Format.Colors.Color.*;

public class ColoredFormatTest {

    private String textToWrite = "Hello World !" ;

    //Test on STD output

    @Test
    public final void checkWithOnColor(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());
        coloredFormat.setOutput(Output.STD);

        String formatedString = coloredFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("\033[0;34m" + textToWrite + "\033[0m"));
    }

    @Test
    public final void checkWithTwoColorsWithBlack(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(BLACK); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());
        coloredFormat.setOutput(Output.STD);

        String formatedString = coloredFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals("\033[0;30m" + textToWrite + "\033[0m"));
    }

    @Test
    public final void checkWithTwoColorsBlueAndYellow(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(YELLOW); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());
        coloredFormat.setOutput(Output.STD);

        String formatedString = coloredFormat.toFormat(textToWrite);
        //Assert.assertFalse(formatedString.equals("\033[0;32m" + textToWrite + "\033[0m"));
    }

    //Test on FILE output

    @Test
    public final void checkFileWithOnColor(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());
        coloredFormat.setOutput(Output.FILE);

        String formatedString = coloredFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("<p style=\"color: 0000FF\">" + textToWrite + "</p>"));
    }

    @Test
    public final void checkFileWithTwoColorsWithBlack(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(BLACK); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());
        coloredFormat.setOutput(Output.FILE);

        String formatedString = coloredFormat.toFormat(textToWrite);
        System.out.println(formatedString);
        Assert.assertTrue(formatedString.equals("<p style=\"color: FFFFFF\">" + textToWrite + "</p>"));
    }

    @Test
    public final void checkFileWithTwoColorsBlueAndYellow(){

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(YELLOW); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());
        coloredFormat.setOutput(Output.FILE);

        String formatedString = coloredFormat.toFormat(textToWrite);
        Assert.assertTrue(formatedString.equals("<p style=\"color: 00FF00\">" + textToWrite + "</p>"));
    }
}
