public class Nivel {
    private int nivelAtual;
    private int pontosDistribuir;
    private int xpAtual;
    private int xpNecessario;

    // Inicialmente o jogador começa no nível 1 com 5 pontos e 0 XP
    public Nivel() {
        this.nivelAtual = 1;
        this.pontosDistribuir = 5;
        this.xpAtual = 0;
        this.xpNecessario = 100; // Exemplo: 100 XP necessário para o nível 2
    }

    // Método para ganhar XP
    public void ganharXP(int xp) {
        this.xpAtual += xp;
        System.out.println("Ganhou " + xp + " XP. XP Atual: " + xpAtual + "/" + xpNecessario);

        // Verifica se atingiu o XP necessário para subir de nível
        while (xpAtual >= xpNecessario) {
            xpAtual -= xpNecessario; // Reduz o XP usado para subir de nível
            subirNivel();
        }
    }

    // A cada nível, ganha 5 pontos adicionais
    public void subirNivel() {
        nivelAtual++;
        pontosDistribuir += 5;

        // Aumenta o XP necessário para o próximo nível (exemplo: +100 por nível)
        xpNecessario = nivelAtual * 100;

        System.out.println("Você subiu para o nível " + nivelAtual + "!");
        System.out.println("Pontos para distribuir: " + pontosDistribuir);
    }

    // Método para ganhar pontos de atributo quando o nível é ajustado
    public void ganharPontosPorNivel() {
        int novosPontos = 5;
        pontosDistribuir += novosPontos;
        System.out.println("Você ganhou " + novosPontos + " pontos para distribuir.");
    }

    // Método para ajustar o nível manualmente
    public void setNivelAtual(int novoNivel) {
        if (novoNivel > nivelAtual) {
            nivelAtual = novoNivel;
            pontosDistribuir += (novoNivel - nivelAtual) * 5;  // 5 pontos por nível a mais
            xpNecessario = novoNivel * 100;
            System.out.println("O nível foi ajustado para: " + novoNivel);
        } else {
            System.out.println("O nível informado é menor ou igual ao atual.");
        }
    }

    // Método para usar pontos de atributos
    public void usarPontos(int pontos) {
        if (pontos > pontosDistribuir) {
            System.out.println("Pontos insuficientes para distribuir.");
        } else {
            pontosDistribuir -= pontos;
            System.out.println("Você distribuiu " + pontos + " pontos. Pontos restantes: " + pontosDistribuir);
        }
    }

    // Getters
    public int getNivelAtual() {
        return nivelAtual;
    }

    public int getPontosDistribuir() {
        return pontosDistribuir;
    }

    public int getXpAtual() {
        return xpAtual;
    }

    public int getXpNecessario() {
        return xpNecessario;
    }
}
