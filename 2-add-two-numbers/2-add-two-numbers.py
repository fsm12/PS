# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        total="";totalA="";totalB=""
        while l1:
            totalA += str(l1.val)
            l1=l1.next
        while l2:
            totalB += str(l2.val)
            l2=l2.next
        total=str(int(totalA[::-1])+int(totalB[::-1]))
        head = ListNode(total[-1])
        cur_node = head
        for i,n in enumerate(total[-2::-1]):
            new_node=ListNode(n)
            cur_node.next = new_node
            cur_node = cur_node.next
        return head
