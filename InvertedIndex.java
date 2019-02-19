import java.util.*;
import java.io.*;
public class InvertedIndex
{
    public static void main(String arg[]) throws Exception
    {
    
    
        String filename="output.txt";
        FileInputStream fis=new FileInputStream(filename);
        byte buffer[]=new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        String fcontent=new String(buffer);
        StringTokenizer stk=new StringTokenizer(fcontent,"\n");
        System.out.println("Entire File Size : "+ stk.countTokens());
        //****** generate unique keys collection  ****** 
        Vector uniquedata=new Vector();
        while(stk.hasMoreTokens())
        {
            Object e=stk.nextToken();
             if (!uniquedata.contains(e))
                 uniquedata.add(e);
            //System.out.println(stk1.nextToken());
        }
        
        System.out.println("Unique keys count :"+uniquedata.size());
        //*************** create inverted index file *************
        FileWriter invfile=new FileWriter("inv_index.txt");
        for(Object e:uniquedata)
        {
            invfile.write(e.toString()+"\n");
        }
        invfile.close();
        System.out.println("Inverted Index File is created");

}
}
