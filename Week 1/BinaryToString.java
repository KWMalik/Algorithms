/*
 *  Write a code fragment that puts the binary representation of a positive integer N
    into a String s.
 */

public class BinaryToString
{
    public static void main(String[] args)
    {
        String s = "";
        String reverse = "";
        int x = StdIn.readInt();
        while (x > 0)
        {
            s += (x%2) + "";
            x = x/2;
        }
        for (int i = s.length()-1; i >=0; i--)
        {
            reverse += s.charAt(i);
        }
        System.out.println(reverse);
    }
}