import java.text.DecimalFormat;
public class PercolationStats {
   private int a;
   private double[] ar;
   private double fraction = 0.0;
   private double mean;
   //public static int T;
   public PercolationStats(int N, int T)    // perform T independent computational experiments on an N-by-N grid
   {
       if (N <= 0 || T <= 0)
           throw new java.lang.IllegalArgumentException("Illegal parameter values");
       int count = 0;
       a = T;
       ar = new double[T];
       int k = 0;
       while (k < T)
       {
           Percolation perc = new Percolation(N);
           count = 0;
           while (!perc.percolates())
           {
               int i = StdRandom.uniform(N+1);
               if (i == 0)
                   i++;
               int j = StdRandom.uniform(N+1);
               if (j == 0)
                   j++;
               if (!perc.isOpen(i, j))
               {
                   perc.open(i, j);
                   count++;
               }
           }
            ar[k] = (double) count/(double) (N*N);   
            fraction += ar[k];
            k++;
       }
   }
   public double mean()                     // sample mean of percolation threshold
   {
       mean = fraction/a;
       return mean;
   }
   public double stddev()                   // sample standard deviation of percolation threshold
   {
       //DecimalFormat Currency = new DecimalFormat("#0.000000000");    
       double sum = 0;
       double num;
       for (int i = 0; i < ar.length; i++)
       {
           num = Math.pow((ar[i] - mean), 2);
           sum = sum + num;
       }
       double z = Math.sqrt(sum/(a-1));
       
       return z;
   }
   public static void main(String[] args)   // test client, described below
   {
       int N = StdIn.readInt();
       int T = StdIn.readInt();
       PercolationStats per = new PercolationStats(N, T);
       System.out.println("mean =           " + per.mean());
       System.out.println("stddev =         " + per.stddev());
       double s_95_1 = per.mean() - ((1.96*per.stddev())/Math.sqrt(per.a));
       double s_95_2 = per.mean() + ((1.96*per.stddev())/Math.sqrt(per.a));
       System.out.println("95% confidence interval = " + s_95_1 + ", " + s_95_2);
       return;
   }
}