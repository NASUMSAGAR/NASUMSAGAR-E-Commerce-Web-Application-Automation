package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getSheetData(String filepath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filepath);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            data[i - 1][j] = String.valueOf((long) cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            data[i - 1][j] = cell.getCachedFormulaResultType() == CellType.NUMERIC
                                    ? String.valueOf((long) cell.getNumericCellValue())
                                    : cell.getStringCellValue();
                            break;
                        case BLANK:
                            data[i - 1][j] = "";
                            break;
                        default:
                            data[i - 1][j] = cell.getStringCellValue().trim();
                            break;
                    }
                }
            }

            System.out.println(">> Rows: " + (rows - 1) + ", Cols: " + cols);
            return data;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel: " + filepath, e);
        }
    }
}