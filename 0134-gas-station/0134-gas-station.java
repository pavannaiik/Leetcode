class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank =0, currentTank=0, startingPoint=0;
        for(int i=0;i<gas.length;i++){
            totalTank += gas[i]-cost[i];
            currentTank += gas[i]-cost[i];
            if(currentTank < 0){
                startingPoint=i+1;
                currentTank=0;
            }
        }return totalTank >= 0 ? startingPoint:-1;
    }
}