/*
 * Weighted QuicUnionAlgorithm
 */

public class WeightedQuickUnion
{
    int[] array;
    int[] sz;
    public WeightedQuickUnion(int N)
    {
        array = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        {
            array[i] = i; 
            sz[i] = 1;
        }
    }
    
    public int root(int p)
    {
        while (p != array[p])
            p = array[p];
        return p;
    }
    
    public boolean connected(int p,int q)
    {
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j) 
            return;
        if (sz[i] < sz[j])
        {
            array[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            array[j] = i;
            sz[i] += sz[j];
        }
        for (int l = 0; l < array.length; l++)
            System.out.print(array[l] + " ");
        System.out.println();
          
    }
    
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightedQuickUnion uf = new WeightedQuickUnion(N);
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
//43 38 65 94 21 50 72 61 73
//9-0 6-1 3-4 7-2 7-0 6-3 4-5 7-8 7-5 
