import java.math.BigInteger;

public class Threads {
    private int numberOfThreads;
    private int lucasNumber;
    private int fraction;
    private LucasSeries runnable = new LucasSeries();

    public Threads(int numberOfThreads, int lucasNumber) {
        this.numberOfThreads = numberOfThreads;
        this.lucasNumber = lucasNumber;
        this.fraction = lucasNumber / numberOfThreads;
    }

    public void initThreads() {

        //Variable para guardar el index donde quedó, si ocurre un error
        int index = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                if (i == numberOfThreads - 1) {
                    if (index == 0) {
                        runnable.setStartEnd(fraction * i, lucasNumber + 1);
                    } else {
                        runnable.setStartEnd(index, lucasNumber + 1);
                    }
                } else {
                    if (index == 0) {
                        runnable.setStartEnd(fraction * i, fraction * (i + 1));
                    } else {
                        runnable.setStartEnd(index, fraction * (i + 2));
                    }
                }

                Thread thread = new Thread(runnable);
                thread.start();
                System.out.print("Hilo " + (i + 1) + " ejecutandose");

                thread.join();
                index = 0;

            } catch (InterruptedException e) {
                System.out.println("Error en el hilo: " + (i + 1));
                index = runnable.getLucasSeries().size();
            }
        }
        System.out.println("\nSerie de Lucas resultante:\n");

        for (int i = 0; i < runnable.getLucasSeries().size(); i++) {
            System.out.println("[" + i + "] -> " + runnable.getLucasSeries().get(i));
        }
    }
}
