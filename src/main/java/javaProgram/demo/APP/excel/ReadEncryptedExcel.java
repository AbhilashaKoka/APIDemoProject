package javaProgram.demo.APP.excel;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

public class ReadEncryptedExcel {
    public static void main(String[] args) {
        String filePath = "path/to/encrypted.xlsx"; // Replace with your actual file path

        try (POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath))) {
            // Get the encryption information
            EncryptionInfo info = new EncryptionInfo(fs);
            Decryptor decryptor = Decryptor.getInstance(info);

            if (decryptor.verifyPassword("password")) { // Enter your password here
                try (InputStream dataStream = decryptor.getDataStream(fs)) {
                    Workbook workbook = new XSSFWorkbook(dataStream);
                    String cellValue = workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    System.out.println("Decrypted Value: " + cellValue);
                }
            } else {
                System.out.println("Incorrect password");
            }
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
