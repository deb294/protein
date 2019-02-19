
import java.io.File;
public class c2 {

    public static void main(String[] args) {
        final File dir=new File("/home/swamp2/cacsgrad/dxb3610/Desktop/alpha/1");
        int size=35;
        String [] myArray=new String[size];

        File [] files=dir.listFiles();

        //create array with random file selection
        for(int i=0;i<size;i++){
            int idx = (int)(Math.random()*size);
            myArray[i]=files[idx].getName();
        }

        //show random file name selection
        for(String x: myArray)
            System.out.println(x);


    }

}
