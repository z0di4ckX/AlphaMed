import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) { //test main method. Will probably be put on another .java
        /**
        * THIS MAIN METHOD WILL BE THE LAST THING WE ORGANIZE
        * First we must complete the methods
        *
        *
        * login() complete
        * if login() is not correct, keep looping. do no open menu()
        * open menu() if login succesful
        * all other methods also complete
        */
         JOptionPane.showMessageDialog(null, "Welcome our App");
         JOptionPane.showMessageDialog(null, "The creator is: Wesly J. Hernandez, Giancarlo E. Ventura, Jeremy Del Valle");
         
         // none of this main is for end product. Just testing method functionality
         App app = new App(); // App class
         LogIn login = new LogIn(); // logIn class

         login.login(); // call login method
         app.menu(); // call menu method
       }
}