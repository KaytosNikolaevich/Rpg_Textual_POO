public class Wendigo {
    private String nome;
    private int vidaAtual;
    private int vidaBase;
    private int manaAtual;
    private int manaBase;
    private int forca;
    private int destreza;
    private int resistencia;
    private int potencia;
    private int persuasao;

    // Habilidade do Wendigo
    private GritoInfernal gritoInfernal;

    // Construtor
    public Wendigo(String nome) {
        this.nome = nome;
        this.vidaBase = 200;
        this.manaBase = 50;
        this.vidaAtual = vidaBase;
        this.manaAtual = manaBase;
        this.forca = 30;
        this.destreza = 20;
        this.resistencia = 3;
        this.potencia = 0;
        this.persuasao = 0;
        this.gritoInfernal = new GritoInfernal(); // Inicializa a habilidade específica do Wendigo
    }

    // Método para perder vida
    public void perderVida(int dano, Personagem jogador) {
        vidaAtual -= dano;
        if (vidaAtual <= 0) {
            vidaAtual = 0;
            System.out.println(nome + " recebeu " + dano + " de dano e morreu.");
            morrer(jogador); // Chama o método morrer passando o jogador
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano, mas ainda está vivo.");
        }
    }

    // Método que lida com a morte do Wendigo
    private void morrer(Personagem jogador) {
        System.out.println(nome + " foi derrotado!");
        jogador.ganharXP(100); // O jogador ganha 100 XP ao derrotar o Wendigo
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    public int getManaBase() {
        return manaBase;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPersuasao() {
        return persuasao;
    }

    public void setPersuasao(int persuasao) {
        this.persuasao = persuasao;
    }

    public GritoInfernal getGritoInfernal() {
        return gritoInfernal;
    }

    // Outros métodos conforme necessário...
}
