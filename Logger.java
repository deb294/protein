import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class Logger {
	 // public static HashMap<String, Integer> map = new HashMap<String,Integer>();

	public static void log(HashMap<String, ArrayList<String>> dirFiles) { 
	      PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("df.csv", true), true);
			//out.write(map.toString());
			out.write(dirFiles.toString());
		      out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // out.write(map.toString());
	     //out.close();
	    }

	public static void log1(int i) { 
		
		 PrintWriter out1 = null;
		 
	       	try {
				out1 = new PrintWriter(new FileWriter("df.csv", true), true);
				//out1.write(map.toString());
				out1.write(i+"\r\n");
				
			      out1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	
		     // out.write(map);
		     // out.close();
		    }
	}
	


