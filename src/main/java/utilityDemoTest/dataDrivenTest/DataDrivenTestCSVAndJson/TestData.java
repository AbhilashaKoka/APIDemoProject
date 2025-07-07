package utilityDemoTest.dataDrivenTest.DataDrivenTestCSVAndJson;

public class TestData {
    public String TestCaseID;
    public String Name;
    public  String Email;
    public  String Age;

    @Override
    public String toString() {
        return "TestData{" +
                "TestCaseID='" + TestCaseID + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTestCaseID() {
        return TestCaseID;
    }

    public void setTestCaseID(String testCaseID) {
        TestCaseID = testCaseID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
