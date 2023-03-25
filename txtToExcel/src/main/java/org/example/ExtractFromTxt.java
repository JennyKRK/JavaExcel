package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class ExtractFromTxt {
    private String filepath;

    public ExtractFromTxt(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList dataFromTxt() throws IOException {
        File file = new File (filepath);
        ArrayList result = new ArrayList<String>();
        String line = "";
        BufferedReader reader = Files.newBufferedReader(file.toPath());
         while ((line = reader.readLine()) != null){
            result.add(line);
        }
         return result;
    }

    public ArrayList datafromTxtMoreDetails(ArrayList<String> extract){
        File file = new File (filepath);
        ArrayList<String> result = new ArrayList<String>();

        extract.stream().
                filter(line-> line.contains("it")).
                map(line -> line.toUpperCase()).
                forEach(line -> result.add(line));

        return result;
    }
}


