import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class App extends Main{
   String file, files, patientFile, strLine, error; // variable
           
   FileReader reader; // Opens existing document
   Scanner fileInput; // Allows us to see contents inside of document
   PrintWriter fileOutput; // Writes inside doc.

   Scanner input = new Scanner(System.in); // Scanner class  

    // menu method
   void menu() {
      String listMenu = " "; 
   
      do {
         listMenu = JOptionPane.showInputDialog(null, "a. Add items\n b. Show items \n B. Sub-menu\n C. Show sub-menu\n c. Patients registration\n d. Show patients\n e. Remove items\n x. Exit", "Menu", JOptionPane.INFORMATION_MESSAGE);
            
         if (listMenu.equals ("a")) {
            printItems();
         }
         else if (listMenu.equals ("b")) { 
            showItems();
         }
         else if (listMenu.equals("B")) {
            printSubMenuShowItems();
         }
         else if (listMenu.equals("C")) {
            subShowItems();
         }
         else if (listMenu.equals("c")) {
            printPatients();
         }
         else if (listMenu.equals("d")) {
            showPatients();
         }
         else if (listMenu.equals ("e")) {
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
      String itemsCode = JOptionPane.showInputDialog(null, String.format("Items code:\n %3s%3d", "Adding items", JOptionPane.INFORMATION_MESSAGE)); // Items code
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
         JOptionPane.showMessageDialog(null, "File not found");
      }
      fileInput.close();
   } // Show items

   public Vector subMenuShowItems() {
      String firstItems = JOptionPane.showInputDialog(null, "Your first items:\n", "Shopping", JOptionPane.INFORMATION_MESSAGE);
      int quantityItems = Integer.parseInt(JOptionPane.showInputDialog(null, "How many do you buy?\n", "Shopping", JOptionPane.INFORMATION_MESSAGE));
      String dateItems = JOptionPane.showInputDialog(null, "The day of you buy?\n", "Shopping", JOptionPane.INFORMATION_MESSAGE);

      Vector vector1 = new Vector();

      vector1.add(firstItems);
      vector1.add(quantityItems);
      vector1.add(dateItems);

      return(vector1);
   } // end subMenuShowItems

   public void printSubMenuShowItems() { // print-subMenu
      files = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);

      try {
         fileOutput = new PrintWriter(files + ".txt");
         
         Vector vector1 = this.subMenuShowItems();

         fileOutput.println("Name: " + vector1.get(0));
         fileOutput.println("Quantity: " + vector1.get(1));
         fileOutput.println("Date: " + vector1.get(2));
      } 
      catch (Exception e) {
         System.out.println(e);
         JOptionPane.showMessageDialog(null, "File not found", "Messange", JOptionPane.INFORMATION_MESSAGE);
      }
   }// end print-subMenu method 

   public void subShowItems() { // sub-menu
      String[] subShowItemsMenu = new String[3];

      files = JOptionPane.showInputDialog(null, "Name of file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);

      try {
       reader = new FileReader(files + ".txt");
       fileInput = new Scanner(reader);
       
       for(int i = 0; i < subShowItemsMenu.length; i++) {
         
         if(fileInput.hasNext()) {
            strLine = fileInput.nextLine();
            subShowItemsMenu[i] = strLine;
         }// end if
       } // end for loop

       JOptionPane.showMessageDialog(null, 
         subShowItemsMenu[0] + "\n" +
         subShowItemsMenu[1] + "\n" +
         subShowItemsMenu[2], "Show your Items", JOptionPane.INFORMATION_MESSAGE);
      } 
      catch (Exception e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "File not found");
      }
      fileInput.close();
   }
   
   public Vector patients() { // opcion 'C' - creaing patient file
      String nameOfPatients = JOptionPane.showInputDialog(null, "Name:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE);
      int fileNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Patients file number:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE));
      int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Age:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE));
      char sex = JOptionPane.showInputDialog(null, "Sex, please enter (M) for Men of (F) for Femal:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE).charAt(0);
      String patientsAddress = JOptionPane.showInputDialog(null, " Patients address:\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE);
      String appointment = JOptionPane.showInputDialog(null, "Date of the Appointment  (MMDDYYYY):\n", "Patients Registration", JOptionPane.INFORMATION_MESSAGE);
   
      Vector vec = new Vector();
   
      vec.add(nameOfPatients);
      vec.add(fileNumber);
      vec.add(age);
      vec.add(sex);
      vec.add(patientsAddress);
      vec.add(appointment);
   
      return (vec);
   }

   public void printPatients() { // print patient data
   
      patientFile = JOptionPane.showInputDialog(null, "Name of the patient file:\n", "File name", JOptionPane.INFORMATION_MESSAGE);
   
      try {
         fileOutput = new PrintWriter(patientFile + ".txt");
      
         Vector vec1 = this.patients();
      
         fileOutput.println("Name of the patients: " + vec1.get(0));
         fileOutput.println("Patients file number: " + vec1.get(1));
         fileOutput.println("Age of the patients: " + vec1.get(2));
         fileOutput.println("Sex of the patients: " + vec1.get(3));
         fileOutput.println("patients Addresss: " + vec1.get(4));
         fileOutput.println("Appointment: " + vec1.get(5));
      } 
      catch (Exception e) {
         System.out.println(e);
         JOptionPane.showMessageDialog(null, "Patient not found");
      }
      fileOutput.close();
   }

   public void showPatients() { // showing patients regitration
      String [] patientItem = new String[6];
      String patientFile = "", 
             patientNumber = "", 
             appDate = "";
   
      patientNumber = JOptionPane.showInputDialog(null, "Patients File Number:\n", "Find Patient", JOptionPane.INFORMATION_MESSAGE);
      appDate = JOptionPane.showInputDialog(null, "Apointment Date (MMDDYYYY):\n", "Find Patient", JOptionPane.INFORMATION_MESSAGE);
      try {
         patientFile = this.invFiles(patientNumber, appDate);
         
         reader = new FileReader(patientFile);
         fileInput = new Scanner(reader);
      
         for (int i = 0; i < patientItem.length; i++) { // appends .txt file lines to array
            if (fileInput.hasNext()) {
               strLine = fileInput.nextLine();
               patientItem[i] = strLine;
            }
         } // end for
      
         //Display file contents
         JOptionPane.showMessageDialog(null, 
            patientItem[0] + "\n" +
            patientItem[1] + "\n" +
            patientItem[2] + "\n" +
            patientItem[3] + "\n" +
            patientItem[4] + "\n" +
            patientItem[5], "Show Patients Registration", JOptionPane.PLAIN_MESSAGE);
      
      } 
      catch (Exception e) {
         System.out.println(e);
         JOptionPane.showMessageDialog(null, "Patient not Found");
      }
      fileInput.close();
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
   
   // To find patient archives
   public String invFiles(String id, String appointment) {
      String searchFile = "", 
             appoint = "",
             idPatient = "";

      File rootFile = new File(".");
      File [] invFile = rootFile.listFiles();
      
      for (int i = 0; i < invFile.length; i++) {
         if (invFile[i].getName().endsWith(".txt")) {
            try {

               reader = new FileReader(invFile[i].getName());
               fileInput = new Scanner(reader);
               do {
                  strLine = fileInput.nextLine();
                  if (strLine.endsWith(id)) {
                     idPatient = id;
                  } else if (strLine.endsWith(appointment)) {
                     appoint = appointment;
                  }

                  if ((idPatient != "") && (appoint != "")) {
                     if ((appoint.equals(appointment) && (id.equals(idPatient)))) {
                        searchFile = invFile[i].getName();
                        fileInput.close();
                        break;
                     }
                  }
               } while (fileInput.hasNext());

               fileInput.close();
            } catch (Exception e) {
               System.out.println(e);
               JOptionPane.showMessageDialog(null, "File not found", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
            }
         }
      } // end for
      
      fileInput.close();
      return (searchFile);
   } // invFiles()
} // end App Class
