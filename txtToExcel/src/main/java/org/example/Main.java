package org.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src\\main\\java\\org\\example\\textFile.txt";
        String destinationFile = "src\\main\\java\\org\\example\\result.xlsx";
        String pathPoem = "src\\main\\java\\org\\example\\poem.txt";
        String destinationExcelPoem = "src\\main\\java\\org\\example\\resultPoem.xlsx";
        ExtractFromTxt extractFromTxt = new ExtractFromTxt(path);
        ExtractFromTxt extractFromPoem = new ExtractFromTxt(pathPoem);

        ArrayList<String> extractedData = extractFromTxt.dataFromTxt();
        ArrayList<String> allLinesForPoem = extractFromPoem.dataFromTxt();
        ArrayList<String> extractedLinesForPoem = extractFromPoem.datafromTxtMoreDetails(allLinesForPoem );

        SaveToExcel saveToExcel = new SaveToExcel(extractedData, destinationFile);
        saveToExcel.saveExtractToExcel();

        SaveToExcel saveToExcel2  = new SaveToExcel(extractedLinesForPoem, destinationExcelPoem);
        saveToExcel2.saveExtractToExcel();
    }
}