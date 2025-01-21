package javaProgram.demo.APP.excel;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

public class EncryptExcel {
    public static void main(String[] args) {
        try (POIFSFileSystem fs = new POIFSFileSystem()) {
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
            Encryptor encryptor = info.getEncryptor();
            encryptor.confirmPassword("password");

            Workbook workbook = new XSSFWorkbook();
            workbook.createSheet("Sheet1").createRow(0).createCell(0).setCellValue("Test Data");

            Path tmpPath = Files.createTempFile(Paths.get("."), null, ".xlsx");
            try (FileOutputStream fos = new FileOutputStream(tmpPath.toFile())) {
                workbook.write(fos);
            }

            encryptor.getDataStream(fs).write(Files.readAllBytes(tmpPath));
            try (FileOutputStream fos = new FileOutputStream("encrypted.xlsx")) {
                fs.writeFilesystem(fos);
            }

        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
