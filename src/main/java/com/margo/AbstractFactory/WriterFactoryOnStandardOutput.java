package main.java.com.margo.AbstractFactory;

import main.java.com.margo.Factory.WriterFactory;
import main.java.com.margo.Factory.WriterOnStandardOutput;
import main.java.com.margo.Format.Format;

public class WriterFactoryOnStandardOutput extends AbstractWriterFactory{

    public WriterFactoryOnStandardOutput(Format format) {
        super(format);
    }

    @Override
    public WriterFactory create() {
        return new WriterOnStandardOutput(this.format);
    }
}
