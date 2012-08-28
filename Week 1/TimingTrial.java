/*
 * 
 */
import java.lang.Math;
public class TimingTrial
{
    public static void main(String[] args)
    {
        int counter= 0;
        double time_2 = 1;
        double time;
        double time_p;
        double log_;
        for (int i = 128; counter < 5; i = i*2)
        {
            Stopwatch watch = new Stopwatch();
            Timing.trial(i, 216088);
            time = watch.elapsedTime();
                time_p = time/time_2;
                time_2 = time;
                System.out.println("Time ratio is" + time_p + ".");
                log_ = Math.log(time_p)/Math.log(2);
                System.out.println("Log time:" + log_ + ".");
 
            //time = watch.elapsedTime();
            //StdOut.println(i + " " +  watch.elapsedTime());
            counter++;
        }
    }
}
/*
 * 
 * T(320) = a*320^b = 0.86    /ln
 * T(640) = a*640^b = 4.98    /ln
 *    -------------------------------
 *        = blna*320 = ln(0.86)
 *        = blna*640 = ln(4.98)
 */

