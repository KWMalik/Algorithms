
public class Percolation {
    public Percolation(int N){};              // create N-by-N grid, with all sites blocked
    public void open(int i, int j){};         // open site (row i, column j) if it is not already
    public boolean isOpen(int i, int j){};    // is site (row i, column j) open?
    public boolean isFull(int i, int j){};   // is site (row i, column j) full?
   public boolean percolates()
   {
       count();
   }// does the system percolate?
}