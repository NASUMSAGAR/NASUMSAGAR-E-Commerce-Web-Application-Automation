
package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    private static final String BASE_PATH = System.getProperty("user.dir")
            + "/src/main/resources/";

    @DataProvider(name = "login-data-excel")
    public static Object[][] loginData() {
        return ExcelUtil.getSheetData(BASE_PATH + "TestData.xlsx", "Sheet1");
    }
}
