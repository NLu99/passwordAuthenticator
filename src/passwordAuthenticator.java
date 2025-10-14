import java.io.*;
import java.util.*;

public class passwordAuthenticator {

  // method to check whether the strings are the same and if they contain a number
  public static boolean passwordCheck(String str1, String str2) {
    // check whether the strings are the same
    if (str1.equals(str2)) {
      // check if the password contains a number
      if (!str1.matches(".*\\d+.*")) { // only check str1 because the string are equal
        // if not, show error message
        System.out.println("Error creating password: Password chould contain at least one number.");
        return false;
      } else if (str1.matches(".*\\d+.*")) {
        return true;
      }
    } else {
      System.out.println("Error creating password: Passwords do not match.");
      return false;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
 // create file to store passwords
    Formatter f = null;
    try {
      f = new Formatter("list.txt");
      System.out.println("File created");
    } catch (FileNotFoundException e) {
      System.out.println("File created");
      e.printStackTrace();
    }

    // boolean to keep track of whether the password has successfully been created
    boolean success = false;

    // loop while the password has not successfully been created
    while (success == false) {
      // get the input
      System.out.println("Please enter your new password");
      String first = sc.nextLine().trim();
      System.out.println("Confirm password");
      String second = sc.nextLine().trim();
      f.format("%s %n%s", first, second);
      f.format("%n");
      
      // ensure the line is not empty
      if (first.equals("") || second.equals("")) {
        System.out.println("Error: Password can not be empty.");
        success = false;
      }
      
      if(passwordCheck(first, second) == true) {
        success = true;
        System.out.println("Password created.");
      } else {
        success = false;
        // System.out.println("Password could not be created.");
      }

    }
    f.close();
    sc.close();
  }

}