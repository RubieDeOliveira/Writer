package com.margo.AbstractFactory;

import com.margo.Factory.Writer;
import com.margo.Factory.WriterOnFile;
import com.margo.Format.Format;

public class WriterFactoryOnFile implements IAbstractWriterFactory {
    private String filename;
    private Format format;

    public WriterFactoryOnFile(Format format, String filename) {
        this.format = format;
        this.filename = filename;
    }

    @Override
    public Writer create() {
        return new WriterOnFile(this.format, this.filename);
    }
}
