import java.util.Scanner;

public class Combate {
    private Personagem personagem; // Referência ao personagem do jogador
    private Wendigo inimigo; // Referência ao inimigo (Wendigo)
    private Dado dado; // Objeto Dado para rolagens
    private Scanner scanner; // Para entrada do jogador

    public Combate(Personagem personagem, Wendigo inimigo) {
        this.personagem = personagem;
        this.inimigo = inimigo;
        this.dado = new Dado(); // Inicializa o objeto Dado
        this.scanner = new Scanner(System.in); // Inicializa o scanner para entrada
    }

    public void iniciar() {
        System.out.println("O combate começou entre " + personagem.getNome() + " e " + inimigo.getNome() + "!");

        while (personagem.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
            turnoJogador();
            if (inimigo.getVidaAtual() > 0) {
                turnoInimigo();
            }
        }

        if (personagem.getVidaAtual() <= 0) {
            System.out.println(personagem.getNome() + " foi derrotado!");
        } else {
            System.out.println(inimigo.getNome() + " foi derrotado!");
        }
    }

    private void turnoJogador() {
        System.out.println("\nÉ a vez do jogador: " + personagem.getNome());
        System.out.println("Escolha uma ação:");
        System.out.println("1. Ataque Básico");
        System.out.println("2. Usar Habilidade");
        // Adicione mais opções conforme necessário
        System.out.print("Digite o número da ação: ");
        int acao = scanner.nextInt();

        int dano = 0;
        switch (acao) {
            case 1:
                dano = realizarAtaqueBasico();
                break;
            case 2:
                dano = realizarHabilidade();
                break;
            default:
                System.out.println("Ação inválida. O jogador perdeu a vez!");
                return; // O jogador perde a vez se a ação for inválida
        }

        inimigo.perderVida(dano, personagem); // Passa o jogador para a função perderVida do Wendigo
        System.out.println(inimigo.getNome() + " agora tem " + inimigo.getVidaAtual() + " de vida.");
    }

    private int realizarAtaqueBasico() {
        // Lança um dado d20 e adiciona a força do personagem
        int modificador = personagem.getForca() / 10;
        int dano = dado.rolarComModificador(20, modificador); // Usando a classe Dado
        
        System.out.println(personagem.getNome() + " atacou e causou " + dano + " de dano.");
        return dano;
    }

    private int realizarHabilidade() {
        // Implementar a lógica para o uso de habilidades
        // Exemplo simplificado: dano fixo para demonstração
        int dano = 50; // Dano da habilidade
        System.out.println(personagem.getNome() + " usou uma habilidade e causou " + dano + " de dano.");
        return dano;
    }

    private void turnoInimigo() {
        System.out.println("\nÉ a vez do inimigo: " + inimigo.getNome());

        // O inimigo ataca o jogador
        int dano = calcularDanoInimigo();
        personagem.perderVida(dano);
        System.out.println(personagem.getNome() + " agora tem " + personagem.getVidaAtual() + " de vida.");
    }

    private int calcularDanoInimigo() {
        // Lança um dado d20 e adiciona a força do inimigo
        int modificador = inimigo.getForca() / 10;
        int dano = dado.rolarComModificador(20, modificador); // Usando a classe Dado
        
        System.out.println(inimigo.getNome() + " atacou e causou " + dano + " de dano.");
        return dano;
    }

    public boolean isVitoria() {
        // Retorna verdadeiro se o personagem derrotou o Wendigo
        return inimigo.getVidaAtual() <= 0;
    }
}
