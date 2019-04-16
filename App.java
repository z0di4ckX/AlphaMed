import javax.swing.*;
import java.util.*;
import java.io.*;

public class App extends Main{
   String file, outputDoc; // variable
           
   FileReader reader; // Opens existing document
   Scanner fileInput; // Allows us to see contents inside of document
   PrintWriter fileOutput; // Writes inside doc.

   Scanner input = new Scanner(System.in); // Scanner class  

    // menu method
    void menu() {
        String listMenu = " "; 

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
      int bs = Integer.parseInt(JOptionPane.showInputDialog(null, "How many do you bought product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));// bought stack
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
}

