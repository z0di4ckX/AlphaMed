import javax.swing.*;

class LogIn extends App{
  String user = " ", password = " "; // variable

    // login method
    void login() {
        user = JOptionPane.showInputDialog(null, "User", "LogIn", JOptionPane.INFORMATION_MESSAGE); // user input
        password = JOptionPane.showInputDialog(null, "Password", "LogIn", JOptionPane.INFORMATION_MESSAGE); // password input

        do {
          // user login
          if (user.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Login successfuly", "Login", JOptionPane.INFORMATION_MESSAGE);
          }
          else if (user != "admin") {
            JOptionPane.showMessageDialog(null, "User incorrect\n Please try agen", "Login",  JOptionPane.ERROR_MESSAGE);
          }
          else if (password != "1234") {
           JOptionPane.showMessageDialog(null, "Password incorrect\n Please try agen", "Login",  JOptionPane.ERROR_MESSAGE); 
          } 

        }while(!user.equals("admin")&& password.equals("1234"));
        // This if-else probably has to go outside of menu(). maybe inside of main method, not in the class
    }
}