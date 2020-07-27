package com.margo.Format;

public class BasicFormat extends Format {

    public BasicFormat(){
        this.internalFormat = null;
    }

    @Override
    public String toFormat(String text) {
        return text;
    }

}
