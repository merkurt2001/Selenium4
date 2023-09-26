package ExcelPack;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDemo {

    @Test
    public void excelRead() throws IOException {
        FileInputStream fileInputStream= new FileInputStream("Vytracktestdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("QA3-short");

        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        System.out.println(sheet.getRow(3).getCell(3));
    }


    @Test
    public void excelWrite() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Vytracktestdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("QA3-short");

        System.out.println("sheet.getRow(2).getCell(2) = " + sheet.getRow(2).getCell(2));

        sheet.getRow(2).getCell(2).setCellValue("Max");

        System.out.println("sheet.getRow(2).getCell(2) = " + sheet.getRow(2).getCell(2));

        FileOutputStream fileOutputStream = new FileOutputStream("Vytracktestdata.xlsx");
        workbook.write(fileOutputStream);


    }
}
