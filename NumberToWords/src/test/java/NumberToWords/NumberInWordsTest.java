package NumberToWords;


import NumberToWords.util.GlobalDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NumberInWordsTest {
    private NumberToWords numberToWords = new NumberToWords();


    private String digit1[] = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};



    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenIntNumber(String a, String b){
        Assert.assertEquals(numberToWords.intNumber(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenIntNumber(String a, String b){
        Assert.assertNotEquals(numberToWords.intNumber(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenNumberAbs(String a, String b){
        Assert.assertEquals(numberToWords.numberAbs(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenNumberAbs(String a, String b){
        Assert.assertNotEquals(numberToWords.numberAbs(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenDoubleNumber(String a, String b){
        Assert.assertEquals(numberToWords.doubleNumber(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenDoubleNumber(String a, String b){
        Assert.assertNotEquals(numberToWords.doubleNumber(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenDigit(String a, String b){
        Assert.assertEquals(numberToWords.digit(a,digit1),b);
    }
    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenDigit(String a, String b){
        Assert.assertNotEquals(numberToWords.digit(a,digit1),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenSplitNumberToSegments(String a, String b){
        Assert.assertEquals(numberToWords.splitNumberToSegments(a).size(),Integer.parseInt(b));
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenSplitNumberToSegments(String a, String b){
        Assert.assertNotEquals(numberToWords.splitNumberToSegments(a).size(),Integer.parseInt(b));
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenNumberIsZero(String a, String b){
        Assert.assertEquals(String.valueOf(numberToWords.numberIsZero(a)),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenNumberIsZero(String a, String b){
        Assert.assertNotEquals(numberToWords.numberIsZero(a),b);
    }

    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeConformityBetweenNumberInWords(String a, String b)
    {
        Assert.assertEquals(numberToWords.convertNumberToWords(a),b);
    }
    @Test(dataProvider = "Provider", dataProviderClass = GlobalDataProvider.class)
    public void shouldBeNotConformityBetweenNumberInWords(String a, String b)
    {
        Assert.assertNotEquals(numberToWords.convertNumberToWords(a),b);
    }

}