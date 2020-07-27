package com.margo.Factory;

import com.margo.AbstractFactory.IAbstractWriterFactory;

public class WriterFactory {

    public static Writer getWriter(IAbstractWriterFactory factory){
        return factory.create();
    }
}
