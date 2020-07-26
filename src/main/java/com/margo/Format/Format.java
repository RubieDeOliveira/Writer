package main.java.com.margo.Format;

import main.java.com.margo.Output.Output;

public abstract class Format {
    protected Format internalFormat;
    //later init
    protected Output output;

    public void setOutput(Output output) {
        this.output = output;
    }

    public abstract String toFormat(String text);
}
