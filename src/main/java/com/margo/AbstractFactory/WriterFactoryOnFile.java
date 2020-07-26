package main.java.com.margo.AbstractFactory;

import main.java.com.margo.Factory.WriterFactory;
import main.java.com.margo.Factory.WriterOnFile;
import main.java.com.margo.Format.Format;

public class WriterFactoryOnFile extends AbstractWriterFactory{
    private String filePath;

    public WriterFactoryOnFile(Format format, String filePath) {
        super(format);
        this.filePath = filePath;
    }

    @Override
    public WriterFactory create() {
        return new WriterOnFile(this.format, this.filePath);
    }
}
