package strings;

/**
 * Created by vnalubandu on 7/22/18.
 */
public class MaxDistanceToPerson {

    public int maxDistToClosest(int[] seats) {
        int futureOccupancy = 0;
        int N = seats.length;
        int maxDis=0;
        int previousSeat=-1;
        for(int i=0;i<seats.length;++i){
            if(seats[i]==1){
                previousSeat=i;
            }else {
                while(futureOccupancy<N && seats[futureOccupancy]==0 || futureOccupancy<i){
                    futureOccupancy++;
                }

                int leftSeat = previousSeat==-1? N: i-previousSeat;
                int rightSeat = futureOccupancy==N? N: futureOccupancy-i;
                maxDis = Math.max(maxDis,Math.min(leftSeat,rightSeat));
            }
        }
        return maxDis;
    }

    public static void  main(String[] args){
        int[] seats = new int[]{1,0,0,0,1,0,1};
        MaxDistanceToPerson mxd = new MaxDistanceToPerson();
        int maxDis = mxd.maxDistToClosest(seats);
        System.out.println("Max Distance from person " +maxDis);
        int[] seats1 = new int[]{1,0,0,0,1,0,0,0,0,0,0,0,0,1};
        System.out.println("Max Distance from person " +mxd.maxDistToClosest(seats1));

    }
}
