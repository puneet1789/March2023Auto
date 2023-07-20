package march.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoadExternalDataUtility {
	
	public Map<String, List<List<String>>> testData = null;
	public Logger logger = Logger.getLogger(LoadExternalDataUtility.class.getName());
	
	public LoadExternalDataUtility(String path) throws IOException {
		testData = readWorkbook(path);
	}

	public Map<String, List<List<String>>> readWorkbook(String path) {
		logger.info("Reading workbook at path : " + path);
		List<List<String>> alllist = new ArrayList<List<String>>();
		Map<String,List<List<String>>> data= new HashMap< String,List<List<String>>>();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(path));

		
		XSSFWorkbook workbook;

		workbook = new XSSFWorkbook(fis);
				//workbook
		Iterator<Sheet> itrsheet = workbook.iterator();		//Sheet iterator
		while(itrsheet.hasNext()) {							//while loop for sheet iterator
			XSSFSheet sheet = (XSSFSheet) itrsheet.next();	//sheet
		Iterator<Row> itrrow =sheet.iterator();				//row iteraator
		  
		while(itrrow.hasNext()) {							//while loop for rows
			
			Row row = itrrow.next();
			Iterator<Cell> itrcell = row.iterator();
			List<String> list = new ArrayList<String>();			//list to store all cell values
			
			while(itrcell.hasNext()) {						//while loop for single row
				Cell cell = itrcell.next();
			//CellType celltype = cell.getCellType();	
				
			list.add(cell.getStringCellValue());			//add cell value to list
				
			}
			 	
			
			alllist.add(list);								//add cell value lists to alllist list
			
		}
		 
		data.put(sheet.getSheetName(), alllist); 			//add to Map	
		}
		
		logger.info("Reading workbook -- Completed ===> " + data);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return data;
	}
	
	
	
	//Load data
	public String getData(String sheetName, String rowName, String columnName) {
		
		logger.info("Featch Data for Sheet Name  ===> " + sheetName + " Row Name  ===> " + rowName +  " Column Name  ===> " + columnName);
		List<List<String>> sheet = testData.get(sheetName);
		String data = "";
		//// get index of column Name		
		int indexColumn = sheet.get(0).indexOf(columnName);
		
		
		for (List<String> row : sheet) {
			if (row.get(0).equalsIgnoreCase(rowName)) {
				data = row.get(indexColumn);
				break;
			}
		}
		
		
		logger.info("Data Fetched : =====> " + data);
		return data;		
	}

}
