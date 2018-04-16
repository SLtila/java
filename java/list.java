import java.io.*;
class Node{
    Node next=null;
    int data;
    public Node(int data){
        this.data=data;
    }
}
class MyLinkedList{
    Node head = null;
    // 添加节点到列表的最后 
    public void addNode(int d){
        Node node=new Node(d);
        if(head==null){
            head = node;
            return;
        }
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }
    //删除节点 
    public Boolean deleteNode(int index){
        if(index<1 || index>length()){
            return false;
        }
        if(index==1){
            head = head.next;
            return true;
        }
        int i=2;
        Node preNode = head;
        Node curNode = preNode.next;
        while(curNode != null){
            if(i==index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode=curNode.next;
            i++;
        }
        return true;
    }
    //return length of list
    public int length(){
        int length = 0;
        Node tmp = head;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }
    
    public Node orderList(){
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while(curNode.next != null){
            nextNode = curNode.next;
            while(nextNode != null){
                if(curNode.data > nextNode.data){
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
    
    public void printList(){
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    
    public static void main (String[] args) throws java.lang.Exception
	{
		MyLinkedList list=new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		System.out.println("listlength="+list.length());
		System.out.println(" before order:");
		list.printList();
		list.orderList();
		System.out.println("after order:");
		list.printList();
		
	}
    
} 