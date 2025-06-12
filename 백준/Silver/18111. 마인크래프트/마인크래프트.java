import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class LandFlatten {
    int timeCost = 0;
    int myInven = 0;

    public LandFlatten(int[][] myLand, int Inven, int heightCase) {
        myInven = Inven;
        for(int i = 0; i < myLand.length; i++) {
            for(int j = 0; j < myLand[i].length; j++) {
                if(heightCase - myLand[i][j] > 0) {
                    timeCost += (heightCase - myLand[i][j]);
                    myInven -= (heightCase - myLand[i][j]);
                }
                else if(heightCase - myLand[i][j] < 0) {
                    myInven += ( myLand[i][j] - heightCase );
                    timeCost += (myLand[i][j]-heightCase)*2;
                }
            }
        }
        if(myInven < 0) {
            timeCost = Integer.MAX_VALUE;
        }


    }
}
public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int row = Integer.parseInt(firstLine[0]);
        int column = Integer.parseInt(firstLine[1]);
        int myInven = Integer.parseInt(firstLine[2]);
        int bestHeight = -1;
        int bestTime = -1;
        int minHeight = 256;
        int maxHeight = 0;

        int[][] myLand = new int[row][column];
        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                myLand[i][j] = Integer.parseInt(line[j]);
                if (myLand[i][j] < minHeight) {
                    minHeight = myLand[i][j];
                }
                if (myLand[i][j] > maxHeight) {
                    maxHeight = myLand[i][j];
                }
            }
        }

        for (int heightCase = 0; heightCase <= maxHeight; heightCase++) {
            LandFlatten landFlattenCase = new LandFlatten(myLand, myInven, heightCase);
            if (bestTime == -1 || landFlattenCase.timeCost < bestTime) {
                bestTime = landFlattenCase.timeCost;
                bestHeight = heightCase;
            } else if (landFlattenCase.timeCost == bestTime && heightCase > bestHeight) {
                bestHeight = heightCase;
            }
        }
        System.out.println(bestTime+" "+bestHeight);




    }



}
