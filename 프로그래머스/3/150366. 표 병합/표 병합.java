import java.util.*;

class Solution {
    static int[] parent;
    static String[] values;
    static int n = 50;
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX; 
            if (values[rootX].equals("")) { 
                values[rootX] = values[rootY];
            }
        }
    }

    static void unmerge(int x) {
        int root = find(x);
        String value = values[root];
        List<Integer> toUnmerge = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            if (find(i) == root) {
                toUnmerge.add(i);
            }
        }
        for (int i : toUnmerge) {
            parent[i] = i;
            values[i] = "";
        }
        values[x] = value;
    }

    public String[] solution(String[] commands) {
        parent = new int[n * n];
        values = new String[n * n];
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            values[i] = "";
        }

        List<String> ans = new ArrayList<>();
        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String cmd = st.nextToken();

            if (cmd.equals("UPDATE")) {
                if (st.countTokens() == 3) {
                    int r = Integer.parseInt(st.nextToken()) - 1;
                    int c = Integer.parseInt(st.nextToken()) - 1;
                    String value = st.nextToken();
                    
                    int idx = r * n + c;
                    
                    values[find(idx)] = value;
                } else {
                    String value1 = st.nextToken();
                    String value2 = st.nextToken();
                    
                    for (int i = 0; i < n * n; i++) {
                        if (values[i].equals(value1)) {
                            values[i] = value2;
                        }
                    }
                }
            } else if (cmd.equals("MERGE")) {
                int r1 = Integer.parseInt(st.nextToken()) - 1;
                int c1 = Integer.parseInt(st.nextToken()) - 1;
                int r2 = Integer.parseInt(st.nextToken()) - 1;
                int c2 = Integer.parseInt(st.nextToken()) - 1;
                
                int idx1 = r1 * n + c1;
                int idx2 = r2 * n + c2;
                
                if (find(idx1) != find(idx2)) {
                    union(idx1, idx2);
                }
            } else if (cmd.equals("UNMERGE")) {
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int idx = r * n + c;
                
                unmerge(idx);
            } else if (cmd.equals("PRINT")) {
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int idx = r * n + c;
                
                String result = values[find(idx)];
                ans.add(result.equals("") ? "EMPTY" : result);
            }
        }
        return ans.toArray(new String[0]);
    }
}
