// Ex 1

public class BinaryStrings {
	public static void printWithout(int n) {
		printWithout(n, "", 0);
	}
	
	private static void printWithout(int n, String result, int lastDigit) {
		System.out.println("Hey");
		if (n == 0) {
			return;
		}
		
		printWithout(n - 1, result + "0", 0);
		
		if (lastDigit == 0) {
			printWithout(n - 1, result + "1", 1);
		}
	}
	
	
	public static void main(String[] args) {
		int n = 5;
		printWithout(n);
	}
}


