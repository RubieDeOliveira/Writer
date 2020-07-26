package main.java.com.margo.AbstractFactory;

import main.java.com.margo.Factory.WriterFactory;
import main.java.com.margo.Format.Format;

public abstract  class AbstractWriterFactory {
    protected Format format;

    public AbstractWriterFactory(Format format){
        this.format = format;
    }

    public abstract WriterFactory create();
}
