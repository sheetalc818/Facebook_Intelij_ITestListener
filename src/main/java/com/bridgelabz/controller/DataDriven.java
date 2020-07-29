
/******************************************************************************
 *
 *  Author  Deepali Kalagate
 *
 *  Purpose: Created Properties for test login page.
 *  @since   15-01-2020
 *
 ******************************************************************************/

package com.bridgelabz.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class DataDriven
{
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public static Workbook wb;
    public DataDriven(String excelPath)
    {
        File file = new File(excelPath);
        try
        {
            FileInputStream fis = new FileInputStream(file);
            this.workbook = new XSSFWorkbook(fis);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public String getData(int sheetNumber, int row, int column)
    {
        this.sheet = this.workbook.getSheetAt(0);
        Cell cell = this.sheet.getRow(row).getCell(column);
        cell.setCellType(CellType.STRING);
        String data = cell.getStringCellValue();
        return data;
    }

    public int getrowcount(int sheetIndex)
    {
        int rowNum = this.workbook.getSheetAt(sheetIndex).getLastRowNum();
        ++rowNum;
        return rowNum;
    }
}
