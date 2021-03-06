package com.margo;

import com.margo.AbstractFactory.WriterFactoryOnFile;
import com.margo.AbstractFactory.WriterFactoryOnStandardOutput;
import com.margo.Factory.Writer;
import com.margo.Factory.WriterFactory;
import com.margo.Format.BasicFormat;
import com.margo.Format.ColoredFormat;
import com.margo.Format.Colors.Color;
import com.margo.Format.Format;
import com.margo.Format.Style.Style;
import com.margo.Format.StylizedFormat;

import java.util.ArrayList;

import static com.margo.Format.Colors.Color.CYAN;
import static com.margo.Format.Colors.Color.YELLOW;
import static com.margo.Format.Style.Style.BOLD;
import static com.margo.Format.Style.Style.UNDERLINE;

public class Main {

    public static void main(String[] args) {
        Format basicFormat = new BasicFormat();
        Format basicFormatStd = new BasicFormat();

        ArrayList<Color> colors = new ArrayList<Color>() {{ add(CYAN); }};
        Format coloredFormat = new ColoredFormat(colors, basicFormat);
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(BOLD); }};
        Format format = new StylizedFormat(styles, coloredFormat);

        ArrayList<Color> colorsStd = new ArrayList<Color>() {{ add(YELLOW); }};
        Format coloredFormatStd = new ColoredFormat(colorsStd, basicFormatStd);
        ArrayList<Style> stylesStd = new ArrayList<Style>() {{ add(UNDERLINE); }};
        Format formatStd = new StylizedFormat(stylesStd, coloredFormatStd);


        Writer writerOnStandardOutput = WriterFactory.getWriter(
                new WriterFactoryOnStandardOutput(formatStd));
        Writer writerOnFile = WriterFactory.getWriter(
                new WriterFactoryOnFile(format, "file1"));


        String textToWrite = "Hello World !";
        writerOnFile.write(textToWrite);
        writerOnStandardOutput.write(textToWrite);
    }
}
