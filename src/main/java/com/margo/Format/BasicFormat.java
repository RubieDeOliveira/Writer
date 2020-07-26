package main.java.com.margo.Format;

import main.java.com.margo.Format.Format;
import main.java.com.margo.Output.Output;

public class BasicFormat extends Format {

    public BasicFormat(){
        this.internalFormat = null;
    }

    @Override
    public String toFormat(String text) {
        return text;
    }

}
