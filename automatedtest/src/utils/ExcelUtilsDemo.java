package utils;

public class ExcelUtilsDemo {
	public static void main(String[] args) {
		String projectpath = System.getProperty("user.dir");
		excelutils excel = new excelutils(projectpath+"/excel/data.xlsx","Sheet2");
		excel.getRowCount();
		
		excel.getCellData(1, 0);
		
	}

}
