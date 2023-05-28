package Utilities;

import Tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HelperFunc extends BaseTest
{
    public HelperFunc(WebDriver driver) {
        super();
    }

    public static void ScreenShoot(String Path) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(Path));

    }

    public String[][] ReadData(String FileName, String Sheet) throws IOException {
        File inputStream = new File(FileName);
        DataFormatter df = new DataFormatter();
        FileInputStream fis = new FileInputStream(inputStream);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(Sheet);
        int numberrows = sheet.getPhysicalNumberOfRows();
        int numbercols = sheet.getRow(0).getLastCellNum();
        String ARR[][] = new String[numberrows][numbercols];
        for (int i = 0; i < numberrows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < numbercols; j++) {
                XSSFCell cell = row.getCell(j);
                String value = df.formatCellValue(cell);
                ARR[i][j] = value.trim();
            }
        }
        return ARR;
    }

    public void WriteDataToSheet(String FileName, String SheetName, String CourseName) throws IOException {
        FileInputStream fis = new FileInputStream(FileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(SheetName);

        Row row0 = sheet.createRow(0);
        Cell cell0 = row0.createCell(0);
        cell0.setCellValue(CourseName);

        FileOutputStream fos = new FileOutputStream(FileName);
        workbook.write(fos);
        fos.close();

    }
}
