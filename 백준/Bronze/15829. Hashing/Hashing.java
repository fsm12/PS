import java.io.*;

public class Main {
    static int L;
    static String S;
    static long result=0, pow=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		S = br.readLine();
		for(int i = 0; i < L; i++) {
			result += ((S.charAt(i) - 96) * pow);
			pow = (pow * 31) % 1234567891;
		}
		System.out.println(result % 1234567891);
	}
}