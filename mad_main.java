import java.util.*;
import java.io.*;
import java.lang.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class mad{
	
	public static void main(String arg[]) throws Exception
    {
    
		FileInputStream file = new FileInputStream(new File("output.xls"));
		//Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		double count=0;
		double size=35;
		double w=1;
		double v = 0.66*size, val=0,df=0;
	// System.out.println(v);
		
		double m=0, mad=0,madcount=0;
		HSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<Double> list = new ArrayList<>();
		ArrayList<Integer> protein = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator(); // Traversing over each row of XLSX file
	       while (rowIterator.hasNext()) {
	           Row row = rowIterator.next(); // For each row, iterate through each columns
	           Iterator<Cell> cellIterator = row.cellIterator();
	           while (cellIterator.hasNext()) {
	               Cell cell = cellIterator.next();
	               double value = cell.getNumericCellValue();
	               Integer i=(int) value;
	               protein.add(i);
	               if(cell.getColumnIndex()>0 && cell.getColumnIndex()<(size+1))//for example of c
	               {
	               // list.add(cell.getStringCellValue()); 
	            	   
	            	   if (value !=0.0)
	            	   {
	            	        count=count+value; 
	            	        list.add(value);
	            	   
	            	   }
	            	   }
	               
	              }
	            m=count/list.size();
	            System.out.println("df"+" "+list.size());
	            Logger.log1(list.size());
	            int xx=list.size();
	            val=0;
	            while(xx>0){
	            val =val+ Math.abs(list.get(xx-1)-m); 	 
	            xx--;
	            }
      	       mad= val/list.size();
      	        df=list.size();
      	        
      	        if(mad<=w && df >= v)
      	        {
      	        	 final String FILENAME = "protein.txt";
      	            BufferedWriter bw = null;
      	            FileWriter fw = null;
      	            try{
      	              fw = new FileWriter(FILENAME,true);
      	        bw = new BufferedWriter(fw);
      	           PrintWriter out = new PrintWriter(bw);
      	           int x=0;
      	           while(x<protein.size()){
      	           out.print(protein.get(x)+"\t");
      	           x++;
      	           }
      	           out.println();
      	            }
      	            catch (IOException e) {

      	            e.printStackTrace();

      	            } finally {

      	            try {

      	            if (bw != null)
      	            bw.close();

      	            if (fw != null)
      	            fw.close();

      	            } catch (IOException ex) {

      	            ex.printStackTrace();

      	            }

      	            }
      	        }
 
            df=0;
   	       count=0;   	        
   	      list = new ArrayList<>();
   	      protein= new ArrayList<>();

    }
    System.out.println("done");
    workbook.close();
    file.close();
    
	
	

}
}
