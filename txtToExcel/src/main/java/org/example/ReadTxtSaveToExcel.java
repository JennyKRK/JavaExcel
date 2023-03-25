package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class ReadTxtSaveToExcel {

    public static void main(String[] args) throws IOException {

        String path1 = "src\\main\\java\\org\\example\\textFile.txt";


        File file = new File (path1);
        String line = "";




        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Number");

        headerCell = header.createCell(1);
        headerCell.setCellValue("Name");

        BufferedReader reader = Files.newBufferedReader(file.toPath());
        int i = 1;
        while ((line = reader.readLine()) != null){

            Row rowI = sheet.createRow(i);
            Cell cellI = rowI.createCell(0);
            Cell cellII = rowI.createCell(1);
            cellI.setCellValue(i);
            cellII.setCellValue(line);
            i = i +1;
            System.out.println(line);

            }




        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = "src\\main\\java\\org\\example\\result.xlsx";


        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();

        //https://www.baeldung.com/java-microsoft-excel
    }
}

