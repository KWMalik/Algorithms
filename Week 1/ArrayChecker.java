/*
 *  Write a static method histogram() that takes an array a[] of int values and 
    an integer M as arguments and returns an array of length M whose ith entry is the num-
    ber of times the integer i appeared in the argument array. If the values in a[] are all 
    between  0  and  M–1,  the  sum  of  the  values  in  the  returned  array  should  be  equal  to 
    a.length.
 */

import java.util.Random;
public class ArrayChecker
{
    public static int histogram(int[] arr, int M)
    {
        //create the second array and fill it with 0's
        int[] mArray = new int[M];
        for (int i = 0; i < M; i++)
        {
            mArray[i] = 0;
        }
        //iterate through the first array and increment value in second by 0 at ith position
        for (int j = 0; j < arr.length ; j++)
        {
            mArray[arr[j]]++;
        }
        int sum = 0;
        //get the sum and print out the result
        for (int k = 0; k < M ; k++)
        {
            sum += mArray[k];
            System.out.print(mArray[k] + " ");
        }
        System.out.println("Sum is " + sum + " and array length is " + arr.length);
        return 0;
    }
    
    public static void main(String[] args)
    {
        //fill the first array and call the histogram function
        Random rand = new Random(20);
        int x = StdIn.readInt();
        int[] array = new int[x];
        int M = 10;
        for (int i = 0; i < x; i++)
        {
            int r = rand.nextInt(9);
            array[i] = r;
        }
        histogram(array, M);
        
    }
}