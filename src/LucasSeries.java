import java.util.ArrayList;
import java.math.BigInteger;

public class LucasSeries implements Runnable {
    private int start;
    private int end;
    private ArrayList<BigInteger> series = new ArrayList<>();

    public void setStartEnd(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public ArrayList<BigInteger> getLucasSeries() {
        return series;
    }

    public void run() {
        int size = end - start;

        System.out.println(" (Desde: [" + start + "] Hasta: [" + (end - 1) + "])");

        if (size > 0) {
            for (int i = start; i < end; i++) {
                if (i == 0) {
                    series.add(new BigInteger("2"));
                } else if (i == 1) {
                    series.add(new BigInteger("1"));
                } else {
                    series.add(series.get(i - 2).add(series.get(i - 1)));
                }
            }
        } else {
            System.out.println("Error: La serie no se puede calcular");
        }
    }
}
