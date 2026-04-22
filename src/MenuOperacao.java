import java.util.Scanner;

public class MenuOperacao {

    private final Scanner leitura;

    public MenuOperacao(Scanner leitura) {
        this.leitura = leitura;
    }

    public int exibirMenuOperacao() {
        while (true) {
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
                return Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Entrada inválida! Digite apenas números!");
            }
        }
    }
}
