import java.util.*;
import java.io.*;

/*
 * 3 초	256 MB
 * 
 * [입력]
 * 1> 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
 * N> 각 회원의 나이(1보다 크거나 같으며, 200보다 작거나 같은 정수)와 이름(알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열)
 * => 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력
 * 
 */

public class Main{
	static int N;
	static List<Member> members;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		members = new ArrayList<>();
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members.add(new Member(age, name, n));
		}
		
		Collections.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age == o2.age) {
					return o1.order - o2.order;
				}
				return o1.age - o2.age;
			}

		});
		
		StringBuilder sb = new StringBuilder();
		for(Member m : members) {
			sb.append(m).append("\n");
		}
		System.out.print(sb);
	}
}

class Member{
	int age, order;
	String name;
	
	public Member(int age, String name, int order) {
		this.age = age;
		this.name = name;
		this.order = order;
	}
	
	public String toString() {
		return age+" "+name;
	}
}