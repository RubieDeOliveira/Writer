package test.java.com.margo.Format;

import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.Format;
import main.java.com.margo.Format.Style.Style;
import main.java.com.margo.Format.StylizedFormat;
import main.java.com.margo.Output.Output;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

import static main.java.com.margo.Format.Style.Style.BOLD;
import static main.java.com.margo.Format.Style.Style.UNDERLINE;

public class StylizedFormatTest {

    private String textToWrite = "Hello World !" ;

    //Test on STD output

    @Test
    public final void checkWithBold(){
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<Style>() {{ add(BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(Output.STD);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("\033[1;37m" + textToWrite + "\033[0m"));
    }

    @Test
    public final void checkWithUnderline(){
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<Style>() {{ add(UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(Output.STD);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("\033[4;37m" + textToWrite + "\033[0m"));
    }

    @Test
    public final void checkFileWithBold(){
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(Output.FILE);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("<b>" + textToWrite + "</b>"));
    }

    @Test
    public final void checkFileWithUnderline(){
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(Output.FILE);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("<u>" + textToWrite + "</u>"));
    }

    @Test
    public final void checkFileWithUnderlineAndBold(){
        ArrayList<Style> styles = new ArrayList<Style>() {{ add(UNDERLINE); add(BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(Output.FILE);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("<b><u>" + textToWrite + "</u></b>"));
    }

}
