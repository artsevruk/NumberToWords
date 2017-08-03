package NumberToWords;

import org.apache.log4j.Logger;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;


public class NumberToWords extends Number {
    private static final Logger logger = Logger.getLogger(NumberToWords.class);

    //Справочник для чисел прописью
    private static final String DIGIT1[] = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String DIGIT11[] = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String DIGIT20[] = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String DIGIT100[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private ArrayList<String> formOne = new ArrayList<String>(Arrays.asList("", "тысяча", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион", "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион"));
    private ArrayList<String> formTwo = new ArrayList<String>(Arrays.asList("", "тысячи", "миллиона", "миллиарда", "триллиона", "квадриллиона", "квинтиллиона", "секстиллиона", "септиллиона", "октиллиона", "нониллиона", "дециллиона"));
    private ArrayList<String> formFive = new ArrayList<String>(Arrays.asList("", "тысяч", "миллионов", "миллиардов", "триллионов", "квадриллионов", "квинтиллионов", "секстиллионов", "септиллионов", "октиллионов", "нониллионов", "дециллионов"));
    private ArrayList<String> formDouble = new ArrayList<String>(Arrays.asList("", "десятых", "сотых", "тысячных", "десятитысячных", "стотысячных", "миллионных", "десятимиллионных", "стомиллионных", "миллиардных", "десятимиллиардных", "стомиллиардных"));
    private StringBuilder numberToSb = new StringBuilder();
    private String number;


    public NumberToWords() {

    }

    //Метод получение целой части числа
    public String getIntNumber() {
        return numberAbs(intNumber(number));
    }

    //Метод получение дробной части числа
    public String getDoubleNumber() {
        return doubleNumber(number);
    }

    //Метод добавляет в numberToSb отрицательное число или положительоне
    private void addFront(String srtNumber) {
        String minus = " минус ";
        if (!front(intNumber(srtNumber))) {
            numberToSb.append(minus);
        }
    }

    //Метод добавляет в StringBuilder numberToSb слова соответствующие переданному числу strNumber
    private void addDigit(String strNumber) {
        if (strNumber.length() == 1) {
            numberToSb.append(digit(strNumber.substring(0, 1), DIGIT1)).append(" ");
        } else if (strNumber.length() == 2) {
            if (10 < Integer.parseInt(strNumber) && Integer.parseInt(strNumber) < 20) {
                numberToSb.append(digit(strNumber.substring(1), DIGIT11)).append(" ");
            } else {
                numberToSb.append(digit(strNumber.substring(0, 1), DIGIT20)).append(" ");
                addDigit(strNumber.substring(1));
            }
        } else if (strNumber.length() == 3) {
            numberToSb.append(digit(strNumber.substring(0, 1), DIGIT100)).append(" ");
            addDigit(strNumber.substring(1));
        }
    }

    //Метод добавляет в StringBuilder numberToSb степени и склонения
    private void addFormatNumber(String strNumber) throws IndexOutOfBoundsException {
        String one = " одна ";
        String two = " две ";
        ArrayList<String> segments = splitNumberToSegments(strNumber);
        for (int i = 0; i < segments.size(); i++) {
            String strSegment = segments.get(i);
            int intStr = Integer.parseInt(strSegment);
            int intStr11 = intStr;
            if (strSegment.length() > 2)
                intStr11 = Integer.parseInt(strSegment.substring(1));
            addDigit(strSegment);

            if (segments.size() >= 1 && intStr > 0) {
                if (11 != intStr11 && (strSegment.substring(strSegment.length() - 1).equals("1"))) {
                    if (i >= segments.size() - 2) {
                        numberToSb.replace(numberToSb.length() - 5, numberToSb.length(), one);
                    }
                    numberToSb.append(formOne.get(segments.size() - 1 - i)).append(" ");
                } else if (12 != intStr11 && (strSegment.substring(strSegment.length() - 1).equals("2")) ||
                        13 != intStr11 && strSegment.substring(strSegment.length() - 1).equals("3") ||
                        14 != intStr11 && strSegment.substring(strSegment.length() - 1).equals("4")) {
                    if ((i >= segments.size() - 2) && (strSegment.substring(strSegment.length() - 1).equals("2"))) {
                        numberToSb.replace(numberToSb.length() - 4, numberToSb.length(), two);
                    }
                    numberToSb.append(formTwo.get(segments.size() - 1 - i)).append(" ");
                } else {
                    numberToSb.append(formFive.get(segments.size() - 1 - i)).append(" ");
                }
            }
        }
    }

    //Метод добавляет в StringBuilder numberToSb постфикс для целой части числа
    private void addFormatForInteger(String strIntegerNumber) throws IndexOutOfBoundsException {
        int intStr11 = 1;
        String zero = "ноль ";
        String wholeForOne = "целая ";
        String wholeForFive = "целых ";
        if (numberIsZero(strIntegerNumber)) {
            if (strIntegerNumber.length() > 1)
            {
                intStr11 = Integer.parseInt(strIntegerNumber.substring(strIntegerNumber.length() - 2));
            }
            addFormatNumber(strIntegerNumber);
        } else {
            numberToSb.append(zero);
        }
        if (strIntegerNumber.substring(strIntegerNumber.length() - 1).equals("1") && 11 != intStr11) {
            numberToSb.append(wholeForOne);
        } else numberToSb.append(wholeForFive);
    }

    //Метод добавляет в StringBuilder numberToSb постфикс для дробной части числа
    private void addFormatForDouble(String strDoubleNumber) throws IndexOutOfBoundsException {
        String strForDoubleOne = "ая ";
        if (numberIsZero(strDoubleNumber)) {
            int intStr11 = 1;
            if (strDoubleNumber.length() > 1)
            {
                intStr11 = Integer.parseInt(strDoubleNumber.substring(strDoubleNumber.length() - 2));
                addFormatNumber(strDoubleNumber);
            }
            numberToSb.append(formDouble.get(strDoubleNumber.length()));
            if (strDoubleNumber.substring(strDoubleNumber.length() - 1).equals("1") && 11 != intStr11) {
                numberToSb.replace(numberToSb.length() - 2, numberToSb.length(), strForDoubleOne);
            }
        }
    }

    //Метод печатает число прописью
    public String convertNumberToWords() {
        addFront(number);
        try {
            addFormatForInteger(getIntNumber());
            addFormatForDouble(getDoubleNumber());
        } catch (NumberFormatException e) {
            logger.error("Invalid number format. " + e);
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            logger.error("Big number. It is necessary to expand the catalog. " + e);
            e.printStackTrace();
        }

        String numberToString = numberToSb.toString();
        clear();

        while (numberToString.contains("  ")) {
            numberToString = numberToString.replace("  ", " ");
        }
        if (numberToString.substring(0, 1).contains(" ")) numberToString = numberToString.substring(1);
        if (numberToString.substring(numberToString.length() - 1).contains(" "))
            numberToString = numberToString.substring(0, numberToString.length() - 1);

        return numberToString;
    }

    public String convertNumberToWords(String numberStr) {
        this.number = numberStr;
        return convertNumberToWords();
    }

    //Метод очищает StringBuilder numberToSb
    public void clear() {
        int startIndexNumberToSb = 0;
        numberToSb.delete(startIndexNumberToSb, numberToSb.length());
    }
}