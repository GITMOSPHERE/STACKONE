package MainPack;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class GetdatafromExcel {

public static String testing;
	
	 private static String s = "Sheet1";
	 private static String s1 = "src/main/java/MainPack/jenkins_data.xlsx";
	 private static Map<String, String> map = new HashMap<String,String>();

	 //public String get(String testcasename,String columnname) throws IOException {
	 public String get(String testcasename,String columnname) throws IOException {
	 FileInputStream fis;
	 int k =0;
	 try {
	 fis = new FileInputStream(s1);
	 XSSFWorkbook wb = new XSSFWorkbook(fis);
	 XSSFSheet ws = wb.getSheet(s);
	 int rows = ws.getPhysicalNumberOfRows();
	 //System.out.println("Rows no:"+rows);
	 for(int i=0;i<rows;i++){
	 int cols = ws.getRow(0).getPhysicalNumberOfCells();
	 //System.out.println("Columns no:"+rows);
	 for (int j = 0; j < cols; j++) { 
	 if(ws.getRow(i).getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").
	 equalsIgnoreCase(columnname)){ 
	 k=j;
	 //System.out.println("test check:"+j);
	 }
	 testing = map.put(ws.getRow(i).getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0",""),
			 ws.getRow(i).getCell(k,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
	 }
	 }
	 return (testing);
	 }
	 catch (Exception e){e.printStackTrace(); } 
	 return map.get(testcasename);
	 } 
/*
public static void main(String args[]) throws IOException{
	GetdatafromExcel gdfe = new GetdatafromExcel();
	String tester = gdfe.get("Jenkins login","password");
	System.out.println("testing data is: "+tester);
	
}*/
}
