import java.io.*;
import java.util.*;

public class Main {
    static String[] str;
    static double totalSum=0, scoreSum=0, score, average;
    static String subject, grade;
    static Map<String, Double> scoreMap;
    
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        str = new String[20];
        scoreMap = new HashMap<>();
        scoreMap.put("A+", 4.5);
        scoreMap.put("A0", 4.0);
        scoreMap.put("B+", 3.5);
        scoreMap.put("B0", 3.0);
        scoreMap.put("C+", 2.5);
        scoreMap.put("C0", 2.0);
        scoreMap.put("D+", 1.5);
        scoreMap.put("D0", 1.0);
        scoreMap.put("F", 0.0);
        scoreMap.put("P", 0.0);
        
        for (int i = 0; i < 20; i++) {
            str[i] = bfr.readLine();
            StringTokenizer st = new StringTokenizer(str[i]);
            subject = st.nextToken();
            score = Double.parseDouble(st.nextToken());
            grade = st.nextToken();
            if(!grade.equals("P")) {
                totalSum += score * scoreMap.get(grade);
                scoreSum += score;
            }
        }
        average = totalSum / scoreSum;
        System.out.printf("%.6f\n", average);
    }
}