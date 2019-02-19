import java.util.*;
import java.io.*;
public class MainTest1 
{
   public static void main(String[] args) throws Exception
   {
      
       String filepath= "/home/debanjali/Desktop/dataset/alphaandbeta/";
    		   //"/home/debanjali/Desktop/SCOPalphaAndBetaProt/";
      
       File dir=new File(filepath);
       if (!dir.exists())
       {
           System.out.println("No Such File");
           System.exit(0);
        }
       String names[]=dir.list();
       System.out.println(names.length);
       //displaying filenames
       for(int i=0;i<names.length;i++)
       {
           System.out.println(names[i]);
           names[i]=filepath+"/"+names[i];
       }
       System.out.println(names[0]);
       //read file content
       for (int i =1;i<35;i++)
       {
    	   FileInputStream fis1=new FileInputStream(names[i-1]);
    	   byte buffer1[]=new byte[fis1.available()];
    	   fis1.read(buffer1);
    	  String  content1=new String(buffer1);
    	  StringTokenizer stk1=new StringTokenizer(content1,"\n");
    	 
    	  Vector key1=new Vector();
    	  Vector c1=new Vector();
    	  while(stk1.hasMoreTokens())
          {
              String s1=stk1.nextToken().toString();
             // System.out.println(s1);//**************to display file1 content ****************
              String tokens[]=s1.split("\t");
            key1.add(tokens[0]);
            c1.add(tokens[1]);
           }
    	  FileWriter keys1=new FileWriter("keys"+i+".txt");
    	  FileWriter fc1=new FileWriter("ocount"+i+".txt");
    	  FileWriter fw1=new FileWriter("output.txt",true);
    	  BufferedWriter bw= new BufferedWriter(fw1);
    	  PrintWriter out = new PrintWriter(bw);
    	  for(Object e:c1)
    	   {
    	       fc1.write(e.toString()+"\n");
    	    }
    	  fc1.close();
    	  for(Object e:key1)
    	   {
    	      out.print(e.toString()+"\n");
    	       keys1.write(e.toString()+"\n");
    	    }
    	    keys1.close();
    	    
       }
      System.out.println("done");
   }
   
}
