package com.yz.leetcode;

import com.yz.leetcode.T023MergekSortedLists.ListNode;

/**
 * 
 * 
 * 
Given a linked list, 
reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.


 * 
 * 
 * 
 * @author yangzhen
 *
 */
public class T025ReverseNodesikGroup {
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	  
	   public ListNode reverseKGroup(ListNode head, int k) {
	    	ListNode result = null;
	    	ListNode outHead = new ListNode(-1),tmpHead;
	    	outHead.next = head;
	    	boolean mycheck = check(  outHead,  k);
	    	tmpHead = outHead;
	    	while( mycheck){
	    		tmpHead = reverseSub(tmpHead,   k);
	    		mycheck = check(  tmpHead,  k);
	    		print(outHead);
	    	}
	        
	    	
	    	return result;
	    }
	   
	    private boolean check(ListNode outHead, int k){    	
	    	int i=0;
	    	ListNode p=outHead;
	    	while(i<k && p!=null){
	    		p=p.next;
	    		i++;
	    	}
	    	
	    	return i>=k;
	    }
	    
	    /**
	     * 
	     * @return the tail
	     */
	    private ListNode reverseSub(ListNode head, int k){
	    	ListNode myHead = head.next,myTail = null;
	    	ListNode outHead = head,outTail = null;
	    	ListNode p1 = null,p2 = myHead,next=myHead.next;
	    	int i=1;
	    	while( i<k){
	    		
	    		p1=p2;
	    		p2=next;
	    		next = p2.next;
	    		
	    		p2.next=p1;    		 
	    		
	    		i++;
	    		
	    	}
	    	outTail = next;
	    	myTail = p1;
	    	outHead.next.next = outTail;
	    	outHead.next = myTail;
	    	return myTail;
	    }
	    

	    private ListNode create(int [] arr ) {
	    	ListNode head = null;  
	    	ListNode tmp = null;
	    	for(int i=0; i< arr.length; i++) {
	    		
	    		if(i==0) {
	    			tmp = new ListNode(arr[i]);
	    			head = tmp;
	    		}
	    		else {
	    			tmp.next = new ListNode(arr[i]);
	    			tmp=tmp.next;
	    		}
	    	}
	    	 
	    	
	    	return head;
	    }
	    
	    private void print(ListNode list) {
	    	while(list != null) {
	    		System.out.print(list.val +" ->");
	    		list = list.next;
	    	}
	    	System.out.println("");
	    	
	    }
	    
	    private void test01() {
	    	int [] t1 = new int [] {1,2,3,4,5,6};
	    	ListNode t1head = create(t1 );
	    	print(reverseKGroup(t1head, 2));
	    	
	    	
	    }


	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T025ReverseNodesikGroup().test01();

	}

}
