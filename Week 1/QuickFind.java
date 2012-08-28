//Quick-find algorithm

public class QuickFind
{
    public int[] array;
    
    public QuickFind(int N)
    {
        array = new int[N];
        for (int i = 0; i < N; i++)
            array[i] = i;           
    }
    
    public boolean connected(int p, int q)
    {
        return array[p] == array[q];  
    }
    
    public void union(int p, int q)
    {
        int val1 = array[p];
        int val2 = array[q];
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == val1)
            {
                array[i] = val2;
            }
        }  
         for (int i = 0; i < array.length; i++)
             System.out.print(array[i] + " "); 
          System.out.println();
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
            }
            else
            {
                StdOut.println(p + " and " + q + " are already connected." );
            }
        }
    }
}

//example
//java QuickFind
// 6
// 1 5 => 1 5
// 2 5 => 2 5
// 1 2 => 1 and 2 are already connected