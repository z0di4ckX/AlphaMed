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
        * mising----
        * login() incomplete
        * if login() is not correct, keep looping. do no open menu()
        * open menu() if login succesful
        * all other methods also incomplete
        */
         JOptionPane.showMessageDialog(null, "Welcome our App");
         JOptionPane.showMessageDialog(null, "The creator is: Wesly J. Hernandez, Giancarlo, Jeremy");
         
         // none of this main is for end product. Just testing method functionality
         App test = new App(); // App class
         LogIn login = new LogIn(); // logIn class
     
         login.login(); // call login method
         test.menu(); // call menu method
       }
}