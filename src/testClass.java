import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class testClass {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    // create file to store passwords
    try {
      Formatter f = new Formatter("list.txt");

      // boolean to keep track of whether the password has successfully been created
      boolean success = false;

      // loop while the password has not successfully been created
      while (success == false) {
        // get the input
        System.out.println("Please enter your new password");
        // first attempt
        String first = sc.nextLine().trim();

        // confirm
        System.out.println("Confirm password");
        String second = sc.nextLine().trim();

        // write file
        f.format("%s %n%s", first, second);
        f.format("%n");

        // ensure the line is not empty
        if (first.equals("") || second.equals("")) {
          System.out.println("Error: Password can not be empty.");
          success = false;
        }

        passwordAuthenticator passAuth = new passwordAuthenticator(first, second);

        if (passAuth.passwordCheck() == true) {
          success = true;
          System.out.println("Password created.");
        } else {
          success = false;
          // System.out.println("Password could not be created.");
        }

      }
      f.close();
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: File could not be created");
      e.printStackTrace();
    }

  }
}
