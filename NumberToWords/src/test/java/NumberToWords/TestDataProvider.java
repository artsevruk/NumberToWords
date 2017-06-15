package NumberToWords;

import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * Created by artsevruk on 15.06.2017.
 */
public class TestDataProvider {

    //String pathFile = null;
    int line = 0;
    int column = 0;
    String patExeleTestFileDirectory = "src/test/resources/DataTest/numberInWords.xls";
    NumberToWords numberToWords = new NumberToWords();
    Catalog catalog = new Catalog();


    public TestDataProvider(int line, int column)
    {
        //this.pathFile = pathFile;
        this.line = line;
        this.column = column;
    }

    @DataProvider
    public Object [][] parseLocaleData() throws IOException {
        return catalog.readOfCatlogInArray(line, column);
    }
}
