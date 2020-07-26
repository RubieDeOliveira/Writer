package test.java.com.margo.Format;

import main.java.com.margo.Format.BasicFormat;
import main.java.com.margo.Format.Format;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BasicFormatTest {
    private Format basicFormat = new BasicFormat();
    private String textToWrite = "Hello World !" ;

    @Test
    public final void checkThereIsNotStyleNeitherColor(){
        String formatedString = basicFormat.toFormat(textToWrite);
        Assert.assertTrue(formatedString.equals(textToWrite));
    }
}
