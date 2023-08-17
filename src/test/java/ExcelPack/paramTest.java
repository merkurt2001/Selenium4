package ExcelPack;

import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class paramTest {

    public static List<Map<String,String>> getExcelData(){
        ExcelUtil excelUtil = new ExcelUtil("Vytracktestdata.xlsx","QA3-short");
        return excelUtil.getDataList();
    }

}
