import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personagem {
    // Dados básicos
    private String nome;
    private int idade;
    private Especializacao especialista;
    private Habilidade habilidadeEscolhida;

    // Atributos e status do personagem
    private int vidaAtual;
    private int manaAtual;
    private int vidaBase;
    private int manaBase;
    private int xpAtual;
    private int xpNecessario;

    // Atributos principais
    private int forca;
    private int destreza;
    private int resistencia;
    private int potencia;
    private int persuasao;

    // Pontos para distribuir
    private int pontosParaDistribuir;

    // Classes adicionais
    private Nivel nivel;
    private GerenciarXP gerenciarXP;
    private Dado dado;

    // Lista de habilidades
    private List<Habilidade> habilidadesDisponiveis;

    // Construtor
    public Personagem(String nome, int idade, List<Especializacao> especializacoes) {
        this.nome = nome;
        this.idade = idade;
        this.nivel = new Nivel();  // Inicializa no nível 1 com 5 pontos para distribuir
        this.gerenciarXP = new GerenciarXP(this.nivel);
        this.dado = new Dado();

        this.vidaBase = 150;
        this.manaBase = 100;
        this.vidaAtual = vidaBase;
        this.manaAtual = manaBase;
        this.xpAtual = 0;
        this.xpNecessario = 100;
        this.pontosParaDistribuir = 53;  // Inicia com 53 pontos para distribuição

        escolherEspecializacao(especializacoes);
        distribuirPontosAtributos();  // Permite ao jogador distribuir os pontos após escolher a especialização
    }

    // Métodos para escolher especialização e habilidade
    public void escolherEspecializacao(List<Especializacao> especializacoes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma especialização:");
        for (int i = 0; i < especializacoes.size(); i++) {
            System.out.println((i + 1) + ". " + especializacoes.get(i).getNome() + " - " + especializacoes.get(i).getDescricao());
        }

        while (true) {
            int escolha = scanner.nextInt();
            if (escolha >= 1 && escolha <= especializacoes.size()) {
                this.especialista = especializacoes.get(escolha - 1);
                System.out.println("Especialização escolhida: " + especialista.getNome());
                escolherHabilidade(especialista.getHabilidades());
                break;
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }

    public void escolherHabilidade(List<Habilidade> habilidades) {
        this.habilidadesDisponiveis = habilidades;  // Armazena as habilidades disponíveis
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma habilidade:");
        for (int i = 0; i < habilidades.size(); i++) {
            System.out.println((i + 1) + ". " + habilidades.get(i).getNome() + " - " + habilidades.get(i).getDescricao());
        }

        while (true) {
            int escolha = scanner.nextInt();
            if (escolha >= 1 && escolha <= habilidades.size()) {
                this.habilidadeEscolhida = habilidades.get(escolha - 1);
                System.out.println("Habilidade escolhida: " + habilidadeEscolhida.getNome());
                break;
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }

    // Método para distribuir pontos nos atributos
    private void distribuirPontosAtributos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você tem " + pontosParaDistribuir + " pontos para distribuir nos atributos:");

        while (pontosParaDistribuir > 0) {
            System.out.println("Atributos disponíveis:");
            System.out.println("1. Força: " + forca);
            System.out.println("2. Destreza: " + destreza);
            System.out.println("3. Resistência: " + resistencia);
            System.out.println("4. Potência: " + potencia);
            System.out.println("5. Persuasão: " + persuasao);
            System.out.println("Pontos restantes: " + pontosParaDistribuir);
            System.out.print("Escolha o atributo para distribuir pontos (1-5): ");
            int atributoEscolhido = scanner.nextInt();

            System.out.print("Quantos pontos deseja distribuir (restantes: " + pontosParaDistribuir + "): ");
            int pontos = scanner.nextInt();

            if (pontos > 0 && pontos <= pontosParaDistribuir) {
                switch (atributoEscolhido) {
                    case 1: forca += pontos; break;
                    case 2: destreza += pontos; break;
                    case 3: resistencia += pontos; break;
                    case 4: potencia += pontos; break;
                    case 5: persuasao += pontos; break;
                    default: System.out.println("Atributo inválido."); continue;
                }
                pontosParaDistribuir -= pontos;
            } else {
                System.out.println("Pontos inválidos. Tente novamente.");
            }
        }
        System.out.println("Distribuição de pontos concluída!");
    }

    // Métodos para manipular vida e mana
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

    public void recuperarVida(int quantidade) {
        vidaAtual += quantidade;
        if (vidaAtual > vidaBase) vidaAtual = vidaBase;
        System.out.println(nome + " recuperou " + quantidade + " de vida. Vida atual: " + vidaAtual);
    }

    public void gastarMana(int quantidade) {
        manaAtual -= quantidade;
        if (manaAtual < 0) manaAtual = 0;
        System.out.println(nome + " gastou " + quantidade + " de Mana. Mana atual: " + manaAtual);
    }

    public void recuperarMana(int quantidade) {
        manaAtual += quantidade;
        if (manaAtual > manaBase) manaAtual = manaBase;
        System.out.println(nome + " recuperou " + quantidade + " de Mana. Mana atual: " + manaAtual);
    }

    // Método de morte e reinício do personagem
    private void morrer() {
        System.out.println("\n" + nome + " morreu e o jogo será reiniciado.\n");

        // Reinicia os atributos do personagem
        vidaAtual = vidaBase;
        manaAtual = manaBase;
        xpAtual = 0;
        nivel = new Nivel();  // Reinicia o nível
        System.out.println("Personagem foi reiniciado para o nível 1. Vida e mana recuperadas.");

        // Solicitar ao jogador para refazer a ficha e distribuir pontos
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do personagem: ");
        this.nome = scanner.nextLine();

        System.out.print("Digite a idade do personagem: ");
        this.idade = scanner.nextInt();

        System.out.println("\nEscolha novamente sua especialização:");
        escolherEspecializacao(List.of(new CultivoQi(), new CultivoElemento()));
        distribuirPontosAtributos();  // Distribuir pontos novamente
    }

    // Método para ganhar XP e subir de nível se necessário
    public void ganharXP(int xp) {
        gerenciarXP.ganharXP(xp);
    }

    // Método para rolar atributos usando a classe Dado
    public int rolarAtributo(String atributo) {
        int modificador;
        switch (atributo.toLowerCase()) {
            case "força":
                modificador = forca;
                break;
            case "destreza":
                modificador = destreza;
                break;
            case "resistência":
                modificador = resistencia;
                break;
            case "potência":
                modificador = potencia;
                break;
            case "persuasão":
                modificador = persuasao;
                break;
            default:
                System.out.println("Atributo inválido.");
                return 0;
        }
        return dado.rolarComModificador(20, modificador); // Exemplo com 1d20
    }

    // Exibir ficha completa do personagem
    public void exibirFicha() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nível: " + nivel.getNivelAtual());
        System.out.println("Vida: " + vidaAtual + "/" + vidaBase);
        System.out.println("Mana: " + manaAtual + "/" + manaBase);
        System.out.println("Especialista: " + especialista.getNome());
        System.out.println("Força: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Resistência: " + resistencia);
        System.out.println("Potência: " + potencia);
        System.out.println("Persuasão: " + persuasao);
        System.out.println("Habilidade Escolhida: " + habilidadeEscolhida.getNome());
    }

    // Getters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public Especializacao getEspecializacao() {
        return especialista;
    }

    public void setEspecializacao(Especializacao especialista) {
        this.especialista = especialista;
    }

    public Habilidade getHabilidadeEscolhida() {
        return habilidadeEscolhida;
    }

    public void setHabilidadeEscolhida(Habilidade habilidadeEscolhida) {
        this.habilidadeEscolhida = habilidadeEscolhida;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
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

    public int getPontosParaDistribuir() {
        return pontosParaDistribuir;
    }

    public void setPontosParaDistribuir(int pontosParaDistribuir) {
        this.pontosParaDistribuir = pontosParaDistribuir;
    }

    public List<Habilidade> getHabilidadesDisponiveis() {
        return habilidadesDisponiveis;
    }
}
