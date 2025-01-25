package programsDemo.datadriventest.encryptAndDecrypt;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelWithDecryption {
    public static void main(String[] args) {
        String filePath = "src/main/resources/testdata/readAndWrite.xlsx"; // Replace with your actual file path

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            for (Row row : sheet) {
                Cell passwordCell = row.getCell(1); // Assuming passwords are in the second column (index 1)
                if (passwordCell != null) {
                    String encryptedPassword = passwordCell.getStringCellValue();
                    String decryptedPassword = EncryptionUtil.decrypt(encryptedPassword);
                    System.out.println("Decrypted Password: " + decryptedPassword);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
