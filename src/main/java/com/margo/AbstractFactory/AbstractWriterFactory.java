package com.margo.AbstractFactory;

import com.margo.Format.Format;

// TODO : see how to call the abstract factory
public abstract  class AbstractWriterFactory {
    protected Format format;

    public AbstractWriterFactory(Format format){
        this.format = format;
    }

    public abstract com.margo.Factory.Writer create();
}
