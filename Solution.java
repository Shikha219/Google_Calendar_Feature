import java.util.Arrays; 
import java.util.PriorityQueue;
class Solution {

    public static int minMeetingRooms(int[][] meetingTimes){
        
        if(meetingTimes.length == 0){
            return 0;
        }

        Arrays.sort(meetingTimes, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((A, B) -> A - B);
        
        minHeap.add(meetingTimes[0][1]);
        
        for (int i = 1; i < meetingTimes.length; i++) {
            int currStart = meetingTimes[i][0];
            int currEnding = meetingTimes[i][1];
            int earliestEnding = minHeap.peek();
            
            if (earliestEnding <= currStart) {
                minHeap.remove();
            } 
            minHeap.add(currEnding);
        }
        return minHeap.size();
    }
    // Driver code
    public static void main( String args[] ) {
        
        int[][] meetingTimes = {{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}};
        System.out.print(minMeetingRooms(meetingTimes));
    }
}
