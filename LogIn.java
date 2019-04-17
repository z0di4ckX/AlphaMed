import javax.swing.*;

class LogIn extends App{
  String user = " ", password = " "; // variable

    // login method
    void login() {

        do {
          user = JOptionPane.showInputDialog(null, "User", "LogIn", JOptionPane.INFORMATION_MESSAGE); // user input
          password = JOptionPane.showInputDialog(null, "Password", "LogIn", JOptionPane.INFORMATION_MESSAGE); // password input

          // user login
          if (user.equals("admin") && password.equals("123456")) {
            JOptionPane.showMessageDialog(null, "Login successfuly", "Login", JOptionPane.INFORMATION_MESSAGE);
          }
          else {
            JOptionPane.showMessageDialog(null, "Login fails, please try agen", "Login", JOptionPane.ERROR_MESSAGE);
          }
        }while(user.equals("admin") == false && password.equals("1234") == false);
        // This if-else probably has to go outside of menu(). maybe inside of main method, not in the class
    }
}