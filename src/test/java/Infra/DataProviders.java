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
        String filePath = "../SITS-PrimeR/src/test/resources/" + fileName;
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

    @DataProvider(name = "logIntoSystem")
    public Object[][] getLoginData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 0);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "addItem")
    public Object[][] getItemData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 1);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "addTitle")
    public Object[][] addTitle() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 2);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "logIntoAuth")
    public Object[][] getLoginDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 0);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "authItem")
    public Object[][] getItemDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 1);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "authTitle")
    public Object[][] getTitleDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 2);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "EditItem")
    public Object[][] getEditItemData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 0);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "EditTitle")
    public Object[][] getEditTitleData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 1);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "addArticle")
    public Object[][] getaddArticleData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 3);
        return data.toArray(new Object[0][0]);

    }
    @DataProvider(name = "authArticle")
    public Object[][] getArticleDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 3);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "EditArticle")
    public Object[][] getEditArticleData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 2);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addNationality")
    public Object[][] getaddNationalityData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 4);
        return data.toArray(new Object[0][0]);

    }
    @DataProvider(name = "authNationality")
    public Object[][] getNationalityDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 4);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditNationality")
    public Object[][] getEditNationalityData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 3);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addIdentification")
    public Object[][] getaddIdentificationData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 5);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authIdentification")
    public Object[][] getIdentificationDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 5);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditIdentification")
    public Object[][] getEditIdentificationData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 4);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addSector")
    public Object[][] getaddSectorData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 6);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authSector")
    public Object[][] getSectorDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 6);
        return data.toArray(new Object[0][0]);}

    @DataProvider(name = "EditSector")
    public Object[][] getEditSectorData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 6);
        return data.toArray(new Object[0][0]);

    }
    @DataProvider(name = "addSubSector")
    public Object[][] getaddSubSectorData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 7);
        return data.toArray(new Object[0][0]);

    }

    @DataProvider(name = "addCustomerType")
    public Object[][] getaddCustomerTypeData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 8);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authCustomerType")
    public Object[][] getCustomerTypeDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 7);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditCustomerType")
    public Object[][] getEditCustomerTypeData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 5);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authSubSector")
    public Object[][] getSubSectorDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 8);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "addKaratage")
    public Object[][] getaddKaratageData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 9);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authKaratage")
    public Object[][] getKaratageDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 9);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addProduct")
    public Object[][] getaddProductData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 10);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addSLABInterestRate")
    public Object[][] getaddSLABInterestRateData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 11);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditSubSector")
    public Object[][] getEditSubSectorData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 7);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addZone")
    public Object[][] getaddZoneData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 12);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authZone")
    public Object[][] getZoneDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 10);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditZone")
    public Object[][] getEditZoneData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 9);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditCharges")
    public Object[][] getEditChargesData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 10);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authCharges")
    public Object[][] getChargesDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 11);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addCoreBorrower")
    public Object[][] getaddCoreBorrowerData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 13);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditSystemMessage")
    public Object[][] getEditSystemMessageData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 11);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authSystemMessage")
    public Object[][] getSystemMessageDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 12);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addRegion")
    public Object[][] getaddRegionData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 14);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authRegion")
    public Object[][] getRegionDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 13);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditRegion")
    public Object[][] getEditRegionData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 12);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addStatus")
    public Object[][] getaddStatusData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 15);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "addBranch")
    public Object[][] getaddBranchData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AddMasterData.xlsm", 16);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "authStatus")
    public Object[][] getstatusDataAuth() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("AuthMasterData.xlsm", 14);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditStatus")
    public Object[][] getEditstatusData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 13);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "EditWorkClass")
    public Object[][] getEditworkclassData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("EditMasterData.xlsm", 14);
        return data.toArray(new Object[0][0]);
    }
    @DataProvider(name = "ProductDetails")
    public Object[][] getGrantingData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("Transaction.xlsm", 0);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "ArticleDetails")
    public Object[][] getArticleData() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("Transaction.xlsm", 1);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "GrantingDetails")
    public Object[][] getGrantingDetails() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("Transaction.xlsm", 2);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "GrantingFlow")
    public Object[][] getGrantingFlowDetails() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("Transaction.xlsm", 3);
        return data.toArray(new Object[0][0]);
    }

    @DataProvider(name = "dayEndProcess")
    public Object[][] processDayEnd() throws IOException {
        List<Object[]> data = getDataFromSheetAsList("ProcessDayEnd.xlsm", 0);
        return data.toArray(new Object[0][0]);
    }

}