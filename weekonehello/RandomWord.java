import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        if (args.length == 0) {
            boolean cointoss = StdRandom.bernoulli(1 / (double) 2);
            if (cointoss) {
                StdOut.println("Heads");
            }
            else {
                StdOut.println("Tails");
            }
        }
        else {
            String champion = "";
            double itteration = 1;
            while (!StdIn.isEmpty()) {
                double probablity = 1 / itteration;
                String word = StdIn.readString();
                itteration++;
                if (StdRandom.bernoulli(probablity)) {
                    champion = word;
                }
            }
            StdOut.println(champion);
        }
    }
}
