package main.java.com.margo.Factory;

import main.java.com.margo.Format.Format;
import main.java.com.margo.Output.Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class WriterOnFile extends WriterFactory{
    private String filename;

    public WriterOnFile(Format format, String filename) {
        super(format, Output.FILE);
        this.filename = filename;
    }

    @Override
    public void write(String text){
        String textToWrite = "";
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(new File(this.filename + ".html"), true);

            textToWrite = "<html>" + this.format.toFormat(text) + "</html>";

            out.write(textToWrite.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
