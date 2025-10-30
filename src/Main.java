import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MenuOperacao menuOperacao = new MenuOperacao();
        EntradaDados entradaDados = new EntradaDados();
        OperacaoMatematica op = new OperacaoMatematica();
        Historico registros = new Historico();

        int operacao;

        do {
            operacao = menuOperacao.exibirMenuOperacao();

            if (operacao == 0) {
                System.out.println("\nEncerrando o programa... 👋");
                break;
            }

            if (operacao == 5) {
               registros.exibirRegistros();
                continue;
            }

            if (operacao < 1 || operacao > 4) {
                System.out.println("\n❌ Opção inválida! Tente novamente.");
                continue;
            }

            // Solicita os números
            System.out.println("\n===== OPERAÇÃO MATEMÁTICA =====");
            double num1 = entradaDados.lerNumero( "Digite o primeiro número: ");
            double num2 = entradaDados.lerNumero("Digite o segundo número: ");

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

                registros.registrar(num1, num2, simbolo, resultado);
                System.out.printf("\n✅ Resultado: %.2f%n", resultado);

            } catch (IllegalArgumentException e) {
                System.out.println("\n❌ " + e.getMessage());
            }
        } while (true);
    }
}
