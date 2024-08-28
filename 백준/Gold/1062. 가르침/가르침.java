import java.util.*;
import java.io.*;

/*
 * 1) for문으로 배열로 입력받기, dfs 호출, depth 대신 ck, countWords() 메소드 분리
 */

public class Main{
    static int N, K;
    static boolean[] vis;
    static String[] words;
    static int max = 0;
    static int ck = 5;
    
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        vis = new boolean[26];

        if(K < 5) {
            System.out.println(0);
        }else if(K == 26) {
			System.out.println(N);
			return;
		} else {
            vis['a' - 'a'] = true;
            vis['n' - 'a'] = true;
            vis['t' - 'a'] = true;
            vis['i' - 'a'] = true;
            vis['c' - 'a'] = true;
            
            for (int i=0; i<N; i++) {
                words[i] = br.readLine().replaceAll("[antic]", "");
            }
            
            max = countWords();
            for (int i=0; i<26; i++) {
                if(!vis[i]) {
                    dfs(i);
                }
            }
            System.out.println(max);
        }
    }

    static void dfs(int index) {
        //1.체크인 : 사용중
        vis[index] = true;
        ck++; 

        //2.목적지인가 : K개만큼 배웠는가
        if(ck == K) {
            // 몇개의 글자를 배울 수 있는지 계산해야함
            max = Math.max(max, countWords());
        } else {
            //3.연결된 곳을 순회
            for (int i=index+1; i<=25; i++) {
                //4.갈 수 있는가 : 방문한 적 없는가
                if(vis[i] == false) {
                    //5.간다
                    dfs(i);
                }
            }
        }
        //6.체크아웃
        vis[index] = false;
        ck--;
    }
    
    static int countWords() {
        int count = 0;
        for (int n=0; n<N; n++) {
            boolean isPossible = true;
            String word = words[n];
            for (int i=0; i<word.length(); i++) {
                if(vis[word.charAt(i) - 'a'] == false) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                count++;
            }
        }
        return count;
    }
}