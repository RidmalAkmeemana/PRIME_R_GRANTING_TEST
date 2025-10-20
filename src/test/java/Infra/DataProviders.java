package Infra;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    private List<Object[]> getDataFromSheetAsList(String fileName, int sheetIndex) throws IOException {
        String filePath = "../GrantingAutomation/src/test/resources/" + fileName;
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        List<Object[]> dataList = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            Object[] rowData = new Object[cols];
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = sheet.getRow(i).getCell(j);
                rowData[j] = (cell == null) ? "" : cell.toString();
                rowData[j] = (cell == null) ? "" : cell.toString();
            }
            dataList.add(rowData);
        }

        workbook.close();
        fis.close();

        return dataList;
    }

    @DataProvider(name = "GrantingFlow")
    public Object[][] getGrantingFlowDetails() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("Transaction.xlsm", 0);
        return data.toArray(new Object[0][0]);
    }

}