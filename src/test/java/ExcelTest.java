import org.example.RaschetDostavki;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class ExcelTest {

    @DataProvider(name = "Pairwise")
    public Object[][] getData(Method method) {
        String excelPath = "C:\\Users\\Kolbasova.MD\\IdeaProjects\\dostavka-ng-maven\\src\\test\\resources\\Pairwise1.xlsx";
        ExcelUtils excel = new ExcelUtils(excelPath, "Pairwise");

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }
        return data;
    }

    @Test(dataProvider = "Pairwise")
    void testWithCsvFileSource(String rasstoyanie, String gabarity, String hrupkost, String zagruzhennost, String Stoim) {
        int rasstoyanieInt = Integer.parseInt(rasstoyanie);
        boolean gabarityBool = Boolean.parseBoolean(gabarity);
        boolean hrupkostBool = Boolean.parseBoolean(hrupkost);
        int StoimInt = Integer.parseInt(Stoim);

        RaschetDostavki raschet = new RaschetDostavki();
        Assert.assertEquals(raschet.StoimostDostavki(rasstoyanieInt, gabarityBool, hrupkostBool, zagruzhennost), StoimInt);
    }
}