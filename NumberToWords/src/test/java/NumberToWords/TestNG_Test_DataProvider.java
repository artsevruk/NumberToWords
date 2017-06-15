package NumberToWords;


import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Artsevruk on 15.06.2017.
 */
public class TestNG_Test_DataProvider extends Assert{

    String patExeleTestFileDirectory = "src/test/resources/DataTest/numberInWords.xls";
    NumberToWords numberToWords = new NumberToWords();
    Catalog catalog = new Catalog();

/*
    Object[][] arrObl0 = new Object[][]{
        {1, 1},
        {2, 2},
        {3, 3},
    };


    Map<Integer,Integer> mapTest = new HashMap<Integer, Integer>(){{
        put(1,1); put(1,1);}};


    @DataProvider
        public Object[][] parseNumberFromXls(Object[][] arrObj) {
            Object[][] arrObj1 = arrObj;
            return arrObj1;
        }

        @Test(dataProvider = "parseNumberFromXls")
        public void testNumberFromXls(int actual, int expected) {
            assertEquals(actual, expected);

        }

        new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
        };



    ArrayList<Integer> [][] lists2 = new ArrayList[2][2];{{

        lists2[0][0].add()
    }
    }

    @Parameters({ "line " })
    @DataProvider
    public Object [][] parseLocaleData(int  line) throws IOException {
        return catalog.readOfCatlogInArray(5,2);
    }
*/

    int line = 1;
    int column = 2;

    private void setParametersDataProvider(int line, int column)
    {
        this.line = line;
        this.column = column;
    }

    @DataProvider
    public Object [][] parseLocaleData() throws IOException {
        return catalog.readOfCatlogInArray(line,column);
    }


    @Test(dataProvider = "parseLocaleData")
    public void test1(int line, int column) {

        assertEquals(line, column);
        //setParametersDataProvider(5,2);
    }


    @Test(dataProvider = "parseLocaleData")
    public void test2(int line, int column) {
        setParametersDataProvider(5,2);
        assertEquals(line, column);
    }


}

