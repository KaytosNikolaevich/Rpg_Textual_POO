public abstract class Monstro {
    protected String nome;
    protected int vidaAtual;
    protected int vidaBase;
    protected int manaAtual;
    protected int manaBase;
    protected int forca;
    protected int destreza;
    protected int resistencia;
    protected int potencia;
    protected int persuasao;

    // Habilidade do monstro
    protected Habilidade habilidade;

    // Construtor
    public Monstro(String nome, int vidaBase, int manaBase, int forca, int destreza, int resistencia, int potencia, int persuasao) {
        this.nome = nome;
        this.vidaBase = vidaBase;
        this.manaBase = manaBase;
        this.vidaAtual = vidaBase;
        this.manaAtual = manaBase;
        this.forca = forca;
        this.destreza = destreza;
        this.resistencia = resistencia;
        this.potencia = potencia;
        this.persuasao = persuasao;
    }

    // Método para perder vida
    public void perderVida(int dano) {
        vidaAtual -= dano;
        if (vidaAtual <= 0) {
            vidaAtual = 0;
            System.out.println(nome + " recebeu " + dano + " de dano e morreu.");
            morrer();
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano. Vida atual: " + vidaAtual);
        }
    }

    // Método para lidar com a morte do monstro
    protected void morrer() {
        System.out.println(nome + " morreu. Seu corpo desaparece em uma nuvem de sombras.");
        // Aqui você pode adicionar lógica adicional, como dar XP ao jogador ou registrar a morte
    }

    // Método para usar a habilidade do monstro
    public void usarHabilidade(Atributo atributos, String tipoAtributo, Personagem alvo) {
        if (habilidade != null && manaAtual >= habilidade.getCusto()) {
            int dano = habilidade.usarHabilidade(atributos, tipoAtributo);
            if (dano > 0) {
                alvo.perderVida(dano);
                manaAtual -= habilidade.getCusto();
                System.out.println(nome + " usou " + habilidade.getNome() + " em " + alvo.getNome() + " e causou " + dano + " de dano.");
            }
        } else {
            System.out.println(nome + " não pode usar habilidades no momento.");
        }
    }

    // Métodos de acesso para atributos
    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getManaAtual() { return manaAtual; }
    public int getForca() { return forca; }
    public int getDestreza() { return destreza; }
    public int getResistencia() { return resistencia; }
    public int getPotencia() { return potencia; }
    public int getPersuasao() { return persuasao; }
    
    // Exibir estado do monstro
    public void exibirEstado() {
        System.out.println("Monstro: " + nome);
        System.out.println("Vida: " + vidaAtual + "/" + vidaBase);
        System.out.println("Mana: " + manaAtual + "/" + manaBase);
        System.out.println("Força: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Resistência: " + resistencia);
        System.out.println("Potência: " + potencia);
        System.out.println("Persuasão: " + persuasao);
        if (habilidade != null) {
            System.out.println("Habilidade: " + habilidade.getNome());
        }
    }
}
