import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8Stream {

//	public static void asTest(String... args) {
//		Stream.of(args).forEach(System.out::println);
//	}
	
	public static<T> void asTest(T... args) {
		Stream.of(args).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		List<String> array = Arrays.asList("1" , "c5" , "a" , "a2" , "a3" , "c1" , "c2" , "c3");
		
		List<Person> pList = Arrays.asList(new Person("Kia" , 31) , new Person("Pord" , 31) , new Person("David" , 29) , new Person("Jacop" , 48));
		
		pList.stream()
			.findFirst()
			.ifPresent(System.out::println);
		
		pList.stream()
			.map( s -> s.name.toUpperCase())
			.forEach(System.out::println);
		
		long count = pList.stream()
			.map( s -> s.age)
			.distinct().count();
		
		pList.stream()
			.mapToInt( s -> s.age)
			.average() // or sum
			.ifPresent(System.out::println);
		
		System.out.println("count:"+count);
		
		array.stream()
			.filter( s -> {
				System.out.println("filter:"+s);
				return true;
			})
			.forEach( s -> {
				System.out.println("forEach:"+s);
			});
		
/*		array.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
		
		Stream.of("1" , "2" , "3")
			.findFirst()
			.ifPresent(s -> System.out.println(s));
		
		asTest("T" , "E" , "S" , 2 , new String("1") , 3L);
		
*/		
		String[] strings = {"1" , "2"};
		
		pList.stream()
			.filter(s -> s.age > 30)
			.forEach(System.out::println);
		
		List<Person> filtered = pList.stream()
				.filter( person -> person.name.startsWith("K"))
				.collect(toList()); // or toSet()
		
		filtered.forEach(System.out::println);
		
		System.out.println("======================================================================");
		
		Stream<Object> objects = Stream.of("a string" , 42 , new String[] {"an array"} , "another string");
		
		objects.filter(s -> {
//			System.out.println(s);
			if(s instanceof String) {
				System.out.println("String = "+s);
				return true;
			}else if(s instanceof Integer) {
				System.out.println("Integer = "+s);
				return false;
			}else if(s instanceof String[]){
				System.out.println("String[] = "+s);
				return false;
			}else{
				System.out.println("else = "+s);
				return false;
			}
		}).collect(toList()).forEach(s -> {
			System.out.println("result:"+s);
		});
		
		System.out.println("======================================================================");
		
		Stream<Object> objects2 = Stream.of("a string" , 42 , new String[] {"an array"} , "another string");
		
		objects2.filter(String.class::isInstance)
				.map(String.class::cast)
				.collect(toList()).forEach(System.out::println);
		
		System.out.println("======================================================================");
		
		M m = new M();
		H h = new H();
		System.out.println(m.equals(h));
		System.out.println(m.getClass().equals(h.getClass()));
			
		System.out.println("Classloader of ArrayList:"
		        + ArrayList.class.getClassLoader());
		
		System.out.println("Classloader of Java8Stream2:"
		        + Java8Stream2.class.getClassLoader());
	}

}
class S{

}

class M extends S{
	
}

class H extends S{
	
}

