import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class SonarQubeTest {

    private static final String PASSWORD = "123456"; // Hardcoded credentials
    private int a = 5; // Unused variable

    public static void main(String args[]) {
        SonarQubeTest test = new SonarQubeTest();
        test.doSomething();
        test.doSomething(); // Duplicate code
    }

    public void doSomething() {
        String s = null;
        if (s.equals("test")) { // NullPointerException risk
            System.out.println("Equal");
        }

        int result = calculate(10); // Magic number
        System.out.println("Result is: " + result);

        try {
            FileReader fr = new FileReader("somefile.txt");
            fr.read(); // No resource close
        } catch (Exception e) {
            // Empty catch block
        }

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Date: " + sdf.format(d));
    }

    @Deprecated
    public int calculate(int num) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }

        if (num > 5) {
            System.out.println("Greater than 5");
        } else if (num > 5) { // Logical redundancy
            System.out.println("Still greater than 5?");
        }

        return sum;
    }
}
