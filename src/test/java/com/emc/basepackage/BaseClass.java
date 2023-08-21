package com.emc.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static String value;
	public static String ExcelPath = "C:\\Users\\HP\\eclipse-workspace-TESTNG\\July_TestNG15\\src\\test\\resources\\Data\\ExcelRead.xlsx";
	public static void blaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void url(String url) {
		driver.get(url);
	}
	public static String getcurrenturl(String url) {
		return driver.getCurrentUrl();
	}
	public static void close() {
		driver.close();
	}
	
	public static String excelRead(int i, int j) throws IOException {
		File f = new File(ExcelPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		
		CellType cellType = cell.getCellType();
		
		if (cellType==cellType.STRING) {
			String stringCellValue = cell.getStringCellValue();
			value = stringCellValue;
		}
		else if (cellType==cellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
				String value1 = sdf.format(dateCellValue).toString();
				value = value1;
				} else {
					double numericCellValue = cell.getNumericCellValue();
					DecimalFormat df = new DecimalFormat();
					String decValue = df.format(numericCellValue).toString();
					value = decValue;
				}
		}
		return value;
	}
	


}
