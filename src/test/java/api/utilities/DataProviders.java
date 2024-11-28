package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class DataProviders {

    @DataProvider(name="data")
    public String[][] getAllTestData() throws IOException {
        String path = System.getProperty("user.dir")+"//testData/testData.xlsx";


        int rowcount = XlUtils.getRowCount(path, "data");
        int colcount = XlUtils.getCellCount(path, "data", 1);

        String data[][] = new String[rowcount][colcount];

        for (int i = 1; i <= rowcount; i++) {
            for (int j = 0; j < colcount; j++) {

                data[i - 1][j] = XlUtils.getCellData(path, "data", i, j);
            }

        }
        return (data);

    }


    @DataProvider(name="userNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir")+"//testData/testData.xlsx";


        int rowcount = XlUtils.getRowCount(path, "data");


        String data[]= new String[rowcount];

        for (int i = 1; i <= rowcount; i++) {
            data[i - 1] = XlUtils.getCellData(path, "data", i, 1);
            }

        return (data);

    }
}
