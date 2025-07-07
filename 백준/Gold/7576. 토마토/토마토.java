import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static boolean spreadHappened;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int row = Integer.parseInt(firstLine[1]);
        int col = Integer.parseInt(firstLine[0]);
        int costDay = 0 ;
        List<Point> pointList = new ArrayList<>();
        int[][] matrix = new int[row][col];
        boolean[][] ripened = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
                if(matrix[i][j] == 1) {
                    pointList.add(new Point(i, j));
                }
            }
        }
        ArrayDeque<Point> queue = new ArrayDeque<>();
        for(int i =0; i < pointList.size(); i++) {
            ripened[pointList.get(i).row][pointList.get(i).col] = true;
            queue.add(pointList.get(i));
        }

        while(!queue.isEmpty()) {
            int size =queue.size();
            for(int i = 0; i < size; i++) {
            Point tomato = queue.poll();
            spread(tomato,queue,ripened,matrix,row,col);
            }
//            printMatrix(matrix);
//            System.out.println("-------------");
            if(spreadHappened) {
                costDay++;
                spreadHappened = false;
            }
        }
        for(int i =0; i < row; i++) {
            for(int j =0; j < col; j++) {
                if(matrix[i][j]==0) {
                    costDay = -1;
                }
            }
        }
        System.out.println(costDay);


    }
    static void spread(Point tomato,ArrayDeque<Point> queue,boolean[][] ripened,int[][] matrix,int row,int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int tomatoRow = tomato.row + dx[i];
            int tomatoCol = tomato.col + dy[i];
            if (tomatoRow >= 0 && tomatoRow < row && tomatoCol >= 0 && tomatoCol < col) {
                if (!ripened[tomatoRow][tomatoCol] && matrix[tomatoRow][tomatoCol] != -1) {
                    spreadHappened =true;
                    queue.add(new Point(tomatoRow, tomatoCol));
                    ripened[tomatoRow][tomatoCol] = true;
                    matrix[tomatoRow][tomatoCol] = 1;
                }

            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}




