package test.java.com.margo.Format;

import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.ColoredFormat;
import main.java.com.margo.Format.Format;
import main.java.com.margo.Format.StylizedFormat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.java.com.margo.Format.Style.Style.BOLD;
import static main.java.com.margo.Format.Style.Style.UNDERLINE;

public class StylizedFormatTest {

    private String textToWrite = "Hello World !" ;

    //Test on STD output

    @Test
    public final void checkWithBold(){

        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(BOLD); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(main.java.com.margo.Output.Output.STD);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("\033[1;37m" + textToWrite + "\033[0m"));
    }

    @Test
    public final void checkWithUnderline(){
        ArrayList<main.java.com.margo.Format.Style.Style> styles = new ArrayList<>() {{ add(UNDERLINE); }};
        Format stylizedFormat = new StylizedFormat(styles, new BasicFormat());
        stylizedFormat.setOutput(main.java.com.margo.Output.Output.STD);

        String formatedString = stylizedFormat.toFormat(textToWrite);
        Assert.assertFalse(formatedString.equals(textToWrite));
        Assert.assertTrue(formatedString.equals("\033[4;37m" + textToWrite + "\033[0m"));
    }


}
