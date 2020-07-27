package com.margo.AbstractFactory;

import com.margo.Factory.WriterOnStandardOutput;
import com.margo.Format.BasicFormat;
import com.margo.Format.ColoredFormat;
import com.margo.Format.Colors.Color;
import com.margo.Format.Format;
import com.margo.Format.Style.Style;
import com.margo.Format.StylizedFormat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.margo.Format.Colors.Color.*;

public class WriterFactoryOnStdTest {
    private String text = "Hello World !";

    @Test
    public final void testItWritesOnStdOutput() {
        Format basicFomat = new BasicFormat();
        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(basicFomat);
        stdOut.write("Basic text");
    }

    @Test
    public final void testItWritesOnStdOutputInRed() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(RED); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Red text");
    }

    @Test
    public final void testItWritesOnStdOutputInRedAndWhite() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(RED); add(WHITE); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Magenta text");
    }

    @Test
    public final void testItWritesOnStdOutputInBold() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Text in bold style");
    }

    @Test
    public final void testItWritesOnStdOutputUnderlined() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Underlined text");
    }

    @Test
    public final void testItWritesOnStdOutputInBoldAndInYellow() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(YELLOW); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Bold and yellow");
    }

    @Test
    public final void testItWritesOnStdOutputInBoldWith2Colors() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(WHITE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Bold and cyan");
    }


    @Test
    public final void testItWritesOnStdOutputUnderlinedAndInGreen() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(GREEN); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Green underlined");
    }


    @Test
    public final void testItWritesOnStdOutputUnderlinedWith2Colors() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(YELLOW); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        com.margo.Factory.WriterOnStandardOutput stdOut = new WriterOnStandardOutput(format);
        stdOut.write("Green underlined (yellow + blue)");
    }
}
