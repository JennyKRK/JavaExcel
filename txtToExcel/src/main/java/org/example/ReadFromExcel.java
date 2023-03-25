package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFromExcel {

    public static void main(String[] args) throws IOException {
        String path = "src\\main\\java\\org\\example\\excelToRead.xlsx";
        System.out.println(readToMap(path));
    }

    public static Map readToMap(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, String> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {

                    case NUMERIC:  break;
                    case BOOLEAN: break;
                    case FORMULA: break;
                    case STRING:
                        data.put(i,cell.getRichStringCellValue().getString());
                }
            }
            i++;
        }
        return data;
    }



}
