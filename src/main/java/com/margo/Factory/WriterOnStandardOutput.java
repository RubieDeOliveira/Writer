package com.margo.Factory;

import com.margo.Format.Format;
import com.margo.Output.Output;

public class WriterOnStandardOutput extends Writer{

    public WriterOnStandardOutput(Format format) {
        super(format, Output.STD);
    }

    @Override
    public void write(String text) {
        String textToWrite = this.format.toFormat(text);
        System.out.println(textToWrite);
    }
}
