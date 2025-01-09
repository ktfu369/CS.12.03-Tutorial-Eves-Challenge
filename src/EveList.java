import java.util.Scanner;

public class EveList {

    Node head;
    static class Node{
        int value;
        Node next;

        Node (int data){
            this.value = data;
            next = null;
        }
    }

    public Node getHead(){
        return head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public static EveList insertNode(EveList list, int value){
        Node node = new Node(value);

        if(list.head == null){
            list.head = node;
        }
        else{
            Node cur = list.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        return list;
    }

    public static void printList(EveList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.value + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static int findWinner(int n){
        EveList suitors = new EveList();
        for(int i=1;i<=n;i++){
            suitors = insertNode(suitors, i);
        }

        // make cyclical
        Node cur = suitors.head;
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = suitors.head;

//        printList(suitors);

        int count = 1;
        Node currentSuitor = suitors.head;
        while(currentSuitor.next != currentSuitor){
            // pointing to itself - only 1 element left
            if(count%3 == 2){ // check the one before
                // remove
                System.out.println("Removed number " + currentSuitor.next.value);
                count ++;
                currentSuitor.next = currentSuitor.next.next;
            }
            count ++;
            currentSuitor = currentSuitor.next;
        }
        return currentSuitor.value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the number of suitors: ");
        int n;
        n = scanner.nextInt();

        int winner = findWinner(n);
        System.out.println("Winning suitor: " + winner);
    }

}
