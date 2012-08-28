/*
 *  Write a code fragment that prints the contents of a two-dimensional boolean 
    array, using * to represent true and a space to represent false. Include row and column 
    numbers.
 */
import java.util.Random;
public class BooleanArrayPrint
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int x = StdIn.readInt();
        int y = StdIn.readInt();
        boolean[][] array = new boolean[x][y];
        for (int i = 0; i <x; i++)
        {
            for (int j = 0; j< y; j++)
            {
                array[i][j] = rand.nextBoolean();
            }
        }
        for (int i = 0; i <x; i++)
        {
            for (int j = 0; j< y; j++)
            {
                if (array[i][j] == false)
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}