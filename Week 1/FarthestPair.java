//Farthest pair
/*
 *   Farthest pair (in one dimension).  Write a program that, given an array a[] of N 
double values, finds a farthest pair : two values whose difference is no smaller than the 
the difference of any other pair (in absolute value). The running time of your program 
should be linear in the worst case.
 */
import java.util.Random;
import java.util.Arrays;

public class FarthestPair
{
    
    public static void main(String[] args)
    {
        Random rand = new Random(21);
        int i;
        int N = Integer.parseInt(args[0]);
        double[] arr = new double[N];        
        for (i = 0; i < N; i++)
            arr[i] = rand.nextInt(100);
        Arrays.sort(arr);
        for (i = 0; i < N; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("Farthest pair are numbers:" + arr[0] + " " + arr[N-1] );
    }
}
    