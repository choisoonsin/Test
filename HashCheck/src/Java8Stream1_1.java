import java.util.Arrays;
import java.util.List;

public class Java8Stream1_1 {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		List<String> array = Arrays.asList("1" , "c5" , "a" , "a2" , "a3" , "c1" , "c2" , "c3");
		
		List<Person> pList = Arrays.asList(new Person("Kia" , 31) , new Person("Pord" , 31) , new Person("David" , 29) , new Person("Jacop" , 48));
		
		pList.removeIf((Person s) -> s.age > 30);
		
	}

}

