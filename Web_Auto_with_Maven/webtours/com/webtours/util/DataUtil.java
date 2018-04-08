package com.webtours.util;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtil {
	/**
	 * @param path
	 * @param srow
	 * @param erow
	 * @param scell
	 * @param ecell
	 * @return
	 * @throws Exception 
	 */
	public static Object[][] read(String path, int srow, int erow, int scell, int ecell) throws Exception {
		Workbook logdata = WorkbookFactory.create(DataUtil.class.getResourceAsStream(path));
		Sheet sheet = logdata.getSheetAt(0);
		Object[][] table = new Object[erow-srow+1][ecell-scell+1];
		for (int i = srow; i<=erow; i++){
			Row rownum = sheet.getRow(i-1);
			for (int j = scell; j<=ecell; j++){
				Cell cellnum = rownum.getCell(j-1, MissingCellPolicy.CREATE_NULL_AS_BLANK);				
				cellnum.setCellType(CellType.STRING);
				String cellvalue = cellnum.getStringCellValue();
				table[i-srow][j-scell] = cellvalue;
			}
		}
		return table;
	}

//	public static void main(String[] args) throws Exception{
//		Object[][] tmp = read("/LogInfo.xlsx",2,4,1,3);
//		for (Object[] objects : tmp) {
//			for (Object object : objects) {
//				System.out.println("["+object+"]");
//			}
//			System.out.println("-----------------------------");
//		}
//		
//	}
}

