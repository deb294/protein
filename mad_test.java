
import java.io.File;


import java.util.*;
import java.io.*;

public class file {
public static void main (String [] args) throws IOException{
 Scanner file = new Scanner(new File("protein.txt"));
 int count = 0;
 while (file.hasNextLine()) {
	  count++;
	  file.nextLine();
	}

 System.out.println("key count afte MAD \n"+ count);
}
  }
