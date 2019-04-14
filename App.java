import javax.swing.*;
import java.util.*;
import java.io.FileReader;
import java.io.PrintWriter;

public class App {
    String file, 
           outputDoc, 
           user, 
           password;
           
   FileReader reader; // Opens existing document
   Scanner fileInput; // Allows us to see contents inside of document
   PrintWriter fileOutput; // Writes inside doc.
   Scanner input = new Scanner(System.in);  
    
    void login() {
        user = JOptionPane.showInputDialog(null, "User", "LogIn", JOptionPane.INFORMATION_MESSAGE);
        password = JOptionPane.showInputDialog(null, "Password", "LogIn", JOptionPane.INFORMATION_MESSAGE);
    }
    
    void menu() {
        String listMenu = " ";

        if ("admin".equals(user) && "myPassword".equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successfuly", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Login failed\n Please try agen", "Login", JOptionPane.INFORMATION_MESSAGE);
        } // This if-else probably has to go outside of menu(). maybe inside of main method, not in the class 

        do {
            listMenu = JOptionPane.showInputDialog(null, "a. Add items\n b. Show items\n c. Remove items\n x. Exit", "Menu", JOptionPane.INFORMATION_MESSAGE);
            
            if (listMenu.equals ("a")) {
               addItems();
            }
            else if (listMenu.equals ("b")) { 
                showItems();
            }
            else if (listMenu.equals ("c")) {
               deleteItems();
           }
            else if (listMenu.equals ("x")) {
                JOptionPane.showMessageDialog(null, "Thank you for user own system. See it soon!", "Exit!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please try agen.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } while(!listMenu.equals("x"));
     } // menu()
     
   public void addItems() { // option 'a'
      String name = JOptionPane.showInputDialog(null, "Name of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE);
      int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day you bought the lot:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity Sold of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int price = Integer.parseInt(JOptionPane.showInputDialog(null, "Items Prices of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
    }
        
   public void printItems() { // Uses information gathered in addItems()
      // Use printwriter to make .txt
   }
        
   public void showItems() { // option 'b'- Displays items already registered
      JOptionPane.showMessageDialog(null, "Showing items");
      // probably use fileReader
   }
        
   public void deleteItems() { // option 'c'
      JOptionPane.showConfirmDialog(null,"Are you sure you want to delete a product? ", "Delete the items", JOptionPane.YES_NO_CANCEL_OPTION);
   }
   
   public static void main (String[] args) { //test main method. Will probably be put on another .java
   /**
   * THIS MAIN METHOD WILL BE THE LAST THING WE ORGANIZE
   * First we must complete the methods
   *
   *
   * mising----
   * login() incomplete
   * if login() is not correct, keep looping. do no open menu()
   * open menu() if login succesful
   * all other methods also incomplete
   */
    JOptionPane.showMessageDialog(null, "Welcome our App");
    JOptionPane.showMessageDialog(null, "The creator is: Wesly J. Hernandez, Giancarlo, Jeremy y Valeria");
    
    // none of this main is for end product. Just testing method functionality
    App test = new App();
    test.login(); 
    test.menu();
  }
}

