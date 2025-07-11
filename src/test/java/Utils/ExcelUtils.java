package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static Object[][] getTableArray(String filePath,String sheetName) throws IOException 
	{
		
		//1.open the Excel file
		FileInputStream fis=new FileInputStream(filePath);
		
		//2.Create workbook object
		Workbook	wb=WorkbookFactory.create(fis);
	
		//3.get the desired sheet
		org.apache.poi.ss.usermodel.Sheet sheet=wb.getSheet(sheetName);
		
		//4.Get rows and columns
		int totalRows=sheet.getPhysicalNumberOfRows();
		int totalCols=sheet.getRow(0).getLastCellNum();
		
	//	5.create an Object to hold the data
		Object[][] data=new Object[totalRows-1][totalCols];//skip header row
		
		//6 loops rows and columns to read cells
		
		for(int i=1;i<totalRows;i++)
		{
			
			Row row=sheet.getRow(i);
			
			for(int j=0;j<totalCols;j++)
			{
				
				Cell cell=row.getCell(j);
				data[i-1][j]= getcellValue(cell);
			}
			
		}
		
		//7.close workbook
		wb.close();
		return data;
		
		
	}

	public static Object getcellValue(Cell cell) {
		// TODO Auto-generated method stub
		
		
		if(cell==null) return "";
		switch(cell.getCellType()) {
		
		case STRING: return cell.getStringCellValue();
		case NUMERIC:return cell.getNumericCellValue();
		case BOOLEAN:return cell.getBooleanCellValue();
		case FORMULA:return cell.getCellFormula();
		default: return "";
		}
		
		
	}
	
}
