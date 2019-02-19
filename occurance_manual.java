import java.util.*;
import java.io.*;
import java.lang.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class occurance {
	
	public static int getMin(ArrayList<Integer> list1,ArrayList<Integer> list2){
		int i= list1.size();
			
		int x=1,y=0;
		int z=0;
		
		while(y<i && x<i){
			
			z= z+Math.min(list1.get(x), list2.get(x));
			y++;
			x++;
		}
		return z;
		
		
	}

	public static void main(String arg[]) throws Exception
    {
		FileInputStream file = new FileInputStream(new File("protein.xls"));
		
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<Integer> list1=new ArrayList<>();
		ArrayList<Integer> list2=new ArrayList<>();
		int matrix [][]=new int[4275][4275];
		int count=0,cou=0;
		Iterator<Row> rowIterator = sheet.iterator(); 
		Iterator<Row> nextrowiter = sheet.iterator(); 
		ArrayList<Integer> Keys=new ArrayList<>();
		while(rowIterator.hasNext()){
			cou=0;
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
	    	while (cellIterator.hasNext()){
	    		Cell cell = cellIterator.next();
	    		double value = cell.getNumericCellValue();
	            Integer i=(int) value;
	            list1.add(i);
	            if(cell.getColumnIndex()==0)
	    			Keys.add(i);
	        }
	    	count++;
	    	nextrowiter = sheet.iterator();
	    	for(int i=0; i<count;i++){
	    		nextrowiter.next();	
	    		cou++;
	    	}
	    	while(nextrowiter.hasNext()){
	    		Row nextrow = nextrowiter.next();
	    		cou++;
	    		Iterator<Cell> nextcellIterator = nextrow.cellIterator();
		        while (nextcellIterator.hasNext()) {
		        	 Cell nextcell = nextcellIterator.next();
		             double value1 = nextcell.getNumericCellValue();
			         Integer i1=(int) value1;
			         list2.add(i1);
		           }
		        int minimum= getMin(list1,list2);
		        matrix[count][cou]= minimum;
		        matrix[cou][count]=minimum;
		        list2 = new ArrayList<>();
		        
	    	}
	    	list1 = new ArrayList<>();
	    	
		}
		for(int m=1;m<=Keys.size();m++){
			matrix[m][m]=0;
			matrix[m][0]=Keys.get(m-1);
			matrix[0][m]=Keys.get(m-1);
		}
		String str = "|\t";

        for(int i=0;i<1521;i++){
            for(int j=0;j<1521;j++){
                str += matrix[i][j] + "\t";
            }
            final String FILENAME = "protein.txt";
	            BufferedWriter bw = null;
	            FileWriter fw = null;
	            try{
	              fw = new FileWriter(FILENAME,true);
	        bw = new BufferedWriter(fw);
	           PrintWriter out = new PrintWriter(bw);
	           
	           out.print(str + "|");
	           
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
            str = "|\t";
        }

		 System.out.println();
	 }
	       
    
}
	
