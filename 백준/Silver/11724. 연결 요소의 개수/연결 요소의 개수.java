import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int answer;
    static boolean[] visited;
    static List<Integer>[] graph;
    static void bfs(int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for( i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new boolean[N+1];
       graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            graph[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
            graph[Integer.parseInt(str[1])].add(Integer.parseInt(str[0]));
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i])
            {
                visited[i] = true;
                bfs(i);
                answer++;
            }

        }
        System.out.println(answer);


    }
}