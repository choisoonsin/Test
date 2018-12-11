import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HashChecker {
     
    public static void main(String[] args) throws Exception {
    	
    	Date d1 = new Date();
    	
    	Thread.sleep(4000);
    	
    	Date d2 = new Date();
    	
    	DateFormat df = new SimpleDateFormat("HH:mm:ss");
    	df.setTimeZone(TimeZone.getTimeZone("UTC"));
//    	System.out.println(d2-d1);
    	System.out.println("Time is : "+df.format(d2.getTime()-d1.getTime()));
    	
    }  
    
}
