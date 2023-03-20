package ExcelPack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ExcelUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    public Logger log = LogManager.getLogger(this.getClass());
    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that wew want to open(sheetName)

        log.error("error may happaned"); //log test

        ExcelUtil qa3short = new ExcelUtil("Vytracktestdata.xlsx","QA3-short");

        //how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        System.out.println("get cell data " + qa3short.getCellData(2,3));

        System.out.println("qa3short.getDataArrayWithoutFirstRow() = " + Arrays.deepToString(qa3short.getDataArrayWithoutFirstRow()));

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);
        }

        //get Nona as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));

        //get Harber
        System.out.println("dataList.get(8) = " + dataList.get(8).get("lastname"));

        //get all data in 2d array
        String [][] dataArray = qa3short.getDataArray();

        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));

        qa3short.setCellData("Max" , 3 ,3);

    }
}
