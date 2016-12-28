package network;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class BookClient {
  public static void main(String args[]) throws Exception {
    // connect to server socket
    Socket s = new Socket("localhost",3000);
    // Access Keyboard
    Scanner sc = new Scanner(System.in);
    // take input and output stream of the socket
    BufferedReader sin = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter sout = new PrintWriter(s.getOutputStream(),true);
    String title,bookno;

    while (true) {
      // take book no from user
      System.out.println("Enter book number [0 to stop] : ");
      bookno = sc.nextLine();
      sout.println(bookno);  // send value to server
      if ( bookno.equals("0") ) break;   
      title = sin.readLine();
      if ( title.length() != 0 )
         System.out.println("Book Title : " + title);
      else
          System.out.println("Sorry! Invalid Book Number.");
    } // while
  } // end of main
} // end of class

