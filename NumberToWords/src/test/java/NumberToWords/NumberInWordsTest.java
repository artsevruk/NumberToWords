package NumberToWords;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NumberInWordsTest {

    String patExeleTestFileDirectory = "src/test/resources/DataTest/numberInWords.xls";
    NumberToWords numberToWords = new NumberToWords();
    Catalog catalog = new Catalog();


    @Test
    public void testPrintNumberToWords() throws Exception {
        ArrayList<String> strExpected = null;
        ArrayList<String> strActual = null;
        try {
            strExpected = catalog.readOfCatlog(patExeleTestFileDirectory, 0, 0);
            strActual = catalog.readOfCatlog(patExeleTestFileDirectory, 0, 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < strExpected.size(); i++) {
            assertEquals(numberToWords.convertNumberToWords(strExpected.get(i)), strActual.get(i));
        }
    }

}