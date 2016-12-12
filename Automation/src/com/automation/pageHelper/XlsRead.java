package com.automation.pageHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsRead {
	static String fileName = "a.xlsx";

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\admin\\Desktop\\" + fileName);
		FileInputStream fio = new FileInputStream(file);
		HashMap<Character, Integer> map = new HashMap<>();
		// Workbook wb=null;
		XSSFWorkbook wb = new XSSFWorkbook(fio);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		System.out.println("Total number of Rows " + rowcount);
		try {
			for (int i = 0; i < rowcount + 1; i++) {
				XSSFRow r = sh.getRow(i);
				if (sh.getRow(i) == null) {
					System.out.println("Row " + i + " is blank");
				} else {
					int c = r.getLastCellNum();
					System.out.println("Row " + i + " has " + c + " Cells");
					for (int j = 0; j < c; j++) {
						XSSFCell cell = r.getCell(c);
						if (r.getCell(j) == null
								|| r.getCell(j).getCellType() == cell.CELL_TYPE_BLANK) {
							System.out.println("Cell " + j + " is blank");
						} else {
							String rowValue = r.getCell(j).getStringCellValue();
							char[] s = rowValue.toCharArray();
							for (char a : s) {
								System.out.println("Cell " + " has " + a
										+ " values");
								if (map.containsKey(a)) {
									int val = map.get(a);
									map.put(a, val + 1);
								} else {
									map.put(a, 1);
									System.out.println(map);

								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		
		  XSSFRow newR=sh.createRow(rowcount+5);
		  
		  XSSFCell cell=newR.createCell(12); cell.setCellValue(map.toString());;
		  fio.close(); FileOutputStream fo=new FileOutputStream(file);
		  wb.write(fo); fo.close();
		 
		fio.close();
		wb.close();
	}

}
