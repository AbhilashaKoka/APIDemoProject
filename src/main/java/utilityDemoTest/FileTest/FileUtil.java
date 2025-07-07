package utilityDemoTest.FileTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    public static void main(String[] args) {
        String sourcefilePath = "C:\\Users\\admin\\Desktop\\Automation\\Automation\\src\\test\\resource\\TestDataDriver\\Reports";
        String targetPath = "C:\\Users\\admin\\Desktop\\Automation\\Automation\\src\\test\\resource\\TestDataDriver";
        String scenarioName = "Scenario1";
        attachedReportFolderToTargetLocation(sourcefilePath, targetPath, scenarioName);
    }

    public static void attachedReportFolderToTargetLocation(String sourcefilePath, String targetPath, String scenarioName) {
        File reportFile = findlatestReportFolder(sourcefilePath);
        if (reportFile != null) {
            System.out.println(reportFile.getAbsolutePath());
            selectFiles(reportFile, ".*_" + scenarioName + "_*.*");
        } else {
            System.out.println("No report folder found");
        }
        try {
            String zipFilePath = targetPath + scenarioName + ".zip";
            zipFolder(reportFile.toString(), zipFilePath);
            uploadFile(zipFilePath, targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void uploadFile(String zipFilePath, String targetPath) throws IOException{
        File zipFile=new File(zipFilePath);
    File targetDirectory=new File(targetPath);
    if(!targetDirectory.exists())
    {
        targetDirectory.mkdirs();
    }
    Files.move(zipFile.toPath(), Paths.get(targetPath, zipFile.getName()), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File upload successfully");
    }
    public static void zipFolder(String reportPath, String zipFilePath) throws IOException {
        try(FileOutputStream fos=new FileOutputStream(zipFilePath);
        ZipOutputStream zos=new ZipOutputStream(fos)){
            Path sourcePath=Paths.get(reportPath);
            Files.walk(sourcePath).forEach(path->{
              try {
                  String filePath = sourcePath.relativize(path).toString();
                  if (Files.isDirectory(path)) return;
                  zos.putNextEntry(new ZipEntry(filePath));
                  Files.copy(path, zos);
                  zos.closeEntry();
              }
              catch(IOException e){
                  e.printStackTrace();
              }

            });
        }
    }

    public static File findlatestReportFolder(String reportPath){
        File reportFolder = new File(reportPath);
        File[] subfiles=reportFolder.listFiles(File::isDirectory);
        File ParentFolder= Arrays.stream(subfiles).max(Comparator.comparingLong(FileUtil::getLastModifiedTime)).orElse(null);
        File subFolder=new File(ParentFolder,"\\Screenshots");
        return subFolder;
    }

public static void selectFiles(File folder, String fileExtension){
  File[] selectedFiles=folder.listFiles((dir,name)->name.matches(fileExtension));
  if(selectedFiles!=null &&selectedFiles.length>0){
      System.out.println("Selected files are:");
      for(File selectedFile:selectedFiles){
          System.out.println(selectedFile.getAbsolutePath());
      }
  }
  else {
      System.out.println("No selected files found");
  }
}


    public static long getLastModifiedTime(File file) {
        BasicFileAttributes attrs = null;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            return attrs.lastModifiedTime().toMillis();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}