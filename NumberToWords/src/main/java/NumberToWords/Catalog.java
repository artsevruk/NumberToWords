package NumberToWords;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by artsevruk on 15.04.17.
 */
public class Catalog extends Reader {


    /**
     * Метод записавает из столбца данные в ArrayList<String>
     * @param pathFile пусть к файлу Excel
     * @param sheet лист
     * @param cell клетка
     * @return массив данных ArrayList<String>
     * @throws IOException
     */
    public ArrayList<String> readOfCatlogInList(String pathFile, int sheet, int cell) throws IOException {

        ArrayList<String> digit = new ArrayList();



        FileInputStream fileInputStream = new FileInputStream(pathFile);
        HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);

        for (Row row : wb.getSheetAt(sheet)) {
            digit.add(readTextOfCell(row.getCell(cell)));
        }
        fileInputStream.close();

        return digit;
    }

    /**
     * Метод записавает из столбца данные в двумерный массив
     * @param path
     * @return двумерный массив Object[][]
     * @throws IOException
     */
    public Object[][] getDataInArray(String path) throws IOException {

        ArrayList<String> strDataExpected = readOfCatlogInList(path, 0, 0);
        ArrayList<String> strDataActual = readOfCatlogInList(path,0,1);

        Object[][] objects = new Object[strDataExpected.size()][2];

        for (int i=0; i<strDataExpected.size(); i++)
        {
            objects[i][0] = strDataExpected.get(i);
            objects[i][1] = strDataActual.get(i);
        }
        return objects;
    }



}
