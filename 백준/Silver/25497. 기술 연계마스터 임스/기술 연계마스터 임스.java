import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static int cnt, cntL, cntS;
    static boolean chk = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        s = br.readLine();
        cnt = 0;
        cntL = 0;
        cntS = 0;
        
        for (int i = 0; chk && i < s.length(); i++) {
            chk = true;
            switch (s.charAt(i)) {
                case 'L': 
                    cntL++; 
                    break;
                case 'S': 
                    cntS++; 
                    break;
                case 'R': 
                    if(cntL==0) 
                        chk=false;
                    else {
                        cnt++; 
                        cntL--;
                    } 
                    break;
                case 'K': 
                    if(cntS==0) 
                        chk=false;
                    else {
                        cnt++;
                        cntS--;
                    } 
                    break;
                default: 
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}