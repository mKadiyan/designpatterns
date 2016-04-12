package algorithm.prob;

import java.util.Scanner;


class TestClass {
    public static void main(String args[] ) throws Exception {
        
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
        	
        	int count = sc.nextInt();
        	int numO = sc.nextInt();
        	int numZ = sc.nextInt();
        	int num = 0;
        	for(int j=0;j<count;j++)
        	{
        		String s = sc.next();
        		int tempO = charCount(s, 'O');
        		int tempZ = charCount(s, 'Z');
        		if(numO - tempO >=0 && numZ - tempZ >=0)
        		{
        			numO = numO - tempO;
        			numZ = numZ - tempZ;
        			num++;
        		}
        	}
        	System.out.println(num);
        	
        	
        }
        
    }
    
    private static int charCount(String s, char c)
    {
    	int counter = 0;
    	for( int i=0; i<s.length(); i++ ) {
    	    if( s.charAt(i) == c ) {
    	        counter++;
    	    } 
    	}
    	return counter;
    	
    }
    
}