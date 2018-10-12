///// ex 2////
public class ArrayPalindrome {
	public static boolean isPalindromeRecursive(char[] c) {
		return isPalindromeRecursive(c, 0, c.length - 1);
	}
	
	public static boolean isPalindromeNoneRecursive(char[] c) {
		int start = 0;
		int end   = c.length - 1;
		
		while(end > start) {
			if (c[start] != c[end]) return false;
			++start; --end;
		}
		
		return true;
	}
	
	private static boolean isPalindromeRecursive(char[] c, int start, int end) {
		if (c.length == 0 || c.length == 1) return true;
		
		if (start >= end) return true;
		
		if (c[start] != c[end])
			return false;
		
		return isPalindromeRecursive(c, start + 1, end - 1);
	}
	
	public static void main(String[] args) {
		char[] c = {'a', 'b', 'a', 'b', 'a'};
		System.out.println(isPalindromeRecursive(c));
		
		char[] c1 = {'a', 'b', 'c', 'r'};
		System.out.println(isPalindromeNoneRecursive(c1));
	}
}

