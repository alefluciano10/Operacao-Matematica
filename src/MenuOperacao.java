import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOperacao {

    private final Scanner ler = new Scanner(System.in);

    public int exibirMenuOperacao() {
        System.out.println("\n===============================");
        System.out.println("      🧮 CALCULADORA JAVA      ");
        System.out.println("===============================");
        System.out.println("1 ➤ Adição");
        System.out.println("2 ➤ Subtração");
        System.out.println("3 ➤ Multiplicação");
        System.out.println("4 ➤ Divisão");
        System.out.println("5 ➤ Histórico");
        System.out.println("0 ➤ Sair");
        System.out.print("\nEscolha uma operação: ");

        try {
            return ler.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n❌ Entrada inválida! Digite apenas números.");
            ler.next(); // limpa o buffer
            return -1;
        }
    }
}
