/*************************************************************************
 * Name: Luka Rajcevic
 * Email: N/A
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Arrays;
public class Brute
{
    public static void main(String[] args)
    {
        int i, j, k, l;
        In input = new In(args[0]);
        int pointer = 0;
        int N = input.readInt();
        Point[] arr = new Point[N];
        
        while(!input.isEmpty()) 
        {
            arr[pointer] = new Point(input.readInt(), input.readInt());
            arr[pointer].draw();
            pointer++;
        }
        for (i = 0; i < N-3; i += 1)
        {
            for (j = i + 1; j < N-2; j += 1)
            {
                for (k = j + 1; k < N-1; k += 1)
                {
                    for (l = k + 1; l < N; l += 1)
                    {     
                        //check if these 4 point have the same slope
                        if ((arr[i].slopeTo(arr[j]) == arr[i].slopeTo(arr[k])) && (arr[i].slopeTo(arr[j]) == arr[i].slopeTo(arr[l])))
                        {
                            Point[] temp = new Point[]
                            {
                                arr[i], arr[j], arr[k], arr[l]
                            };
                            Arrays.sort(temp);
                            for (int s = 0; s < 4; s++)
                            {
                                StdOut.print(temp[s]);
                                if (s < 3)
                                     StdOut.print(" -> ");
                            }
                            StdOut.println();
                            temp[0].drawTo(temp[3]);
                        }
                    } 
                }
            }
           
        }
        return;
    }
}
