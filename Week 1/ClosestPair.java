//Closest pair
/*
 *  Closest pair (in one dimension).  Write a program that, given an array a[] of N 
double values, finds a closest pair : two values whose difference is no greater than the 
the difference of any other pair (in absolute value). The running time of your program 
should be linearithmic in the worst case.
 */
import java.util.Random;
import java.util.Arrays;

public class ClosestPair
{
    
    public static void main(String[] args)
    {
        Random rand = new Random(21);
        int i;
        int N = Integer.parseInt(args[0]);
        double[] arr = new double[N];
        double diff;
        int closestIndex = 0;        
        for (i = 0; i < N; i++)
            arr[i] = rand.nextInt(100);
        Arrays.sort(arr);
        for (i = 0; i < N; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        double closestDiff = arr[1] - arr[0];
        for (i = 1; i < N-1; i++)
        {
            diff = arr[i+1] - arr[i];
            if (diff < closestDiff)
            {
                closestDiff = diff;
                closestIndex = i;
            }
        }
        System.out.println("Closest pair are numbers:" + arr[closestIndex] + " " + arr[closestIndex + 1] );
    }
}
    