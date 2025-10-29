import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OperacaoMatematica op = new OperacaoMatematica();
        int operacao;

        do {
            System.out.println("\n===== OPERAÇÃO MATEMÁTICA =====");
            System.out.println("1 - Adição");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma operação: ");
            operacao = sc.nextInt();

            if (operacao == 0) {
                System.out.println("\nEncerrando o programa...");
                break;
            }

            if (operacao >= 1 && operacao <= 4) {
                System.out.println("\n***** ESCCOLHA NÚUMERICA *****");
                System.out.print("Digite o primeiro número: ");
                op.setNumero1(sc.nextDouble());

                // 🔹 Para divisão, garante que o segundo número não seja 0
                if (operacao == 4) {
                    do {
                        System.out.print("Digite o segundo número: ");
                        op.setNumero2(sc.nextDouble());

                        if (op.getNumero2() == 0) {
                            System.out.println("\n❌ Erro: Não é possível dividir por zero. Tente novamente!\n");
                        }

                    } while (op.getNumero2() == 0);
                } else {
                    System.out.print("Digite o segundo número: ");
                    op.setNumero2(sc.nextDouble());
                }
            }

            switch (operacao) {
                case 1 -> op.adicao();
                case 2 -> op.subtracao();
                case 3 -> op.multiplicacao();
                case 4 -> op.divisao();
                default -> System.out.println("\n❌ Opção inválida! Tente novamente.");
            }

        } while (operacao != 0);

        sc.close();
    }
}
