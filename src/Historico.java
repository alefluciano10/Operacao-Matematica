import java.util.ArrayList;
import java.util.List;

public class Historico {

    private final List<String> registros = new ArrayList<>();

    public void registrar(double num1, double num2, String simbolo, double resultado) {
        String registro = String.format("%.2f %s %.2f = %.2f", num1, simbolo, num2, resultado);
        registros.add(registro);
    }

    public void exibirRegistros() {
        if (registros.isEmpty()) {
            System.out.println("\n📄 Nenhuma operação realizada ainda.");
        } else {
            System.out.println("\n===== HISTÓRICO =====");
            registros.forEach(System.out::println);
        }
    }
}
