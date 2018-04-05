import Exceptions.EmptyListException;

public class LinkedList<T extends Comparable<T>> implements Cloneable {
    private Node<T> head = null;
    
    //default constructor
    public LinkedList() {
    }

    public void addNode(T data) {
        if(head == null) {
            head = new Node<T>(data);
        } else {
            //traverses the list till it reaches a null and then adds a new node
            Node<T> current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(data));
        }
    }

    public T removeLastNode() {
        if(head == null) {
            return null;
        } else {
            //traverse the list till it reaches the end
            Node<T> current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            return null;
        }
    }
    
    public void insertArbitraryNode(T data, int position) {
    	if(head == null || position <= 0) {
            head = new Node<T>(data);
            System.out.println("The position you are trying to insert the data in is either \nnothing in the list, 0, or a negative number");
        } else {
            int length = 0;
            Node<T> current = head;
            while(current.getNext() != null && position - 1 < length) {
                current = current.getNext();
                length++;
            }
            if(current.getNext() != null) {
                //inserting a new node without previously referencing the rest of the list to another list would result
                //in the loss of the list
                Node<T> tempNode = new Node<T>(data);
                tempNode.setNext(current.getNext());
                current.setNext(tempNode);
            } else {
                //if the length of the list does not reach the position needed, append new node to end of list
                current.setNext(new Node<T>(data));
            }
        }
    }

    public void removeArbitraryNode(int position) throws EmptyListException{
    	if(head == null || position <= 0) {
    		throw new EmptyListException();
    	}
    	
    	 int length = 0;
         Node<T> current = head;
         while(current.getNext() != null && position - 1 < length) {
             current = current.getNext();
             length++;
         }
         if(position - 1 == length) {
	         if(current.getNext().getNext() != null) {
	             current.setNext(current.getNext().getNext());
	         } else {
	        	 current.setNext(null);
	         }
         } else {
        	 System.out.println("The node you are trying to delete does not exist");
         }
    }
    
    public int countNodes() {
    	if(head == null) {
    		return 0;
    	}
    	
    	Node<T> current = head;
    	int length = 0;
    	while(current.getNext() != null) {
    		current = current.getNext();
    		length++;
    	}
    	return length;
    }
    
}
