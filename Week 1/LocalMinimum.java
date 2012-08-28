/*
 *     
 * Local minimum of an array.  Write a program that, given an array a[] of N dis-
tinct integers, finds a local minimum: an index i such that a[i-1] < a[i] < a[i+1]. 
Your program should use ~2lg N compares in the worst case..
Answer :  Examine  the  middle  value  a[N/2]  and  its  two  neighbors  a[N/2  -  1]  and 
a[N/2 + 1]. If a[N/2] is a local minimum, stop; otherwise search in the half with the 
smaller neighbor.
 */

import java.util.Arrays;
import java.util.Random;

public class LocalMinimum
{
    public static void isMinimum(int[] a, int n)
    {
       //System.out.println("Local minimum");
       if (n <= 1)
           return;
       if ((a[n/2] > a[n/2 - 1]) && (a[n/2] < a[n/2 + 1]))
       {
           System.out.println("Local minimum is number: "+ a[n/2]);
           return;
       }
       else
       {
           if ((n/2 -1) > (n/2+1))
           {
               int[] b = Arrays.copyOfRange(a, n/2+1, n);
               isMinimum(b, n/2);
               
           }
           int[] b = Arrays.copyOfRange(a,0, n/2-1);
           isMinimum(a, n/2);
       }
    }
    public static void main(String[] args)
    {
        Random rand = new Random(11);
        int i;
        int N = Integer.parseInt(args[0]);
        int[] arr = new int[N];        
        for (i = 0; i < N; i++)
            arr[i] = rand.nextInt(100);
        //Arrays.sort(arr);
        for (i = 0; i < N; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        isMinimum(arr, N);
    }
}