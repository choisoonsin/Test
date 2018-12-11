import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8Stream4_Reduce {
	
	public static void main(String[] args) {
		
		List<Person> pList = Arrays.asList(new Person("Kia" , 48) , new Person("Pord" , 31) , new Person("David" , 29) , new Person("Jacop" , 48));
		
		pList.forEach(s -> System.out.println(s.age));
		
		pList.stream()
			.reduce( (p1 , p2) -> p1.age > p2.age ? p1 : p2)
			.ifPresent(System.out::println);
		
		// pList 가 update 된다. 아래 reduce 인자 두개에서 첫번째 리턴값이 될 데이터형을 선언해야만 가능.
//		Optional<Person> r = pList.stream()
//			.reduce( (p1 , p2) -> {
//				p1.age += p2.age;
//				p1.name += p2.name;
//				return p1;
//			});
		
		Person p = pList.stream()
				.reduce(new Person("" , 0), (pp1 , pp2) -> {
					pp1.age += pp2.age;
					pp1.name += pp2.name;
					return pp1;
				});
		
		
		pList.forEach(s -> System.out.println(s.age));
		
//		Person optionalP = r.get();
		
//		System.out.format("name=%s , age=%s" , optionalP.name , optionalP.age);
		System.out.format("name=%s , age=%s" , p.name , p.age);
		System.out.println();
		
		Integer p1 = pList.stream()
						.reduce(0,(sum,p2) -> sum += p2.age , (sum1 , sum2) -> sum1 + sum2);
		
		System.out.println(p1);
		
		Integer ageSum = pList
//			    .stream()
				.parallelStream()
			    .reduce(0,
			        (sum, ps) -> {
			            System.out.format("accumulator: sum=%s; person=%s\n", sum, ps);
			            return sum += ps.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			            return sum1 + sum2;
			        });
						
		System.out.println("ageSum:"+ageSum);
	}

}

