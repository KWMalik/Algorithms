/*
 *  Write a code fragment to print the  transposition (rows and columns changed) 
    of a two-dimensional array with M rows and N columns.
 */

import java.util.Random;
public class MatrixTransposition
{
    public static void main(String[] args)
    {
        //read matrix size
        int x = StdIn.readInt();
        int y = StdIn.readInt();
        //initialize matrices
        int[][] array = new int[x][y];
        int[][] transposed = new int[y][x];
        Random rand = new Random(20);
        //fill the matrices and print the first one
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                int tempInt = rand.nextInt(10);
                array[i][j] = tempInt;
                transposed[j][i] = tempInt;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
        //print the transposed matrix
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j< x; j++)
            {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }
}