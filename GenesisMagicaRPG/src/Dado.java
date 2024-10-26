import java.util.Random;

public class Dado {
    private Random random;

    // Construtor
    public Dado() {
        this.random = new Random();
    }

    // Método para rolar o dado sem modificador
    public int rolar(int lados) {
        return random.nextInt(lados) + 1;
    }

    // Método para rolar o dado com modificador baseado em um atributo específico
    public int rolarComModificador(int lados, int modificador) {
        int rolagem = rolar(lados);
        int resultadoFinal = rolagem + modificador;
       
        // Exibe o resultado de acordo com o tipo de atributo
        System.out.println("Rolagem: " + rolagem + " + Modificador: " + modificador + " = " + resultadoFinal);
        return resultadoFinal;
    }

    // Método para rolar o dado e verificar o acerto (com modificador de atributo)
    public int rolarAcerto(int lados, int modificador, String tipoAtributo) {
        System.out.println("Teste de acerto usando " + tipoAtributo + ":");
        return rolarComModificador(lados, modificador);
    }

    // Método para simular o dano fixo
    public void rolarDanoFixo(int danoFixo) {
        System.out.println("Dano causado: " + danoFixo);
    }

    // Métodos específicos para cada tipo de dado
    public int rolar1d4() {
        return rolar(4);
    }

    public int rolar1d6() {
        return rolar(6);
    }

    public int rolar1d8() {
        return rolar(8);
    }

    public int rolar1d10() {
        return rolar(10);
    }

    public int rolar1d12() {
        return rolar(12);
    }

    public int rolar1d16() {
        return rolar(16);
    }

    public int rolar1d20() {
        return rolar(20);
    }

    // Simulação de uma ação de teste, que pode ser usada em combate ou interações
    public void realizarAcao(String acao, int ladosDado, int modificador, String tipoAtributo) {
        System.out.println("Ação: " + acao);
        int resultado = rolarAcerto(ladosDado, modificador, tipoAtributo);
        System.out.println("Resultado da ação (" + tipoAtributo + "): " + resultado);
    }
}
