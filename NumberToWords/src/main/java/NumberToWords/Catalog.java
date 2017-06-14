package NumberToWords;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by artsevruk on 15.04.17.
 */
public class Catalog {

    private static final Logger logger = Logger.getLogger(Catalog.class);

    //Метод определяет тип Excel ячейки и преобразует ее данные в String
    public static String readTextOfCell(Cell cell) {
        String result = null;
        try {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        result = cell.getDateCellValue().toString();
                    } else {
                        result = Double.toString(cell.getNumericCellValue());
                    }
                    break;
                default:
                    System.out.println();
            }
        } catch (NullPointerException e) {
            logger.error("Catalog does not contain data. " + e);
        }
        return result;
    }

    //Метод записавает из столбца данные в ArrayList<String>
    public ArrayList<String> readOfCatlog(String pathFile, int sheet, int cell) throws IOException {
        ArrayList<String> digit = new ArrayList();
        FileInputStream fileInputStream = new FileInputStream(pathFile);
        HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);

        for (Row row : wb.getSheetAt(sheet)) {

            digit.add(readTextOfCell(row.getCell(cell)));
        }
        fileInputStream.close();
        return digit;
    }


}
