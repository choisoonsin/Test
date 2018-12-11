import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Java8Stream5_Parallel {
	
	public static void main(String[] args) {
		
		
		
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		
		System.out.println(commonPool.getParallelism());
		
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
		    .parallelStream()
		    .filter(s -> {
		        System.out.format("filter: %s [%s]\n",
		            s, Thread.currentThread().getName());
		        return true;
		    })
		    .map(s -> {
		        System.out.format("map: %s [%s]\n",
		            s, Thread.currentThread().getName());
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.format("forEach: %s [%s]\n",
		        s, Thread.currentThread().getName()));
		
	}

}

