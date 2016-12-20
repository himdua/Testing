package com.giraffic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxOp {

    private static XSSFSheet _getSheet(final XSSFWorkbook xwb,
            final String WorkSheetName, Integer WorkSheetIndex) {
        XSSFSheet sheet;

        if (WorkSheetName != null) {
            sheet = xwb.getSheet(WorkSheetName);
            if (sheet != null) {
                return sheet;
            }
        }

        WorkSheetIndex = (WorkSheetIndex == null ? 0 : WorkSheetIndex);
        WorkSheetIndex = (WorkSheetIndex < 0 ? 0 : WorkSheetIndex);
        sheet = xwb.getSheetAt(WorkSheetIndex);

        return sheet;
    }

    public static XSSFSheet getSheet(final String fileNameWithPath,
            final String WorkSheetName, final Integer WorkSheetIndex)
                    throws FileNotFoundException, IOException {
        final XSSFWorkbook xwb = new XSSFWorkbook(
                XlsxOp.openFile(fileNameWithPath));
        return XlsxOp._getSheet(xwb, WorkSheetName, WorkSheetIndex);
    }

    public static FileInputStream openFile(final String fileNameWithPath)
            throws FileNotFoundException {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("" + fileNameWithPath + "");
        } catch (final FileNotFoundException fnfe) {
            throw fnfe;
        }

        return fs;
    }

    public static String[][] getSheetData(final String fileNameWithPath,
            final String WorkSheetName, final Integer WorkSheetIndex)
                    throws Exception {
        Integer lastRow = null;
        short lastCol = 0;
        String[][] sheetData = null;

        try {

            XSSFSheet sheet;
            XSSFRow row;
            XSSFCell cell;

            sheet = XlsxOp.getSheet(fileNameWithPath, WorkSheetName,
                    WorkSheetIndex);
            lastRow = sheet.getLastRowNum();

            lastCol = 4;

            sheetData = new String[lastRow][lastCol];
            for (int r = 0; r<lastRow; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 0; c < lastCol; c++) {
                        cell = row.getCell(c);

                        if (cell == null) {
                            sheetData[r][c] = null;
                        } else {
                            switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BOOLEAN:
                                sheetData[r][c] = (cell.getBooleanCellValue() ? "true"
                                        : "false");
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                sheetData[r][c] = cell.getErrorCellString();
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                sheetData[r][c] = null;
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    sheetData[r][c] = String.valueOf(cell
                                            .getDateCellValue());
                                } else {
                                    sheetData[r][c] = String.valueOf(cell
                                            .getNumericCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                sheetData[r][c] = cell.getStringCellValue();
                                break;
                            default:
                                sheetData[r][c] = cell.getRawValue();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (final Exception e) {
            throw e;
        }
        return sheetData;
    }

    public String getExcelData(String rowName,String sheetName,String colVal){
        try{
            String value="";
            Workbook workbook;
            Row row;
            Row row1;
            String currentDir = System.getProperty("user.dir");
            String excelFilePath=currentDir+"\\src\\test\\resources\\testdata\\Giraffic_Test_Data.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            workbook=new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            int RowNo=getRowNo(sheet, rowName);
            row = sheet.getRow(RowNo);
            row1 = sheet.getRow(0);

            for (int colIndex = 0; colIndex <= row.getLastCellNum(); colIndex++) {
                Cell cell = row1.getCell(colIndex);
                String cellValueMaybeNull = cell.getStringCellValue();
                if (cellValueMaybeNull.trim().equals(colVal.trim())) {
                    cell = row.getCell(colIndex);
                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        value=cell.getStringCellValue();
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        value=String.format("%.0f", cell.getNumericCellValue());
                        break;
                    }
                    break;
                }
            }
            inputStream.close();
            return value;

        }
        catch(Exception ex){
            return "";
        }

    }

    public ArrayList<String> getEntireRowData(String appName,String sheetName){
        ArrayList<String> al = new ArrayList<String>();
        try{
            String value="";
            Workbook workbook;
            Row row;
            Row row1;
            String currentDir = System.getProperty("user.dir");
            String excelFilePath=currentDir+"\\src\\test\\resources\\testdata\\Giraffic_Test_Data.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            workbook=new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            int RowNo=getRowNo(sheet, appName);
            row = sheet.getRow(RowNo);
            row1 = sheet.getRow(0);
            for (int colIndex = 1; colIndex < row.getLastCellNum(); colIndex++) {
                for(int j=1;j<=getTotalColumnCount(sheet, appName);j++){
                    Cell cell = row1.getCell(colIndex);
                    cell = row.getCell(colIndex);
                    value=cell.getStringCellValue();
                }
                al.add(value);
            }
            inputStream.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return al;
    }

    public int getRowNo(Sheet sheetName,String appName) throws IOException{
        int rowIndex;
        for (rowIndex = 0; rowIndex <= sheetName.getLastRowNum(); rowIndex++) {
            Row row = sheetName.getRow(rowIndex);     
            Cell cell = row.getCell(0);
            String value = cell.getStringCellValue();
            if (value.contains(appName)) {
                break;
            }
        }
        return rowIndex;
    }

    public int getTotalColumnCount(Sheet sheetName,String appName) throws IOException{
        int noOfColumns = sheetName.getRow(0).getPhysicalNumberOfCells();
        return noOfColumns;

    }

}
