import javax.swing.*;
import java.util.*;
import java.io.*;

public class App extends Main{
   String file, outputDoc, strLine; // variable
           
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
                JOptionPane.showMessageDialog(null, "Thank you for user own system. See it soon!", "Exit!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please try agen.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } while(!listMenu.equals("x"));
     } // menu()
     
   public Vector addItems() { // option 'a'
      String name = JOptionPane.showInputDialog(null, "Name of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE);
      int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day you bought the lot:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int bs = Integer.parseInt(JOptionPane.showInputDialog(null, "How many do you bought product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));// bought stack
      int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity Sold of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int price = Integer.parseInt(JOptionPane.showInputDialog(null, "Items Prices of product:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));

      Vector v = new Vector();
      v.add(name);
      v.add(day);
      v.add(bs);
      v.add(quantity);
      v.add(price);

      return (v);
    }
        
   public void printItems() { // Uses information gathered in addItems()
      file = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);
      try {
         fileOutput = new PrintWriter(file+".txt");
      
         Vector ve = this.addItems();
      
         fileOutput.println("Name: "+ve.get(0));
         fileOutput.println("Bought on: "+ve.get(1));
         fileOutput.println("Quantity: "+ve.get(2));
         fileOutput.println("Sold: "+ve.get(3));
         fileOutput.println("Price: "+ve.get(4));
         fileOutput.close();
      } catch(Exception e){
         System.out.println("Error");
      }
   }
        
   public void showItems() { // option 'b'- Displays items already registered
      String [] item = new String[5];

      file = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);
      try {
         reader = new FileReader(file + ".txt");
         fileInput = new Scanner(reader);

         while(fileInput.hasNext()) {
            strLine = fileInput.nextLine();
            System.out.println(strLine);
         }
      }
      catch (Exception e) {
         // not argument
      }
      JOptionPane.showMessageDialog(null, "Showing items");
      
   }
        
   public void deleteItems() { // option 'c'
      JOptionPane.showConfirmDialog(null,"Are you sure you want to delete a product? ", "Delete the items", JOptionPane.YES_NO_CANCEL_OPTION);
   }
}

