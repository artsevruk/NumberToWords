package NumberToWords.util;


import NumberToWords.Catalog;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class GlobalDataProvider {
    static Catalog catalog = new Catalog();
    private static HashMap<String, String> map = new HashMap<String, String>();

    static
    {
        map.put("shouldBeConformityBetweenNumberInWords","src/test/resources/DataTest/shouldBeConformityBetweenNumberInWords.xls");
        map.put("shouldBeNotConformityBetweenNumberInWords","src/test/resources/DataTest/shouldBeNotConformityBetweenNumberInWords.xls");
        map.put("shouldBeConformityBetweenIntNumber","src/test/resources/DataTest/shouldBeConformityBetweenIntNumber.xls");
        map.put("shouldBeNotConformityBetweenIntNumber","src/test/resources/DataTest/shouldBeNotConformityBetweenIntNumber.xls");
        map.put("shouldBeConformityBetweenNumberAbs","src/test/resources/DataTest/shouldBeConformityBetweenNumberAbs.xls");
        map.put("shouldBeNotConformityBetweenNumberAbs","src/test/resources/DataTest/shouldBeNotConformityBetweenNumberAbs.xls");
        map.put("shouldBeConformityBetweenDoubleNumber","src/test/resources/DataTest/shouldBeConformityBetweenDoubleNumber.xls");
        map.put("shouldBeNotConformityBetweenDoubleNumber","src/test/resources/DataTest/shouldBeNotConformityBetweenDoubleNumber.xls");
        map.put("shouldBeConformityBetweenDigit","src/test/resources/DataTest/shouldBeConformityBetweenDigit.xls");
        map.put("shouldBeNotConformityBetweenDigit","src/test/resources/DataTest/shouldBeNotConformityBetweenDigit.xls");
        map.put("shouldBeConformityBetweenSplitNumberToSegments","src/test/resources/DataTest/shouldBeConformityBetweenSplitNumberToSegments.xls");
        map.put("shouldBeNotConformityBetweenSplitNumberToSegments","src/test/resources/DataTest/shouldBeNotConformityBetweenSplitNumberToSegments.xls");
        map.put("shouldBeConformityBetweenNumberIsZero","src/test/resources/DataTest/shouldBeConformityBetweenNumberIsZero.xls");
        map.put("shouldBeNotConformityBetweenNumberIsZero","src/test/resources/DataTest/shouldBeNotConformityBetweenNumberIsZero.xls");
        map.put("shouldBeConformityBetweenReadOfCatlogInList","src/test/resources/DataTest/shouldBeConformityBetweenReadOfCatlogInList.xls");
        map.put("shouldBeNotConformityBetweenReadOfCatlogInList","src/test/resources/DataTest/shouldBeNotConformityBetweenReadOfCatlogInList.xls");

    }

    @DataProvider(name = "Provider")
    public static Object[][] testData(Method m) throws Exception {

        Object[][] objects ;
        try {
            //Путь к данным будет зависеть от метода которому Provider будет поставлть данные
            objects = catalog.getDataInArray(map.get(m.getName()));
        } catch (IOException e) {
            e.printStackTrace();
            //В случае неудачного чтения, Provider вернет пустой массив.
            return new Object[0][0];
        }
        return objects;
    }

}
