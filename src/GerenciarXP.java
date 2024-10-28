public class GerenciarXP {
    private int xpAtual;
    private int xpNecessaria;
    private Nivel nivel;

    public GerenciarXP(Nivel nivel) {
        this.nivel = nivel;
        this.xpAtual = 0;
        this.xpNecessaria = calcularXpNecessaria();
    }

    // Método para calcular a quantidade de XP necessária para o próximo nível
    private int calcularXpNecessaria() {
        return nivel.getNivelAtual() * 100; // Exemplo: 100, 200, 300 XP, conforme o nível
    }

    // Método para ganhar XP
    public void ganharXP(int xpGanho) {
        xpAtual += xpGanho;
        System.out.println("Você ganhou " + xpGanho + " XP!");
        if (verificarNivelUp()) {
            xpAtual -= xpNecessaria;
            nivel.subirNivel();
            xpNecessaria = calcularXpNecessaria();
        }
    }

    // Verifica se o XP atual é suficiente para subir de nível
    public boolean verificarNivelUp() {
        return xpAtual >= xpNecessaria;
    }

    // Exibe a XP atual e a necessária para o próximo nível
    public void exibirXP() {
        System.out.println("XP atual: " + xpAtual + "/" + xpNecessaria);
    }
}
