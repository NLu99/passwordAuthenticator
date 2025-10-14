// improved logic

public class passwordAuthenticator {
  private final String password;
  private final String confirmPassword;

  // constructor
  public passwordAuthenticator(String password, String confirmPassword) {
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  // method to check whether the strings are the same and if they contain a number
  public boolean passwordCheck() {
    // check whether the strings are the same
    if (!password.equals(confirmPassword)) {
      System.out.println("Error creating password: Passwords do not match.");
      return false;
    }

    // check if the password contains a number
    if (!password.matches(".*\\d+.*")) {
      // if not, show error message
      System.out.println("Error creating password: Password chould contain at least one number.");
      return false;
    }

    return true;
  }
}