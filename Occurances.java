import java.util.*;
import java.io.*;
public class Occurances {


    public static void main(String[] args) throws Exception
    {
         
        
         FileInputStream unikeys=new FileInputStream("inv_index.txt");
         
         byte ubuffer[]=new byte[unikeys.available()];
         unikeys.read(ubuffer);
         String ucontent=new String(ubuffer);
         StringTokenizer ustk=new StringTokenizer(ucontent,"\n");
         Vector uv=new Vector();
         while(ustk.hasMoreTokens())
         {
             uv.add(ustk.nextToken().toString());
         }
             unikeys.close();
             FileWriter fw1=new FileWriter("occ.txt");
             for(Object u:uv)
        {     ArrayList<Integer>f1= new ArrayList<Integer>();
        	String line="";
         
         for (int i=1; i<35;i++)
         {
        	 FileInputStream keys1=new FileInputStream("keys"+i+".txt");
        	 FileInputStream kc1=new FileInputStream("ocount"+i+".txt");
        	 byte k1buffer[]=new byte[keys1.available()];

             byte c1buffer[]=new byte[kc1.available()];
             keys1.read(k1buffer);
             kc1.read(c1buffer);
             
             String k1content=new String(k1buffer);
             String c1content=new String(c1buffer);
             StringTokenizer k1stk=new StringTokenizer(k1content,"\n");
             StringTokenizer c1stk=new StringTokenizer(c1content,"\n");
             Vector k1v=new Vector();
             Vector c1v=new Vector();
             while(k1stk.hasMoreTokens())
             {
                 k1v.add(k1stk.nextToken().toString());
             }
             while(c1stk.hasMoreTokens())
             {
                 c1v.add(c1stk.nextToken().toString());
             }
             keys1.close();
             kc1.close();
             String token=u.toString();
             //
             for(int j=0;j<k1v.size();j++)
             {
                 if (k1v.elementAt(j).toString().equals(token))
                 {
                     f1.add(new Integer(c1v.elementAt(j).toString()));
                     break;
                     
                 }
                 else 
                	 f1.add(0);
             }
             line=token+"\t";
             for(int loop=0;loop<f1.size();loop++){
             line=line+f1.get(loop)+"\t";
             }
             line=line+"\n";
         }
         
        
         fw1.write(line);
 }

 System.out.println("key is generated");
 fw1.close();
  }
}
        
      
       
