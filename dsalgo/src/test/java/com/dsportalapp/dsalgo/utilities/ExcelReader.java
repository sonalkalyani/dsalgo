package com.dsportalapp.dsalgo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	public FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String xlFilePath;
	public String testData;
	public String sheetName;
	
	
	/*
	 * public static void main(String[] args) { ExcelReader ex = new
	 * ExcelReader(excel_file_path) ; String data[][]=ex.getExcelData("pythonCode");
	 * 
	 * System.out.println("Data from Excel : " + data[1][0].toString());
	 * System.out.println("Data from Excel : " + data[2][0].toString()); }
	 */
	 
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String getTestData() {
		return testData;
	}
	public void setTestData(String testData) {
		this.testData = testData;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String testResult;

	public ExcelReader(String xlFilePath) {
		try {
			this.xlFilePath = xlFilePath;
			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
    //Get Excel Rows have valid data
	public int getRowCount() {

		int rowCount = 0;
		int rowStart = Math.min(15, sheet.getFirstRowNum());
		int rowEnd = Math.max(1400, sheet.getLastRowNum());
		System.out.println("Row <><>"+rowStart + rowEnd);
		for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
			Row r = sheet.getRow(rowNum);
			if (r != null)// This whole row is empty
			{
				if (!(r.getCell(0) == null)) {
					// System.out.println("Row <>>>>>>>>>>>>"+r.getCell(0).getStringCellValue());
					rowCount = rowNum;
				}
				continue;
			}

		}

		return rowCount;
	}
    // Get column count
	public int getColumnCount() {
		// sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	// Read data from excel and return data 
	public String[][] getExcelData(String sheet_name) {
		setSheetName(sheet_name);
		sheet = workbook.getSheet(sheet_name);
		int colCount = getColumnCount();
		int rowCount = getRowCount() + 1;
		//System.out.println("Row Count & Col Count>>>>>>>"+rowCount +colCount);
		String[][] dataTable = null;
		dataTable = new String[rowCount][colCount];
		Iterator<Row> iterator = sheet.iterator();
		int i = 0, j = 0;
		try {
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					//System.out.println("Cell Type  :"+ currentCell.getCellType());
					String ct=currentCell.getCellType().toString();
			        
					if (ct.equals("STRING")&& currentCell.getStringCellValue().length() == 0) {
						// System.out.println("Null");
					} else {
						if(ct.equals("STRING")) {
						dataTable[i][j] = currentCell.getStringCellValue();
					//	System.out.println("Current Cell Value >>>"+currentCell.getStringCellValue().toString());
						}
						else {
							 int value =(int)(currentCell.getNumericCellValue());
							dataTable[i][j] = Integer.toString(value);
						//	System.out.println("Current Cell Value >>>"+currentCell.getNumericCellValue());

						}
						
						j++;
						if (j >= colCount) {

							j = 0;
							i++;

						}
					}
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return dataTable;

	}
	
/*	public void getData() {
		
		String[][] data=getExcelData(getSheetName());
		
		for (String[] row : data) {

			// converting each row as string
			// and then printing in a separate line
			//if(row.length!=0) {
			//System.out.println(Arrays.toString(row));}
			
			 // Loop through all columns of current row
			int r=1,k=0;
           // for (String x : row)
			  String python_code = row[k];
              //  System.out.println("Python_code....");
              //  System.out.println(python_code);
               // System.out.println("Response....");
               // System.out.println(row[k]);
              //  System.out.println("==========================================");
			  setTestData(python_code);
			  String response =row[r];
			  setTestResult(response);
			  
                r++;
                
                
			
		}
		System.out.println();
	}*/

}
