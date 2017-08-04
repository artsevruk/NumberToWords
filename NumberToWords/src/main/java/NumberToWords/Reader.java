package NumberToWords;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * Created by Admin on 04.08.2017.
 */
public class Reader {

    private static final Logger logger = Logger.getLogger(Catalog.class);

    /**
     * Метод определяет тип Excel ячейки и преобразует ее данные в String
     * @param cell клетка
     * @return строка с данными вычитанная из клетки
     */
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
}
