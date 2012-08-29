/*
 * Subset client. Write a client program Subset.java that takes a command-line
 * integer k, reads in a sequence of N strings from standard input using 
 * StdIn.readString(), and prints out exactly k of them, uniformly at random. 
 * Each item from the sequence can be printed out at most once. You may assume 
 * that k ? 0 and no greater than the number of string on standard input.
*/
public class Subset
{
    public static void main(String[] args)
    {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) 
        {
            String item = StdIn.readString();
            q.enqueue(item);
        }
        while (k > 0)
        {
            StdOut.println(q.dequeue());
            k--;
        }
        return;
    }
    
}