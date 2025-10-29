public class OperacaoMatematica {

    private double numero1;
    private double numero2;
    private double resultado;

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double adicao() {
        resultado = getNumero1() + getNumero2();
        System.out.printf("\nO resuultado da adição é %.2f%n", resultado);
        return resultado;
    }

    public double subtracao() {
        resultado = getNumero1() - getNumero2();
        System.out.printf("\nO resuultado da subtração é %.2f%n", resultado);
        return resultado;
    }

    public double multiplicacao() {
        resultado = getNumero1() * getNumero2();
        System.out.printf("\nO resuultado da multiplicação é %.2f%n", resultado);
        return resultado;
    }

    public double divisao() {
        if (getNumero2() == 0) {
            System.out.println("\nErro: Não é possível dividir por zero");
        } else  {
            resultado = getNumero1() / getNumero2();
            System.out.printf("\nO resuultado da divisão é %.2f%n", resultado);
            return resultado;
        }
        return 0;
    }
}





