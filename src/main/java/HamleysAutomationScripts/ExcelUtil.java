package HamleysAutomationScripts;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private Workbook workbook;
    private String excelPath;

    public ExcelUtil(String excelPath) throws IOException {
        this.excelPath = excelPath;
        FileInputStream fis = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(fis);
    }

    public String getWebsiteLink() {
        // Always read from the first sheet (Sheet1)
        Sheet sheet = workbook.getSheetAt(0);
        return sheet.getRow(0).getCell(0).getStringCellValue();
    }

    // Write product count to a sheet named after the browser
    public void writeProductCount(int productCount, String browser) throws IOException {
        // Get or create the sheet for this browser
        Sheet sheet = workbook.getSheet(browser);
        if (sheet == null) {
            sheet = workbook.createSheet(browser);
        }
        // Write heading in row 0
        Row headingRow = sheet.getRow(0);
        if (headingRow == null) headingRow = sheet.createRow(0);
        headingRow.createCell(0).setCellValue("Browser");
        headingRow.createCell(1).setCellValue("Product Count");

        // Write value in row 1
        Row valueRow = sheet.getRow(1);
        if (valueRow == null) valueRow = sheet.createRow(1);
        valueRow.createCell(0).setCellValue(browser);
        valueRow.createCell(1).setCellValue(productCount);

        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);
        fos.close();
    }

    public void close() throws IOException {
        workbook.close();
    }
}
