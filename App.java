import javax.swing.*;
import java.util.*;
import java.io.*;

public class App extends Main{
   String file, files, patientFile, outputDoc, strLine, error; // variable
           
   FileReader reader; // Opens existing document
   Scanner fileInput; // Allows us to see contents inside of document
   PrintWriter fileOutput; // Writes inside doc.

   Scanner input = new Scanner(System.in); // Scanner class  

    // menu method
    void menu() {
        String listMenu = " "; 

        do {
            listMenu = JOptionPane.showInputDialog(null, "a. Add items\n b. Show items\n c. patients registration\n d. Remove items\n x. Exit", "Menu", JOptionPane.INFORMATION_MESSAGE);
            
            if (listMenu.equals ("a")) {
               printItems();
            }
            else if (listMenu.equals ("b")) { 
                showItems();
            }
            else if (listMenu.equals("c")) {
               patients();
            }
            else if (listMenu.equals ("d")) {
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
      String day = JOptionPane.showInputDialog(null, "Date of lot bought:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE);
      String expiry = JOptionPane.showInputDialog(null, "Date of lot expiration:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE); // Expiration date
      int lot = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity bought:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));// bought stack
      int damaged = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity damaged:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE)); // Quantity damaged
      int sold = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity Sold:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Prices of products:\n", "Adding items", JOptionPane.INFORMATION_MESSAGE));
      int available = lot - damaged - sold;
      double total = sold * price;

      Vector v = new Vector();
      v.add(name);
      v.add(description);
      v.add(itemsCode);
      v.add(day);
      v.add(expiry);
      v.add(lot);
      v.add(available);
      v.add(damaged);
      v.add(sold);
      v.add(price);
      v.add(total);

      return (v);
   }// addItems
        
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
         fileOutput.println("Price: $ "+ve.get(9));
         fileOutput.println("Total: $ "+ve.get(10));

      } catch(Exception e){
         System.out.println(e);
      }
      fileOutput.close();
   } // printItems
        
   public void showItems() { // option 'b'- Displays items already registered
      String [] item = new String[11];

      file = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);
      try {
         reader = new FileReader(file + ".txt");
         fileInput = new Scanner(reader);

         for (int i = 0; i < item.length; i++) { // appends .txt file lines to array
            if (fileInput.hasNext()) {
               strLine = fileInput.nextLine();
               item[i] = strLine;
            }
         } // end for

         //Display file contents
         JOptionPane.showMessageDialog(null, 
            item[0] + " ---- " + item[2] + "\n" +
            item[1] + "\n" +
            item[3] + "\n" +
            item[4] + "\n" +
            item[5] + "\n" +
            item[6] + "\n" +
            item[7] + "\n" +
            item[8] + "\n" +
            item[9] + "\n" +
            item[10], "Show items", JOptionPane.PLAIN_MESSAGE);
      }
      catch (Exception e) {
         System.out.println(e);
      }
      fileInput.close();
   } // Show items

   public Vector patients() { // opcion 'C' - creaing patient file
      String nameOfPatients = JOptionPane.showInputDialog(null, "Name:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE);
      int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Age:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE));
      char sex = JOptionPane.showInputDialog(null, "Sex, please enter (M) for Men of (F) for Femal:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE).charAt(0);
      String patientsDescription = JOptionPane.showInputDialog(null, "Description of the patient\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE);

      Vector vec = new Vector();

      vec.add(nameOfPatients);
      vec.add(age);
      vec.add(sex);
      vec.add(patientsDescription);

      return (vec);
   }

   public void printPatients() { // print patient data
   
      patientFile = JOptionPane.showInputDialog(null, "Name of the patient file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);

      try {
         fileOutput = new PrintWriter(patientFile + ".txt");

         Vector vec1 = this.patients();

         fileOutput.println("Name of the patients: " + vec1.get(0));
         fileOutput.println("Age of the patients: " + vec1.get(1));
         fileOutput.println("Sex of the patients: " + vec1.get(2));
         fileOutput.println("Description of the patients: " + vec1.get(3));
      } 
      catch (Exception e) {
        System.out.println(e);
      }
      fileOutput.close();
   }
        
   public void deleteItems() { // option 'D' - Delete the existing file
      try {

         File files = new File(JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE)); // add .txt
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
