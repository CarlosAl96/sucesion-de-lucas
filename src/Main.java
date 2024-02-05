import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfThreads = 0;
        int lucasNumber = 0;

        // Obtener la cantidad de máquinas (hilos) del usuario
        System.out.print("\nIngrese la cantidad de máquinas (hilos): ");
        numberOfThreads = scanner.nextInt();

        // Obtener el número hasta el cual se calculará la serie del usuario
        System.out.print("Ingrese el número de iteraciones para la serie de Lucas: ");
        lucasNumber = scanner.nextInt();
        System.out.print("\n");

        if (numberOfThreads > lucasNumber) {
            System.out.println("Error: El número de máquinas no puede ser mayor al numero de iteraciones.");
        } else {
            Threads threads = new Threads(numberOfThreads, lucasNumber);
            threads.initThreads();
        }
    }
}