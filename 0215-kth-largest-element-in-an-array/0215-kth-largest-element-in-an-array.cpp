class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>,greater<int>>pq;
        for(int n:nums){
            if(pq.size()>=k &&  n>pq.top()) pq.pop();
            if(pq.size()<k)
            pq.push(n);
        }
        return pq.top();
    }
};