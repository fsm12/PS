import java.util.*;
import java.io.*;

/* 5시 20분까지
 * 
 * 2 초	512 MB
 * 
 * [입력]
 * 1> S (1 ≤ S의 길이 ≤ 49)
 * 1> T (2 ≤ T의 길이 ≤ 50)	(S의 길이 < T의 길이)
 * => S를 T로 바꿀 수 있으면 1을 없으면 0을 출력
 * 
 * < 가능 연산 >
 * 문자열의 뒤에 A를 추가 => __ + A
 * 뒤에 B를 추가하고 문자열을 뒤집는다 => __+B => B+__
 * 
 * sol) 완탐
 * 위의 가능연산을 진행하면서 만들어지면 break;
 * 2^49 => 불가능
 * 
 * sol) 그리디
 * S에서 T를 만들지 말고 T에서 S를 이끌어내자
 * 마지막 글자가 A라면 A 삭제
 * 첫 글자가 B라면 B빼고 뒤집기
 */

public class Main {
    static StringBuffer S, T;
    static boolean flag;
 
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S = new StringBuffer(br.readLine());
        T = new StringBuffer(br.readLine());
        
        dfs(S, T);
        System.out.println(flag?1:0);
    }
 
    public static void dfs(StringBuffer S, StringBuffer T) {
    	if(flag)
    		return;
    	
        if (S.length() == T.length()) {
            if (S.toString().equals(T.toString())) {
                flag = true;
            }
            return;
        }
        
        StringBuffer T_copy = new StringBuffer(T.toString());
        if (T.charAt(0) == 'B') {
        	T_copy.deleteCharAt(0);
        	T_copy.reverse();
            dfs(S, T_copy);
        }
 
        if (T.charAt(T.length() - 1) == 'A') {
        	T.deleteCharAt(T.length()-1);
            dfs(S, T);
        }
    }
}