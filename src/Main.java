import java.util.Scanner;

public class Main {

    private static final Scanner leitura = new Scanner(System.in);

    public static void main(String[] args) {

        MenuOperacao menuOperacao = new MenuOperacao(leitura);
        EntradaDados entradaDados = new EntradaDados(leitura);
        OperacaoMatematica op = new OperacaoMatematica();
        Historico registros = new Historico(leitura);

        int operacao;

        do {
            operacao = menuOperacao.exibirMenuOperacao();

            switch (operacao) {
                case 0 -> {
                    System.out.println("\nEncerrando o programa... 👋");
                    return;
                }

                case 5 -> {
                    registros.exibirRegistros();
                    continue;
                }

                case 1, 2, 3, 4 -> executarOperacao(operacao, entradaDados, op, registros);
                default -> System.out.println("\n❌ Opção inválida! Tente novamente!");
            }
        } while (true);

    }

    private static void executarOperacao(int operacao, EntradaDados entradaDados,
                                         OperacaoMatematica op, Historico registros) {

        // Solicita os números
        System.out.println("\n===== OPERAÇÃO MATEMÁTICA =====");
        double num1 = entradaDados.lerNumero("Digite o primeiro número: ");
        double num2 = entradaDados.lerNumero("Digite o segundo número: ");

        try {
            double resultado = switch (operacao) {
                case 1 -> op.somar(num1, num2);
                case 2 -> op.subtrair(num1, num2);
                case 3 -> op.multiplicar(num1, num2);
                case 4 -> op.dividir(num1, num2);
                default -> throw new IllegalArgumentException("Operação Inválida!");
            };

            String simbolo = switch (operacao) {
                case 1 -> "+";
                case 2 -> "-";
                case 3 -> "×";
                case 4 -> "÷";
                default -> "";
            };

            registros.registrar(num1, num2, simbolo, resultado);
            System.out.printf("\n✅ Resultado: %.2f%n\n", resultado);
            aguardarEnter();

        } catch (IllegalArgumentException e) {
            System.out.println("\n❌ " + e.getMessage());
        }
    }

        private static void aguardarEnter() {
            System.out.println("Pressione ENTER para continuar...");
            leitura.nextLine();
        }
}



