package com.margo.Factory;

import com.margo.AbstractFactory.AbstractWriterFactory;

public class WriterFactory {

    public static Writer getWriter(AbstractWriterFactory factory){
        return factory.create();
    }
}
