//edit for inputs in (N, N) range

    public class Percolation
    {
        private boolean[][] array;
        private WeightedQuickUnionUF uf;
        // create N-by-N grid, with all sites blocked
        public Percolation(int N)
        {
            uf = new WeightedQuickUnionUF(N*N+1);
            array = new boolean[N][N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    array[i][j] = false;
                }       
            }
        }    
        //print out matrix
        /*
        private void printArray(boolean[][] arr)
        {
            for (int i = 0; i < arr.length; i++)
            {
                for(int j = 0; j < arr.length; j++)
                {
                    if (arr[i][j] == false)
                        System.out.print(" 0 ");
                    else
                        
                        System.out.print(" X ");
                }
                System.out.println();
            }
        }
        */
        public void open(int i, int j)
        {
            if (i <= 0 || i > array.length) 
                throw new IndexOutOfBoundsException("row index i out of bounds");
            if (j <= 0 || j > array.length)
                throw new IndexOutOfBoundsException("col index j out of range");
            array[i-1][j-1] = true;
            if (i == 1)
            {
                uf.union(array.length*array.length, j-1);
                if (i < array.length && isOpen(i+1, j))
                     uf.union(array.length*array.length, array.length*(i)+(j-1));    
            }
            else
            {
                if (i-2 >= 0 && isOpen(i-1, j))
                    uf.union(array.length*(i-1)+j-1, array.length*(i-2)+(j-1));
                if (i < array.length && isOpen(i+1, j))
                     uf.union(array.length*(i-1)+j-1, array.length*i+(j-1));
                if (j-2 >= 0 && isOpen(i, j-1))
                    uf.union(array.length*(i-1)+j-1, array.length*(i-1)+(j-2));
                if (j < array.length && isOpen(i, j+1))
                     uf.union(array.length*(i-1)+j-1, array.length*(i-1)+j);
            }
            //if (percolates())
              //  System.out.println("It percolates");
            //else
              //  System.out.println("Does not percolate");
            //printArray(array);
           
        }       
        // is site (row i, column j) open?
        public boolean isOpen(int i, int j)
        {
             return array[i-1][j-1];
        }    
        // is site (row i, column j5) full?
        public boolean isFull(int i, int j)
        {
            if (i <= 0 || i > array.length) 
                throw new IndexOutOfBoundsException("row index i out of bounds");
            if (j <= 0 || j > array.length)
                throw new IndexOutOfBoundsException("col index j out of range");
            if (uf.find(array.length*(i-1)+j-1) == uf.find(array.length*array.length))
            {
                return true;
            }
            return false;
        }
        // does the system percolate?
        public boolean percolates()
        {
            int k = array.length;
            for (int j = k; j > 0; j--)
            {
                if (uf.find(array.length*(array.length-1)+j-1) == uf.find(array.length*array.length))
                {
                     return true;
                }
            }
            return false;
        }
        public static void main(String[] args)
        {
            int N = StdIn.readInt();
            Percolation per = new Percolation(N);
            while (!StdIn.isEmpty())
            {
                int i = StdIn.readInt();
                int j = StdIn.readInt();
                per.open(i, j);
            }
        }
    }
    