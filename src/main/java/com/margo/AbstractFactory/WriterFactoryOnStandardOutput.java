package com.margo.AbstractFactory;

import com.margo.Factory.WriterOnStandardOutput;
import com.margo.Format.Format;

public class WriterFactoryOnStandardOutput extends AbstractWriterFactory{

    public WriterFactoryOnStandardOutput(Format format) {
        super(format);
    }

    @Override
    public com.margo.Factory.Writer create() {
        return new WriterOnStandardOutput(this.format);
    }
}
