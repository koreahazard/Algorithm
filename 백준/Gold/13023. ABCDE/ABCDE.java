import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean[] visited;
    static boolean found = false;
    static ArrayList<Integer>[] adj;
    static int n;
    static int m;
    static void dfs(int node,int depth) {
        if (found) return;
        if (depth == 4) {
            found = true;
            return;
        }
        visited[node] = true;
        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[node] = false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            adj[a].add(b);
            adj[b].add(a);
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i,0);
            if (found) break;
        }
        System.out.println(found ? 1 : 0);


    }
}

