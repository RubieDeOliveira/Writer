package com.margo.AbstractFactory;

import com.margo.Factory.WriterOnFile;
import com.margo.Format.BasicFormat;
import com.margo.Format.ColoredFormat;
import com.margo.Format.Colors.Color;
import com.margo.Format.Format;
import com.margo.Format.Style.Style;
import com.margo.Format.StylizedFormat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.margo.Format.Colors.Color.*;

public class WriterFactoryOnFileTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String text = "Hello World !";
    private String filename = "test" + sdf.format(timestamp);

    @Test
    public final void testItWritesOnFile() {
        Format basicFomat = new BasicFormat();
        WriterOnFile stdOut = new WriterOnFile(basicFomat, filename);
        stdOut.write("Basic text");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("Basic text"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void testItWritesOnFileInRed() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(RED); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Red text");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<p style=\"color: FF0000\">Red text</p>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void testItWritesOnFileInRedAndWhite() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(RED); add(WHITE); }};
        Format format = new ColoredFormat(colors, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Magenta text");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<p style=\"color: FF00FF\">Magenta text</p>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void testItWritesOnFileInBold() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Text in bold style");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<b>Text in bold style</b>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void testItWritesOnFileUnderlined() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, new BasicFormat());
        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Underlined text");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<u>Underlined text</u>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void testItWritesOnFileInBoldAndInYellow() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(YELLOW); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Bold and yellow");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<p style=\"color: FFFF00\"><b>Bold and yellow</b></p>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void testItWritesOnFileInBoldWith2Colors() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(WHITE); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.BOLD); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Bold and cyan");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<b><p style=\"color: 00FFFF\">Bold and cyan</p></b>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public final void testItWritesOnFileUnderlinedAndInGreen() {
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(GREEN); }};
        Format format = new ColoredFormat(colors, stylizedFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Green underlined");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<p style=\"color: 00FF00\"><u>Green underlined</u></p>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public final void testItWritesOnFileUnderlinedWith2Colors() {
        ArrayList<Color> colors = new ArrayList<Color>() {{ add(BLUE); add(YELLOW); }};
        Format coloredFormat = new ColoredFormat(colors, new BasicFormat());

        ArrayList<Style> styles = new ArrayList<Style>() {{ add(Style.UNDERLINE); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        WriterOnFile stdOut = new WriterOnFile(format, filename);
        stdOut.write("Green underlined (yellow + blue)");
        try {
            Assert.assertTrue(new String(Files.readAllBytes(Paths.get(filename + ".html"))).contains("<u><p style=\"color: 00FF00\">Green underlined (yellow + blue)</p></u>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
