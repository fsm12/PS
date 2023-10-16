import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String inp = br.readLine();
			if(inp == null)
				break;
			sb.append(inp).append("\n");
		}
		System.out.println(sb.toString());
	}
}