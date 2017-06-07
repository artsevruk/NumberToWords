package NumberToWords;

import org.apache.log4j.Logger;
import org.junit.Test;

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
        logger.info("! logger START!");
        try {
            strExpected = catalog.readOfCatlog(patExeleTestFileDirectory, 0, 0);
            strActual = catalog.readOfCatlog(patExeleTestFileDirectory, 0, 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("! logger error !" + e.getMessage());
            logger.info("! logger info !" + e.getStackTrace());
        }
        logger.info("! logger RUN!");
        for (int i = 0; i < strExpected.size(); i++) {
            assertEquals(numberToWords.convertNumberToWords(strExpected.get(i)), strActual.get(i));
        }
        logger.info("! logger END !");
    }

}