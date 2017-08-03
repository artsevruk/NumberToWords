package NumberToWords;


import NumberToWords.util.GlobalDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class CatalogTest {

    static Catalog catalog = new Catalog();


    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenReadOfCatlogInList(String a, String b) throws IOException {
        Assert.assertEquals(catalog.readOfCatlogInList("src/test/resources/DataTest/DataForCatalog.xls",0,0).get(Integer.parseInt(a)),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenReadOfCatlogInList(String a, String b) throws IOException {
        Assert.assertNotEquals(catalog.readOfCatlogInList("src/test/resources/DataTest/DataForCatalog.xls",0,0).get(Integer.parseInt(a)),b);
    }


}
