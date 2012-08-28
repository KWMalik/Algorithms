/*
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a 
 * generalization of a stack and a queue that supports inserting and removing 
 * items from either the front or the back of the data structure.
 * 
 * 28-08-2012. 
 * ©Luka Rajèeviæ
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> 
{
    private Node first;
    private Node last;
    private int N;
    
    private class Node
    {
        private Item item;
        private Node next;
        private Node prev;
    }
    // construct an empty deque
    public Deque()
    {
        first =  null;
        last = null;
        N = 0;
    }  
        
    // is the deque empty?
    public boolean isEmpty()
    {
       return first == null;
    }
    // return the number of items on the deque
    public int size() 
    {
        return N;
    }
    // insert the item at the front
    public void addFirst(Item item)
    {
        if (item == null)
            throw new java.lang.NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = null;
        first.prev = null;
        if (!isEmpty())
        {
            first.next = oldFirst;
        }
        ++N;
        if (N == 1)
            last = first;
        
    }
    // insert the item at the end
    public void addLast(Item item)
    {
        if (item == null)
            throw new java.lang.NullPointerException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        ++N;
        if (N == 1)
            first = last;
    }

    // delete and return the item at the front
    public Item removeFirst()
    {
        if(isEmpty()) 
            throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        if (N > 1)
        {
            first = first.next;
            first.prev = null;
        }
        else
        {
            first = null;
            last = null;
        }
        --N;
        return item;
    }

    // delete and return the item at the end
    public Item removeLast()  
    {
        if(isEmpty()) 
            throw new NoSuchElementException("Queue underflow");
        Item item = last.item;
        if (N > 1)
        {
            last = last.prev;
            last.next = null;
        }
        else
        {
            last = null;
            first = null;
        }
        --N;
        return item;
    }
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()   
    {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("last")) 
                q.addLast(item);
            else if (item.equals("--"))
                q.removeFirst();
            else if (item.equals("first"))
                q.addFirst(item);
            else
                q.removeLast();
             //StdOut.println("(" + q.size() + " left on Deque)");
        }
       
    }
}