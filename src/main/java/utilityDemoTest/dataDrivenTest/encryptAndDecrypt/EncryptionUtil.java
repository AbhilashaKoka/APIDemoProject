package utilityDemoTest.dataDrivenTest.encryptAndDecrypt;

import java.util.Base64;

public class EncryptionUtil {
    public static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decrypt(String encryptedData) {
        return new String(Base64.getDecoder().decode(encryptedData));
    }


//        public static void main(String[] args) {
//        String pwd=encrypt("Abhilasha");
//        System.out.println(pwd);
//        String pwd2=decrypt(pwd);
//        System.out.println(pwd2);
//    }


}
