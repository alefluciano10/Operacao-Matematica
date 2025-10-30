import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDados {

    private final Scanner leitura = new Scanner(System.in);

    public double lerNumero( String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return leitura.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Valor inválido! Digite um número válido.\n");
                leitura.next(); // limpa o buffer
            }

        }
    }
}
