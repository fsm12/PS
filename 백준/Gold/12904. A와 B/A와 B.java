import java.util.*;
import java.io.*;

/*
 * 2 초	512 MB
 * 
 * [입력]
 * 1> S (1 ≤ S의 길이 ≤ 999)
 * 1> T (2 ≤ T의 길이 ≤ 1000, S의 길이 < T의 길이)
 * => S를 T로 바꿀 수 있으면 1을 없으면 0을 출력
 * 
 * S와 T가 주어졌을 때, S를 T로 바꾸는 게임
 * 1. 문자열의 뒤에 A를 추가
 * 2. 문자열을 뒤집고 뒤에 B를 추가
 * 
 * sol)
 * 집합을 이용해서 연산한 값들을 저장, T의 길이보다 큰 문자열 생성시 리턴
 * 불가능
 * 
 * sol) 반대로 진행
 * T를 S로 만들어보며 가능/불가능을 따져도 됨
 * 마지막 글자가 A라면 1번을 수행한 것이므로 A를 삭제
 * 마지막 글자가 B라면 2번을 수행한 것이므로 B를 삭제 및 뒤집기
 */

public class Main{
	static StringBuilder S,T;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = new StringBuilder(br.readLine());
		T = new StringBuilder(br.readLine());
		
		while(S.length() < T.length()) {
			char c = T.charAt(T.length()-1);
			if(c == 'A') {
				T.deleteCharAt(T.length()-1);
			}else {
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		System.out.println(S.toString().equals(T.toString())?1:0);
	}
}