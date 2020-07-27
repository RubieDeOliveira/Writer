package com.margo.AbstractFactory;

import com.margo.Factory.WriterOnFile;
import com.margo.Format.Format;

public class WriterFactoryOnFile extends AbstractWriterFactory{
    private String filename;

    public WriterFactoryOnFile(Format format, String filename) {
        super(format);
        this.filename = filename;
    }

    @Override
    public com.margo.Factory.Writer create() {
        return new WriterOnFile(this.format, this.filename);
    }
}
