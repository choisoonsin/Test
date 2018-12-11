import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Stream3_flatMap {
	
	public static void main(String[] args) {
		
		List<Foo> foos = new ArrayList<>();
		
		//create foos
		IntStream.range(1, 4)
				.forEach( i -> foos.add(new Foo("Foo"+i)));
		
		foos.forEach( f -> {
			IntStream.range(1, 4)
					.forEach( i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name)));
		});
		
		foos.stream()
			.flatMap(f -> {
				System.out.println("f:"+f.name);
				return f.bars.stream();
			})
			.forEach(b -> {
				System.out.println(b.name);
			});
		
		IntStream.range(1, 4)
				.mapToObj(i -> {
					System.out.println(i);
					return new Foo("foo"+i);
				})
				.peek(f -> IntStream.range(1, 4)
								.mapToObj(i -> new Bar("2Bar" + i + " <- " + f.name))
								.forEach(f.bars::add)
				)
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));
		
		Foo f = new Foo("Team Kock");
		Foo f2 = null;
		
		Optional.ofNullable(f).ifPresent(System.out::println);
		Optional.ofNullable(f2).ifPresent(System.out::println);
		
		Integer[] l = {1,2,3,4,5};
		
		Stream.of(l)
			.map(s -> s*s)
			.forEach(TestMath::outPi);
		
	}

}

class TestMath{
	final static double PI = 3.14;
	
	static void outPi(Integer val) {
		System.out.println("val:"+val);
	}
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

