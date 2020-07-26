package main.java.com.margo.AbstractFactory;

import main.java.com.margo.Factory.WriterFactory;
import main.java.com.margo.Factory.WriterOnFile;
import main.java.com.margo.Format.Format;

public class WriterFactoryOnFile extends AbstractWriterFactory{
    private String filename;

    public WriterFactoryOnFile(Format format, String filename) {
        super(format);
        this.filename = filename;
    }

    @Override
    public WriterFactory create() {
        return new WriterOnFile(this.format, this.filename);
    }
}
