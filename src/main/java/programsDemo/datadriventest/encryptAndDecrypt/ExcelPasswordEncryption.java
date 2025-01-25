package programsDemo.datadriventest.encryptAndDecrypt;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelPasswordEncryption {
    public static void main(String[] args) {
        String filePath = "path/to/excel/file.xlsx"; // Replace with your actual file path

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis))
            {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            for (Row row : sheet){
                Cell passwordCell = row.getCell(1); // Assuming passwords are in the second column (index 1)
                if (passwordCell != null) {
                    String originalPassword = passwordCell.getStringCellValue();
                    String encryptedPassword = EncryptionUtil.encrypt(originalPassword);
                    passwordCell.setCellValue(encryptedPassword);
                }
            }
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
