package NumberToWords;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Artem Sevruk on 11.03.2017.
 * A programm that convert number in words
 *
 * @version 0.1
 * @autor Artem Sevruk
 */

/**
 * Абстрактный класс, хранящий базовые инструкции для перевода числа из цифровой записи в строковую
 */
public abstract class Number {

    /**
     * Абстрактный метод. Получение целой части числа
     */
    public abstract String getIntNumber();

    /**
     * Абстрактный метод. Получение дробной части числа
     */
    public abstract String getDoubleNumber();

    /**
     * Абстрактный метод. Печать числа прописью
     * @param strNumber
     */
    public abstract String convertNumberToWords(String strNumber);

    /**
     * Метод разбивает число на целую и дробную части
     * @param strNumber
     * @return массив из целой и дробной части числа
     */
    private String[] SplitNumberToIntAndDouble(String strNumber) {
        String[] strMass = new String[2];
            if (strNumber.length() != 0) {
                if (strNumber.contains(".")) {
                    strMass = strNumber.split("\\.");
                } else if (strNumber.contains(",")) {
                    strMass = strNumber.split("\\,");
                } else {
                    strMass[0] = strNumber;
                    strMass[1] = "0";
                }
            }

        return strMass;
    }

    /**
     * Метод определяет отрицательное число или положительное
     * @param strNumber
     * @return положительное - true, ноль, отрицательно - false
     */
    public boolean front(String strNumber) {
        return !intNumber(strNumber).substring(0, 1).equals("-");
    }

    /**
     * Метод получение целой части числа без модуля
     * @param strNumber
     */
    public String intNumber(String strNumber) {
        return SplitNumberToIntAndDouble(strNumber)[0];
    }

    /**
     * Метод получение целой части числа по модулю
     * @param strNumber
     */
    public String numberAbs(String strNumber) {
        if (!front(strNumber)) {
            return strNumber.substring(1, strNumber.length());
        } else {
            return strNumber;
        }
    }

    /**
     * Метод получение дробной части числа
     * @param strNumber
     */
    public String doubleNumber(String strNumber) {
        return SplitNumberToIntAndDouble(strNumber)[1];
    }

    /**
     * Метод возвращает строку из массива соответствующую переданному числу
     * @param strNumber
     * @param dig
     * @return число прописью
     */
    public String digit(String strNumber, String[] dig) {
        int number = Integer.parseInt(strNumber);
        for (int i = 0; i <= number; i++) {
            if (number == i) {
                strNumber = dig[i];
            }
        }
        return strNumber;
    }

    /**
     * Метод разбивает число на сегменты по три знака, записывает их в ArrayList<String>
     * @param strNumber
     * @return массив из сегментов числа
     */
    public ArrayList<String> splitNumberToSegments(String strNumber) {
        ArrayList<String> segments = new ArrayList<String>();
        while (strNumber.length() > 3) {
            segments.add(strNumber.substring(strNumber.length() - 3));
            strNumber = strNumber.substring(0, strNumber.length() - 3);
        }
        segments.add(strNumber);
        Collections.reverse(segments);

        return segments;
    }

    /**
     * Метод проверяет элементы ArrayList'а на ноль
     * @param strNumber
     * @return больше нуля - true, ноль, меньше нуля - false
     * @throws NumberFormatException
     */
    public boolean numberIsZero(String strNumber) throws NumberFormatException {
        boolean correct = false;

        for (String segment : splitNumberToSegments(strNumber)) {
            int intStr = Integer.parseInt(segment);
            if (intStr > 0) {
                correct = true;
            }

        }
        return correct;
    }

}