package excelUtility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtility {

    public static String path = System.getProperty("user.dir") + "\\TestData\\ALF_Data.xlsx";
    public static int row = 1;
    public static String excel(String SheetName, int column) {

        String value ="";
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(SheetName);
            value = sheet.getRow(row).getCell(column).getStringCellValue();
        } catch (Exception e) {
            System.out.println("Issue in excel get data"+ e);
        }

        return value;
    }
}
