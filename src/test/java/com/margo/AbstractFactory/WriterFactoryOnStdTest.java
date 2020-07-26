package com.margo.AbstractFactory;

import main.java.com.margo.Factory.WriterOnStandardOutput;
import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.ColoredFormat;
import main.java.com.margo.Format.Colors.Color;
import main.java.com.margo.Format.Format;
import main.java.com.margo.Format.Style.Style;
import main.java.com.margo.Format.StylizedFormat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.java.com.margo.Format.Colors.Color.*;

public class WriterFactoryOnStdTest {
    private String text = "Hello World !";

    @Test
    public final void testItWritesOnStdOutput() {
        Format basicFomat = new BasicFormat();
        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(basicFomat);
        stdOut.write(text);
    }

    @Test
    public final void testItWritesOnStdOutputInRed() {
        ArrayList<Color> colors = new ArrayList<>() {{ add(RED); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }

    @Test
    public final void testItWritesOnStdOutputInRedAndWhite() {
        ArrayList<Color> colors = new ArrayList<>() {{ add(RED); add(WHITE); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }

    @Test
    public final void testItWritesOnStdOutputInBold() {
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }

    @Test
    public final void testItWritesOnStdOutputUnderlined() {
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }

    @Test
    public final void testItWritesOnStdOutputInBoldAndInGreen() {
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(Style.BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<>() {{ add(RED); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }

    @Test
    public final void testItWritesOnStdOutputInBoldWith2Colors() {
        ArrayList<Color> colors = new ArrayList<>() {{ add(BLUE); add(WHITE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }


    @Test
    public final void testItWritesOnStdOutputUnderlinedAndInGreen() {
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(Style.UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<>() {{ add(GREEN); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }


    @Test
    public final void testItWritesOnStdOutputUnderlinedWith2Colors() {
        ArrayList<Color> colors = new ArrayList<>() {{ add(BLUE); add(YELLOW); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        main.java.com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write(text);
    }
}
