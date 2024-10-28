import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

\\public class Ficha {
    // Dados Básicos
    private String nome;
    private int idade;
    private Especializacao especialista;
    private Habilidade habilidadeEscolhida;
    
    // Atributos do personagem
    private int vidaAtual;
    private int manaAtual;
    private int vidaBase;
    private int manaBase;
    
    // Classes adicionais
    private Atributo atributos;
    private Nivel nivel;
    private GerenciarXP gerenciarXP;

    // Construtor
    public Ficha(String nome, int idade, List<Especializacao> especializacoes) {
        this.nome = nome;
        this.idade = idade;
        this.nivel = new Nivel();  // Inicializa no nível 1 com 5 pontos para distribuir
        this.gerenciarXP = new GerenciarXP(this.nivel);
        this.atributos = new Atributo();

        this.vidaBase = 100;
        this.manaBase = 50;
        this.vidaAtual = vidaBase;
        this.manaAtual = manaBase;

        escolherEspecializacao(especializacoes); // Escolher especialização ao criar a ficha
    }

    // Método para o jogador inserir as informações iniciais
    public void criarFicha() {
        Scanner scanner = new Scanner(System.in);

        // Inserir o nome do personagem
        System.out.println("Digite o nome do personagem:");
        this.nome = scanner.nextLine();

        // Inserir a idade do personagem
        System.out.println("Digite a idade do personagem:");
        this.idade = scanner.nextInt();
    }

    // Método para escolher a especialização entre as opções disponíveis
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

    // Método para escolher habilidade da especialização
    public void escolherHabilidade(List<Habilidade> habilidades) {
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

    // Métodos para gerenciar vida e mana
    public void perderVida(int dano) {
        vidaAtual -= dano;
        if (vidaAtual < 0) vidaAtual = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. Vida atual: " + vidaAtual);
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

    // Método para exibir habilidades disponíveis
    public void exibirHabilidades() {
        System.out.println("Habilidades disponíveis na especialização " + especialista.getNome() + ":");
        List<Habilidade> habilidades = especialista.getHabilidades();
        for (int i = 0; i < habilidades.size(); i++) {
            System.out.println((i + 1) + ". " + habilidades.get(i).getNome() + " - " + habilidades.get(i).getDescricao());
        }
    }

    // Método para usar uma habilidade escolhida pelo índice
    public void usarHabilidade(int escolha) {
        List<Habilidade> habilidades = especialista.getHabilidades();
        if (escolha >= 1 && escolha <= habilidades.size()) {
            Habilidade habilidade = habilidades.get(escolha - 1);
            habilidade.usarHabilidade(atributos, "potencia"); // Ajuste o atributo relevante conforme necessário
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    // Método para distribuir pontos nos atributos
    public void distribuirPontos(String atributo, int pontos) {
        if (pontos <= nivel.getPontosDistribuir()) {
            atributos.distribuirPontos(atributo, pontos);
            nivel.usarPontos(pontos);
        } else {
            System.out.println("Pontos insuficientes para distribuir.");
        }
    }

    // Método para ganhar pontos por nível
    public void ganharPontosPorNivel() {
        int novosPontos = nivel.getPontosDistribuir();
        System.out.println("Você ganhou " + novosPontos + " pontos para distribuir.");
    }

    // Método para setar o nível do jogador manualmente
    public void setNivel(int novoNivel) {
        nivel.setNivelAtual(novoNivel);
        System.out.println("O nível foi ajustado para: " + novoNivel);
        ganharPontosPorNivel(); 
    }

    // Método para ganhar XP e verificar nível
    public void ganharXP(int xp) {
        gerenciarXP.adicionarXP(xp);
        nivel.ganharXP(xp);
    }

    // Exibir ficha completa
    public void exibirFicha() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nível: " + nivel.getNivelAtual());
        System.out.println("Vida: " + vidaAtual + "/" + vidaBase);
        System.out.println("Mana: " + manaAtual + "/" + manaBase);
        System.out.println("Especialista: " + especialista.getNome());
        atributos.exibirAtributos();
        System.out.println("Habilidade escolhida: " + habilidadeEscolhida.getNome());
        gerenciarXP.exibirXP();
    }

    // Getters e Setters
    public Especializacao getEspecialista() { return especialista; }
    public int getNivel() { return nivel.getNivelAtual(); }
    public HashMap<String, Integer> getAtributos() { return atributos.getAtributos(); }
    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getManaAtual() { return manaAtual; }
}
