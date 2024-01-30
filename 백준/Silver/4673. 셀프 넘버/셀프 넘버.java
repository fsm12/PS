import java.io.*;
import java.util.*;

public class Main {
	static boolean[] selfNums;

    public static void main(String[] args) throws Exception {
    	selfNums = new boolean[100001];
    	for(int i=1; i<=10000; i++) {
    		int a = i;
    		a+=splitSum(a);
    		selfNums[a] = true;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=1; i<=10000; i++) {
    		if(!selfNums[i]) {
    			sb.append(i).append("\n");
    		}
    	}
    	System.out.print(sb.toString());
    }
    
    public static int splitSum(int num) {
    	if(num/10==0) {
    		return num;
    	}
    	return num%10 + splitSum(num/10);
    }
}