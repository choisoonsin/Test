package test.methodref;

public class MainTest {

	public static void main(String[] args) {
		
		String _s = "add new variable";
		
		String s = "Test";
		
		// SomeClass::staticMethod
		String result1 = Utils.transform(s, Utils::makeExciting);
		System.out.println(result1);
		
		// someObject::instanceMethod
		String prefix = "Blah";
		String result2 = Utils.transform(s, prefix::concat);
		System.out.println(result2);
		
		// someClass::instanceMethod
		String result3 = Utils.transform(s, String::toUpperCase);
		System.out.println(result3);
	}

}
