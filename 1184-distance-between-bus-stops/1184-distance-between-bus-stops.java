class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int total = 0;
        int path = 0;

        if(start>destination){
            int temp = start;
            start = destination;
            destination = temp;
        }

        for(int i=0;i<n;i++){
            total+=distance[i];

            if(i>=start && destination > i){
                path+=distance[i];
            }
        }

        return Math.min(path,total-path);

    }
}