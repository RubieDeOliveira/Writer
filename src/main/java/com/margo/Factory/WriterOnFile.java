package main.java.com.margo.Factory;

import main.java.com.margo.Format.Format;
import main.java.com.margo.Output.Output;

import java.io.FileWriter;
import java.io.IOException;

public class WriterOnFile extends WriterFactory{
    private String filePath;

    public WriterOnFile(Format format, String filePath) {
        super(format, Output.FILE);
        this.filePath = filePath;
    }

    @Override
    public void write(String text) {
        String textToWrite = this.format.toFormat(text);
        try {
            FileWriter myWriter = new FileWriter(this.filePath);
            myWriter.write(textToWrite);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
