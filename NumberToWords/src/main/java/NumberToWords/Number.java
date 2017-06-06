package NumberToWords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Artem Sevruk on 11.03.2017.
 * A programm that convert number in words
 *
 * @version 0.1
 * @autor Artem Sevruk
 */

/*
Перевод числа в цифровой записи в строковую. Например 134345 будет "сто тридцать четыре тысячи триста сорок пять".
- Учесть склонения - разница в окончаниях (к примеру, две и два).
- Алгоритм должен работать для сколько угодно большого числа,
  соответственно, значения степеней - миллион, тысяча, миллиад и т.д. - должны браться из справочника, к примеру, текстового файла.
- Обязательно создать Data Driven Test
  (я, как пользователь, должен иметь возможность ввести множество наборов 1.число 2.правильный эталонный результат, тест самостоятельно проверяет все наборы и говорит, что неверное),
  который доказывает, что Ваш алгоритм работает правильно.
- Использовать JUnit.
- По возможности, применить ООП.
 */

public abstract class Number {
    //0. исправить варнинги Warning
    // + 1. ПРОДУМАТЬ СИГНАТУРЫ МЕТОДОВ (НАЗВАНИЯ ПЕРЕДАВАЕМВЫХ ПЕРЕМЕННЫХ
    //2. ДОБАВИТЬ Exceptions
    //3. ТЕСТЫ

    //Абстрактный метод. Получение целой части числа
    public abstract String getIntNumber();

    //Абстрактный метод. Получение дробной части числа
    public abstract String getDoubleNumber();

    //Абстрактный метод. Печать числа прописью
    public abstract String convertNumberToWords(String strNumber);

    //Абстрактный метод. Добавление степеней и склонений для целой части
    public abstract void addFormatForInteger(String strIntegerNumber);

    //Абстрактный метод. Добавление степеней и склонений для целой части
    public abstract void addFormatForDouble(String strDoubleNumber);

    //Метод разбивает число на целую и дробную части
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

    //Метод определяет отрицательное число или положительное
    public boolean front(String strNumber) {
        return !intNumber(strNumber).substring(0, 1).equals("-");
    }

    //Метод получение целой части числа без модуля
    public String intNumber(String strNumber) {
        return SplitNumberToIntAndDouble(strNumber)[0];
    }

    //Метод получение целой части числа по модулю
    public String intNumberAbs(String strNumber) {
        if (!front(strNumber)) {
            return strNumber.substring(1, strNumber.length());
        } else {
            return strNumber;
        }
    }

    //Метод получение дробной части числа
    public String doubleNumber(String strNumber) {
        return SplitNumberToIntAndDouble(strNumber)[1];
    }

    //Метод возвращает строку из массива соответствующую переданному числу
    public static String digit(String strNumber, String[] dig) {
        int number = Integer.parseInt(strNumber);
        for (int i = 0; i <= number; i++) {
            if (number == i) {
                strNumber = dig[i];
            }
        }
        return strNumber;
    }

    //Метод разбивает число на сегменты по три знака, записывает их в ArrayList<String>
    public ArrayList<String> SplitNumberToSegments(String strNumber) {
        ArrayList<String> segments = new ArrayList<String>();
        while (strNumber.length() > 3) {
            segments.add(strNumber.substring(strNumber.length() - 3));
            strNumber = strNumber.substring(0, strNumber.length() - 3);
        }
        segments.add(strNumber);
        Collections.reverse(segments);

        return segments;
    }

    //Метод проверяет элементы ArrayList'а на ноль
    public boolean numberIsZero(String strNumber) throws NumberFormatException {
        boolean correct = false;

        for (String segment : SplitNumberToSegments(strNumber)) {
            int intStr = Integer.parseInt(segment);
            if (intStr > 0) {
                correct = true;
            }

        }
        return correct;
    }


}