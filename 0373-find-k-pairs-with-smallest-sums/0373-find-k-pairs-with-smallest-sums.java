class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        List<List<Integer>>result=new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k<=0) return result;
        for(int i=0;i<Math.min(k,nums1.length);i++){
            minHeap.add(new int[]{nums1[i]+nums2[0], i, 0});
        }
        while( k-- > 0 && !minHeap.isEmpty()){
            int[] current=minHeap.poll();
            int i = current[1];
            int j= current[2];
            result.add(List.of(nums1[i], nums2[j]));
            if(j+1 < nums2.length){
                minHeap.add(new int[]{nums1[i]+nums2[j+1], i, j+1});
            }
        }
        return result;
    }
}