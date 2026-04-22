import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Historico {

    private final List<String> registros = new ArrayList<>();
    private final Scanner leitura;

    public Historico(Scanner leitura) {
        this.leitura = leitura;
    }

    public void registrar(double num1, double num2, String simbolo, double resultado) {
        registros.add(String.format("%.2f %s %.2f = %.2f", num1, simbolo, num2, resultado));
    }

    public void exibirRegistros() {
        System.out.println("\n===== HISTÓRICO =====");

        if (registros.isEmpty()) {
            System.out.println("\n📄 Nenhuma operação realizada ainda.");
        } else {
            registros.forEach(System.out::println);
        }

        System.out.println("\nPressione ENTER para continuar...");
        leitura.nextLine();
    }
}
