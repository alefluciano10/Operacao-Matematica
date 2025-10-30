import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OperacaoMatematica op = new OperacaoMatematica();
        List<String> historico = new ArrayList<>();
        int operacao;

        do {
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
                operacao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Entrada inválida! Digite apenas números.");
                sc.next(); // limpa o buffer
                continue;
            }

            if (operacao == 0) {
                System.out.println("\nEncerrando o programa... 👋");
                break;
            }

            if (operacao == 5) {
                if (historico.isEmpty()) {
                    System.out.println("\n📄 Nenhuma operação realizada ainda.");
                } else {
                    System.out.println("\n===== HISTÓRICO =====");
                    historico.forEach(System.out::println);
                }
                continue;
            }

            if (operacao < 1 || operacao > 4) {
                System.out.println("\n❌ Opção inválida! Tente novamente.");
                continue;
            }

            // Solicita os números
            System.out.println("\n===== OPERAÇÃO MATEMÁTICA =====");
            double num1 = lerNumero(sc, "Digite o primeiro número: ");
            double num2 = lerNumero(sc, "Digite o segundo número: ");

            try {
                double resultado = switch (operacao) {
                    case 1 -> op.somar(num1, num2);
                    case 2 -> op.subtrair(num1, num2);
                    case 3 -> op.multiplicar(num1, num2);
                    case 4 -> op.dividir(num1, num2);
                    default -> 0;
                };

                String simbolo = switch (operacao) {
                    case 1 -> "+";
                    case 2 -> "-";
                    case 3 -> "×";
                    case 4 -> "÷";
                    default -> "";
                };

                String registro = String.format("%.2f %s %.2f = %.2f", num1, simbolo, num2, resultado);
                historico.add(registro);

                System.out.printf("\n✅ Resultado: %.2f%n", resultado);

            } catch (IllegalArgumentException e) {
                System.out.println("\n❌ " + e.getMessage());
            }
        } while (true);

        sc.close();
    }

    // 🔹 Metodo auxiliar para ler número com validação
    private static double lerNumero(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ Valor inválido! Digite um número válido.");
                sc.next(); // limpa o buffer
            }

        }
    }
}
