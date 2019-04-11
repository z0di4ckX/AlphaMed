import javax.swing.*;
import java.util.*;

public class App {
    Scanner input = new Scanner(System.in);

    String welcome = JOptionPane.showMessageDialog(null, "Welcome our App");
    String creator = JOptionPane.showMessageDialog(null, "The creator is: Wesly J. Hernandez, Giancarlo, Jeremy y Valeria");

    void menu() {
        String listMenu = " ";

        String user = JOptionPane.showInputDialog(null, "User", "LogIn", JOptionPane.INFORMATION_MESSAGE);
        String password = JOptionPane.showInputDialog(null, "Password", "LogIn", JOptionPane.INFORMATION_MESSAGE);

        if ("adim".equals(user) && "myPassword".equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successfuly", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Login failed\n Please try agen", "Login", JOptionPane.INFORMATION_MESSAGE);
        }

        do {
            listMenu = JOptionPane.showInputDialog(null, "a. Add items\n b. Show items\n c. Remove items\n x. Exit", "Menu", JOptionPane.INFORMATION_MESSAGE);
            
            if (listMenu.equals ("a")) {

                String name = JOptionPane.showInputDialog(null, "Name of product:\n", "Addign items", JOptionPane.INFORMATION_MESSAGE);

                int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day you bought the lot:\n", "Addign items", JOptionPane.INFORMATION_MESSAGE));

                int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity Sold of product:\n", "Addign items", JOptionPane.INFORMATION_MESSAGE));

                int price = Integer.parseInt(JOptionPane.showInputDialog(null, "Items Prices of product:\n", "Addign items", JOptionPane.INFORMATION_MESSAGE));
            }
            else if (listMenu.equals ("b")) { 
                JOptionPane.showMessageDialog(null, "Showing items");
            }
            else if (listMenu.equals ("c")) {
                JOptionPane.showConfirmDialog(null,"Are you sure you want to delete a product? ", "Delet the items", JOptionPane.YES_NO_CANCEL_OPTION);
            }
            else if (listMenu.equals ("x")) {
                JOptionPane.showMessageDialog(null, "Thank you for user own system. See it soon!", "Exit!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please try agen.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }while(!listMenu.equals("x"));
    }
}
