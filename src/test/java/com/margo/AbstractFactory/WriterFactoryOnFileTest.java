package com.margo.AbstractFactory;

import main.java.com.margo.Factory.WriterOnFile;
import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.ColoredFormat;
import main.java.com.margo.Format.Colors.Color;
import main.java.com.margo.Format.Format;
import main.java.com.margo.Format.Style.Style;
import main.java.com.margo.Format.StylizedFormat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.java.com.margo.Format.Colors.Color.*;

public class WriterFactoryOnFileTest {
    private String text = "Hello World !";
    private String filename = "test";

    @Test
    public final void testItWritesOnFile() {
        Format basicFomat = new BasicFormat();
        WriterOnFile stdOut = new WriterOnFile(basicFomat, filename);
        stdOut.write("Basic text");
    }

    @Test
    public final void testItWritesOnFileInRed() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(RED); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Red text");
    }

    @Test
    public final void testItWritesOnFileInRedAndWhite() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(RED); add(WHITE); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Magenta text");
    }

    @Test
    public final void testItWritesOnFileInBold() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Text in bold style");
    }

    @Test
    public final void testItWritesOnFileUnderlined() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Underlined text");
    }

    @Test
    public final void testItWritesOnFileInBoldAndInYellow() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(YELLOW); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Bold and yellow");
    }

    @Test
    public final void testItWritesOnFileInBoldWith2Colors() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(WHITE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Bold and cyan");
    }


    @Test
    public final void testItWritesOnFileUnderlinedAndInGreen() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(GREEN); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Green underlined");
    }


    @Test
    public final void testItWritesOnFileUnderlinedWith2Colors() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(YELLOW); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Green underlined (yellow + blue)");
    }
}
