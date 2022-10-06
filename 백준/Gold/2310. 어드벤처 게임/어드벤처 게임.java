import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Room[] rooms;
    static LinkedList<Integer>[] adjList;
    static boolean[] vis;
    static boolean flag;
    static int money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            
            adjList = new LinkedList[N+1];
            rooms = new Room[N+1];
            vis = new boolean[N+1];

            money = 0;
            flag = false;

            for(int i=1; i<=N; i++) {
                adjList[i] = new LinkedList<Integer>();
            }

            for(int n=1;n<=N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char npc = st.nextToken().charAt(0);
                int cost = Integer.parseInt(st.nextToken());

                rooms[n] = new Room(npc, cost);
                while(true) {
                    int num =  Integer.parseInt(st.nextToken());
                    if(num == 0) {
                        break;
                    }
                    if(num == n) {
                        continue;
                    }
                    adjList[n].add(num);
                }
            }
            dfs(1);
            System.out.println(flag?"Yes":"No");
        }
    }

    static void dfs(int roomIdx) {
        if(rooms[roomIdx].npc == 'T') {
            if(rooms[roomIdx].cost <= money) {
                money -= rooms[roomIdx].cost;
            }else {
                return;
            }
        }
        if(roomIdx == N) {
            flag = true;
            return;
        }

        if(rooms[roomIdx].npc == 'L') {
            if(rooms[roomIdx].cost > money) {
                money = rooms[roomIdx].cost;
            }
        }

        vis[roomIdx] = true;
        for(int n : adjList[roomIdx]) {
            if(!vis[n]) {
                dfs(n);
            }
        }
        vis[roomIdx] = false;

    }
    static class Room{
        char npc;
        int cost;

        public Room(char npc, int cost) {
            this.npc = npc;
            this.cost = cost;
        }
    }
}