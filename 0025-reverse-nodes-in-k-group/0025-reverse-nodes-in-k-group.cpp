/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        int len=0;
        ListNode* t=head;
        while(t!=NULL){
            len++;
            t=t->next;
        }
        ListNode* res= new ListNode(0);
        res->next=head;
        ListNode* prev;
        ListNode* cur=res;
        ListNode* nex=res;
        while(len>=k){
            cur=prev->next;
            nex=cur->next;
            for(int i=1;i<k;i++){
                cur->next=nex->next;
                nex->next=prev->next;
                prev->next=nex;
                nex=cur->next;
            }
            prev=cur;
            len-=k;
        }
        return res->next;
    }
};