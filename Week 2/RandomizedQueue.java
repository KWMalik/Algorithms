/*
 * Randomized queue. A randomized queue is similar to a stack or queue, 
 * except that the item removed is chosen uniformly at random from items 
 * in the data structure.
 * 28-08-2012. 
*/
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Random rand = new Random();
    private Item[] q;
    private static int N = 0;
    private int first = 0; 
    private int last = 0;
   // construct an empty randomized queue
   public RandomizedQueue()
   {
       q = (Item[]) new Object[2];
   }
   // is the queue empty?
   public boolean isEmpty()  
   {
       return N == 0;
   }
   // return the number of items on the queue
   public int size()                  
   {
       return N;
   }
   
   private void resize(int max)
   {
       assert max >= N;
       Item[] temp = (Item[]) new Object[max];
       for (int i = 0; i < N; i++)
           temp[i] = q[(first + i) % q.length];
       q = temp;
       first = 0; 
       last = N;
   }
   
   // add the item
   public void enqueue(Item item)
   {
       if (item == null)
           throw new NullPointerException();
       if (N == q.length)
           resize(2*q.length);
       q[last++] = item;
       N++;
   }
   // delete and return a random item
   public Item dequeue()
   {
       if (isEmpty()) 
           throw new NoSuchElementException("Queue underflow");
       Random randomGenerator = new Random();
       int randomIndex = rand.nextInt(N);
       //System.out.println(randomIndex);
       //System.out.println(N);
       Item item = q[randomIndex];
       if (randomIndex != N)
           q[randomIndex] = q[N-1];
       q[N-1] = null;
       N--;
       --last;
       if (N > 0 && N == q.length/4) 
           resize(q.length/2);
      return item;
   }
   // return (but do not delete) a random item
   public Item sample()
   {
       if (isEmpty()) 
           throw new NoSuchElementException("Queue underflow");
       rand = new Random();
       int randomIndex = rand.nextInt(N);
       Item item = q[randomIndex];
       return item;
   }
   public Iterator<Item> iterator()   
   {
       return new ArrayIterator();
   }
   
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  
        { 
            return i < N;                               
        }
        public void remove()      
        { 
            throw new UnsupportedOperationException();  
        }

        public Item next() {
            if (!hasNext()) 
                throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) 
                StdOut.println("item removed: " + q.dequeue());
            else if (item.equals("s"))
                StdOut.println("sample item: " + q.sample());
            else 
                q.enqueue(item);
            StdOut.println("(" + q.size() + " left on queue)");
        }
    }
}