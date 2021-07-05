package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {
	static XSSFWorkbook workbook ;
	static XSSFSheet sheet;
	public excelutils(String excelpath,String sheetname) {
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);
		} 
		catch (Exception exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		 
		
	}
	
	public static void main(String[] args) {
		getRowCount();
		getCellData(1,0);
	}
	
	public static int getRowCount() {
		int rowCount=0;
		
		try {
			
		rowCount =	sheet.getPhysicalNumberOfRows();
		
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		
		return rowCount;
		
	}
public static int getColCount() {
	int ColCount=0;
		
		try {
			
		 ColCount =	sheet.getRow(0).getPhysicalNumberOfCells();
		
		
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return ColCount;
		
		
		
		
	}
	public static Object  getCellData(int rownum,int colnum) {
		
		DataFormatter formatter = new DataFormatter();
		Object value= formatter.formatCellValue(sheet.getRow(1).getCell(colnum));
		
		return value; 
	}
		
}