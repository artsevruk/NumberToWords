package NumberToWords;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NumberInWordsTest {
    private static final Logger logger = Logger.getLogger(NumberInWordsTest.class);

    String patExeleTestFileDirectory = "src/test/resources/DataTest/numberInWords.xls";
    NumberToWords numberToWords = new NumberToWords();
    Catalog catalog = new Catalog();


    @Test
    public void testPrintNumberToWords() throws Exception {
        ArrayList<String> strExpected = null;
        ArrayList<String> strActual = null;
        try {
            strExpected = catalog.readOfCatlogInList(patExeleTestFileDirectory, 0, 0);
            strActual = catalog.readOfCatlogInList(patExeleTestFileDirectory, 0, 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < strExpected.size(); i++) {
            assertEquals(numberToWords.convertNumberToWords(strExpected.get(i)), strActual.get(i));
        }

    }

    @Test
    public void testreadOfCatlogInArray() throws Exception {

        catalog.readOfCatlogInArray(3,2);


    }
}