package in.rama.practise.linkedlist;

public class DeepCopyLinkedListWithRandom {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }

        //set the pointer to the head node
        RandomListNode currentNode = head;

        //Extend the list with the adjacent copy nodes
        while(currentNode != null){
            RandomListNode temp = currentNode.next;
            currentNode.next = new RandomListNode(currentNode.label);
            currentNode.next.next = temp;
            currentNode = temp;
        }

        //Reset the current pointer to the head node
        currentNode = head;

        //
        while(currentNode != null){
            if(currentNode.random != null){
                currentNode.next.random = currentNode.random.next;
            }else{
                currentNode.next.random = null;
            }

            currentNode = currentNode.next.next;
        }

        RandomListNode originalHead = head;
        RandomListNode copyHead = head.next;

        RandomListNode temp = copyHead;

        while((originalHead != null) && (copyHead != null)){
            originalHead.next = originalHead.next != null?originalHead.next.next: null;
            copyHead.next = copyHead.next!=null?copyHead.next.next: null;
            originalHead = originalHead.next;
            copyHead = copyHead.next;
        }

        return temp;
    }

    public static void main(String[] args){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        node1.random = node4;
        node2.random = node1;
        node3.random = node2;
        node4.random = node3;

        RandomListNode copied = copyRandomList(node1);

        while(copied != null){
            System.out.println(copied.label);
            System.out.println(copied.next.label);
            System.out.println(copied.random.label);
            copied = copied.next;
        }
    }
}


