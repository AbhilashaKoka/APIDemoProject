package bddCucumber.demo.endToendAPITest;

public class Route {
    public static final String BOOKSTORE="/BookStore";
    public static final String ACCOUNT="/Account";
    public static final String VERSION="/v1";

    public static String  generateToken(){
        return ACCOUNT+VERSION+"/GenerateToken";
    }
     public static String books()
 {
     return BOOKSTORE+VERSION+"/Books";
 }

 public static String book()
 {
     return BOOKSTORE+VERSION+"/Book";

 }
public static String userAccount(String userId){
        return ACCOUNT+VERSION+"/user"+"/"+userId;
}
}