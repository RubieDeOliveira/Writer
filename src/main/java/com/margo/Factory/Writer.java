package com.margo.Factory;

import com.margo.Format.Format;
import com.margo.Output.Output;

public abstract class Writer {
    protected Format format;

    public Writer(Format format, Output output){
        this.format = format;
        this.format.setOutput(output);
    }

    public abstract void write(String text);
}
