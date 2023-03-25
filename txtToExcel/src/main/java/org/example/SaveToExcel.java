package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveToExcel {
    private ArrayList<String> dataToExtract;
    private String destinationFile;


    public String getDestinationFile() {
        return destinationFile;
    }

    public ArrayList<String> getDataToExtract() {
        return dataToExtract;
    }

    public void setDataToExtract(ArrayList<String> dataToExtract) {
        this.dataToExtract = dataToExtract;
    }

    public void setDestinationFile(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    public SaveToExcel(ArrayList<String> dataToExtract, String destinationFile) {
        this.dataToExtract = dataToExtract;
        this.destinationFile = destinationFile;
    }

    public void saveExtractToExcel() throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("DataFromTxt");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("ID");

        headerCell = header.createCell(1);
        headerCell.setCellValue("Name and Surname");

        for (int i = 0; i < dataToExtract.size(); i++){
            Row rowI = sheet.createRow(i+1);
            Cell cellI = rowI.createCell(0);
            Cell cellII = rowI.createCell(1);
            cellI.setCellValue(i+1);
            cellII.setCellValue(dataToExtract.get(i));
        }

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = destinationFile;

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();


    }
}
