
//EX 1///


#include<bits/stdc++.h> 
using namespace std ; 


void generateAllStringsUtil(int K, char str[], int n) 
{ 

	if (n == K) 
	{ 
		
		str[n] = '\0' ; 
		cout << str << " "; 
		return ; 
	} 

	
	if (str[n-1] == '1') 
	{ 
		str[n] = '0'; 
		generateAllStringsUtil (K , str , n+1); 
	} 


	if (str[n-1] == '0') 
	{ 
		str[n] = '0'; 
		generateAllStringsUtil(K, str, n+1); 
		str[n] = '1'; 
		generateAllStringsUtil(K, str, n+1) ; 
	} 
} 


void generateAllStrings(int K ) 
{ 
	// Base case 
	if (K <= 0) 
		return ; 

	char str[K]; 


	str[0] = '0' ; 
	generateAllStringsUtil ( K , str , 1 ) ; 


	str[0] = '1' ; 
	generateAllStringsUtil ( K , str , 1 ); 
} 


int main() 
{ 
	int K = 6; 
	generateAllStrings (K) ; 
	return 0; 
} 


// It does 53 calls
//For length 5 it is 13, for 6 it is 21 and for 7 it is 34
//The number of resulting strings of length n is the (n+2)’th Fibonacci number.

