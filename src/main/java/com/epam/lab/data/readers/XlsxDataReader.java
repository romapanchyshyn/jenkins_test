package com.epam.lab.data.readers;

import com.epam.lab.data.models.UserModel;
import com.epam.lab.data.readers.Reader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxDataReader implements Reader {
    public List<UserModel> getData(String file_path) {
        List<UserModel> userModels = new ArrayList<>();
        try (FileInputStream excelFile = new FileInputStream(new File(file_path));
             Workbook workbook = new XSSFWorkbook(excelFile)) {
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int userIter = 0;
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                userModels.add(new UserModel(cellIterator.next().getStringCellValue(),
                        cellIterator.next().getStringCellValue()));
                userIter++;
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
        return userModels;
    }
}
