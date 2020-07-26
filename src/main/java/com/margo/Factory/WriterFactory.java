package main.java.com.margo.Factory;

import main.java.com.margo.Format.Format;
import main.java.com.margo.Output.Output;

public abstract class WriterFactory {
    protected Format format;

    public WriterFactory(Format format, Output output){
        this.format = format;
        this.format.setOutput(output);
    }

    public abstract void write(String text);
}
