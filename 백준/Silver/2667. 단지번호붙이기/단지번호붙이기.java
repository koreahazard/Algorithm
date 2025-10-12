import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class Main {
    

public static void main(String[] args) throws Exception  {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine())
            ;
    int[][] matrix =  new int[size][size];
    boolean[][] visited = new boolean[size][size];
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
                String string = br.readLine();
        for (int j = 0; j < size; j++) {
            matrix[i][j] = Integer.parseInt(string.split("")[j]);
        }
    }

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if(matrix[i][j] == 1 && !visited[i][j]) {
                bfs(visited,matrix,i,j,size,result);
            }
        }
    }
    result.sort(Integer::compareTo);
    System.out.println(result.size());
    for (Integer integer : result) {
        System.out.println(integer);
    }


}
static void bfs(boolean[][] visited,int[][] matrix,int i,int j,int size,ArrayList<Integer> result)
{
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int count = 0;
    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(i,j));
    visited[i][j] = true;
    Point point = null;
    while(!queue.isEmpty()){
        point = queue.poll();
        count++;
        for(int k = 0; k < 4; k++){
            int x = point.x + dx[k];
            int y = point.y + dy[k];
            if(x >= 0 && x < size && y >= 0 && y < size && visited[x][y] == false && matrix[x][y] == 1){
                queue.offer(new Point(x,y));
                visited[x][y] = true;
            }
        }
    }
    result.add(count);






//    ArrayDeque<int[]> ue2 = new ArrayDeque<>();
//    queue2.offer(new int[]{i, j});
//    int[] c = queue2.poll();
//    visited[i][j] = true;

}
}