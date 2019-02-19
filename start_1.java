
import java.io.*;
import java.util.*;
import java.io.*;
import java.lang.*;
		 
		   public class c1{
		public static ArrayList<String> showFiles(File[] files,ArrayList<String> file_names) {

			   for (File file : files) {
			       if (file.isDirectory()) {
			           showFiles(file.listFiles(),file_names); // Calls same method again.
			       } else {
			        file_names.add(file.getName());
			           
			       }
			   }
			   return file_names;
			}
			public static void main(String[] args) {
			File[] files = new File("/home/debanjali/Desktop/SCOPalphaAndBetaProt/").listFiles();
			ArrayList<String> file_name= new ArrayList<String>();
			   file_name= showFiles(files,file_name);
			   System.out.println(file_name);
			   System.out.println(file_name.size());
			}
		     
	}


