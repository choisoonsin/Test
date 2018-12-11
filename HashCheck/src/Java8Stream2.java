import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Tester{
	
	String value;
	
	public Tester(String value) {
		// TODO Auto-generated constructor stub
		System.out.println(value);
		this.value = value;
	}
	
	public String upper(String value) {
		return value.toUpperCase();
	}
	
	public String merge(String value) {
		return value.toUpperCase();
	}
	
}

public class Java8Stream2 {

	static Collector<Person , StringJoiner , String> personNameCollector = 
			Collector.of( () -> new StringJoiner("|"), 				// supplier
					      (j,p) -> j.add(p.name.toUpperCase()), 	// accumulator
					      (j1,j2) -> j1.merge(j2), 					// combiner
					      result -> "["+result.toString()+"]");		// finisher
	
	public static void main(String[] args) {
		
		List<Person> pList = Arrays.asList(
				new Person("Kia" , 31) , new Person("Poll" , 31) , new Person("David" , 29) , new Person("Jacop" , 48) , 
				new Person("Kelly" , 36) , new Person("Ford" , 40) , new Person("Mark" , 25) , new Person("Mi" , 19)
		);
		
		List<Person> filtered = pList.stream()
									.filter( person -> person.name.startsWith("K"))
									.collect(Collectors.toList()); // or toSet()
		
		System.out.println(filtered.toString());
		
		System.out.println("=========================================================================");
		
		Map<Character , List<Person>> resultMap = pList.stream()
														.collect(Collectors.groupingBy( p1 -> new Character(p1.name.charAt(0))) );
		
		// Collectors.partitioningBy �� groupingBy ����. partitioningBy �� Predicate�� ���ڷ� �������ν� boolean ������ ó���Ͽ� ��Ƽ�Ŵ�.
		
		resultMap.forEach( (k,v) -> {
			System.out.println(k +":"+ v);
		});
		
		// Person�� �ƴ� Person.age �� list ���·� �ް� ������� collect() �Լ��� Ȱ���Ѵ�.
		pList.stream()
			.collect(
					 Collectors.groupingBy( p1 -> new Character( p1.name.charAt(0) ) 
					                        , Collectors.mapping( p1 -> p1.age , Collectors.toList())
					                      )
					)
			.forEach( (k,v) -> {
				System.out.println(k +":"+ v);
			});
		
		System.out.println("=========================================================================");
		
		
		// ��� ������� ���̴�� �׷���.
		Map<Integer , List<Person>> personsByAge = pList.stream()
														.collect(Collectors.groupingBy(p -> p.age));

		Map<Boolean , List<Person>> personsByOld = pList.stream()
														.collect(Collectors.groupingBy( p -> p.age > 30));
		
		personsByOld.forEach( (k,v) -> {
			System.out.println( k +":"+ v);
		});
		
		System.out.println(personsByAge.toString());
		
		pList.stream()
			.mapToInt(p -> p.age)
			.min() // min or max or average or count or sum
			.ifPresent(System.out::println);
		
		pList.stream()
			.mapToInt(p -> p.age)
			.summaryStatistics()
			.getAverage();
		
		// joining
		String phrase = pList.stream()
							.filter( p -> p.age > 30)
							.map( p -> p.name)
							.collect(Collectors.joining(":", "[", "]"));

		
		System.out.println("phrase="+phrase);
		
		System.out.println(pList.stream().collect(personNameCollector));		
	}

}

