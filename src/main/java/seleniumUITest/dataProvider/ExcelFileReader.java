package seleniumUITest.dataProvider;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileReader {
    public static List<String[]> readExcel(String filePath) {
        List<String[]> data = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream((new File(filePath)));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String[] rowData = new String[row.getLastCellNum()];
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    rowData[i] = cell.getStringCellValue();
                }
                data.add(rowData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void writeExcel(String filePath, List<String[]> data){
        try(Workbook workbook=new XSSFWorkbook();
            FileOutputStream fos=new FileOutputStream(filePath)) {
            Sheet sheet=workbook.createSheet("Sheet");
            for(int i=0;i<data.size();i++){
                Row row=sheet.createRow(i);
                String[] rowData=data.get(i);
                for(int j=0;j<rowData.length;j++){
                    Cell cell=row.createCell(j);
                    cell.setCellValue(rowData[j]);
                }
            }
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        // Read data from Excel
        List<String[]> data = ExcelFileReader.readExcel("src/main/java/selenium/demo/testData/testdata.xlsx");
       // Use data in your Selenium test
        for (String[] rowData : data) {
            // Example: Use rowData for login
            System.out.println("Username: " + rowData[0] + ", Password: " + rowData[1]);
        }
        // Write data to Excel
        List<String[]> outputData = new ArrayList<>();
        outputData.add(new String[]{"Result", "Pass"});
        ExcelFileReader.writeExcel("path/to/output.xlsx", outputData);
    }
}
