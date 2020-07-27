package com.margo.AbstractFactory;

import com.margo.Factory.Writer;
import com.margo.Factory.WriterOnStandardOutput;
import com.margo.Format.Format;

public class WriterFactoryOnStandardOutput implements IAbstractWriterFactory {
    private Format format;

    public WriterFactoryOnStandardOutput(Format format) {
        this.format = format;
    }

    @Override
    public Writer create() {
        return new WriterOnStandardOutput(this.format);
    }
}
