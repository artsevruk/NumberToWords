package NumberToWords;


import NumberToWords.util.GlobalDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class CatalogTest {

    static Catalog catalog = new Catalog();
    int sheet = 0;
    int cell = 0;
    String pathFile = "src/test/resources/DataTest/DataForCatalog.xls";


    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenReadOfCatlogInList(String a, String b) throws IOException {
        Assert.assertEquals(catalog.readOfCatlogInList(pathFile,sheet,cell).get(Integer.parseInt(a)),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenReadOfCatlogInList(String a, String b) throws IOException {
        Assert.assertNotEquals(catalog.readOfCatlogInList(pathFile,sheet,cell).get(Integer.parseInt(a)),b);
    }


}
