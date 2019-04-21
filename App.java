import javax.swing.*;
import java.util.*;
import java.io.*;

public class App extends Main{
   String file, files, outputDoc, strLine; // variable
           
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
               printItems();
            }
            else if (listMenu.equals ("b")) { 
                showItems();
            }
            else if (listMenu.equals ("c")) {
               deleteItems();
           }
            else if (listMenu.equals ("x")) {
                JOptionPane.showMessageDialog(null, "Thank you for using our system. See you soon!", "Exit!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please try agen.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } while(!listMenu.equals("x"));
     } // menu()
     
   public Vector addItems() { // option 'a'
      String name = JOptionPane.showInputDialog(null, "Name of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE);
      String description = JOptionPane.showInputDialog(null, "Description of the items:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE); // Description product
      String itemsCode = JOptionPane.showInputDialog(null, "Items code:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE); // Items code
      int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Date of lot bought:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int expiry = Integer.parseInt(JOptionPane.showInputDialog(null, "Date of lot expiration:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE)); // Expiration date
      int bs = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity bought:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));// bought stack
      int available = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity available:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE)); // Quantity available
      int damaged = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity damaged:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE)); // Quantity damaged
      int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity Sold:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int price = Integer.parseInt(JOptionPane.showInputDialog(null, "Prices of products:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));

      Vector v = new Vector();
      v.add(name);
      v.add(description);
      v.add(itemsCode);
      v.add(day);
      v.add(expiry);
      v.add(bs);
      v.add(available);
      v.add(damaged);
      v.add(quantity);
      v.add(price);

      return (v);
    }
        
   public void printItems() { // Uses information gathered in addItems()
      file = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);
      try {
         fileOutput = new PrintWriter(file + ".txt");
      
         Vector ve = this.addItems();
      
         fileOutput.println("Name: "+ve.get(0));
         fileOutput.println("Description: "+ve.get(1));
         fileOutput.println("Items code: "+ve.get(2));
         fileOutput.println("Bought lot on: "+ve.get(3));
         fileOutput.println("Expiration lot: "+ve.get(4));
         fileOutput.println("Quantity bought: "+ve.get(5));
         fileOutput.println("Available: "+ve.get(6));
         fileOutput.println("Expiration: "+ve.get(7));
         fileOutput.println("Sold: "+ve.get(8));
         fileOutput.println("Price: "+ve.get(9));
         fileOutput.close();
      } catch(Exception e){
         System.out.println("Error");
      }
   }
        
   public void showItems() { // option 'b'- Displays items already registered
      String [] item = new String[10];

      file = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);
      try {
         reader = new FileReader(file + ".txt");
         fileInput = new Scanner(reader);

         while(fileInput.hasNext()) {
            strLine = fileInput.nextLine();
            JOptionPane.showMessageDialog(null, strLine, "Show items", JOptionPane.PLAIN_MESSAGE);
         }
      }
      catch (Exception e) {
         // not arrgument
      }
      
      
   }
        
   public void deleteItems() { // option 'c' - Delete the existing file
   /*
    * It is necessary to improve the code to delete the files, add the .txt so that the user does not have to put it. 
    * At the moment the code works well and deletes the file that is selected
    * Fix it the dalte algorithm
   */

      try {
         File files = new File(JOptionPane.showInputDialog(null, "Name of file: ", "File name", JOptionPane.INFORMATION_MESSAGE)); // add .txt
         files = new File(files + ".txt");
             
         if (files.delete()) {
            JOptionPane.showMessageDialog(null, "This file was deleted", "Delete Itmes", JOptionPane.INFORMATION_MESSAGE); // delete the file
         }
         else {
            JOptionPane.showMessageDialog(null, "This file does not exist, please try again and enter the correct name", "Delete Itmes", JOptionPane.INFORMATION_MESSAGE); // error message
         }
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
}

