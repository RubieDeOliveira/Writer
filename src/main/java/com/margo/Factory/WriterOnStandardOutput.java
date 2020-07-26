package main.java.com.margo.Factory;

import main.java.com.margo.Format.Format;
import main.java.com.margo.Output.Output;

public class WriterOnStandardOutput extends WriterFactory{

    public WriterOnStandardOutput(Format format) {
        super(format, Output.STD);
    }

    @Override
    public void write(String text) {
        String textToWrite = this.format.toFormat(text);
        System.out.println(textToWrite);
    }
}
