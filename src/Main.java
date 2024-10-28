import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Especializacao> especializacoes = List.of(new CultivoQi(), new CultivoElemento());

        // Introdução ao mundo e ao contexto inicial
        System.out.println("Seja bem-vindo, caro jogador, ao Gênesis Mágica, o primeiro RPG desta campanha duradoura.");
        System.out.println("O intuito deste RPG é fazer os jogadores se sentirem em uma segunda vida,");
        System.out.println("passando por diversas aventuras, dificuldades, relacionamentos e momentos únicos no mundo de Avalon.");
        System.out.println("Este RPG se passará no tempo da China medieval, porém, muitas características de personagens e conceitos");
        System.out.println("podem fugir desta cultura, até porque seu caro mestre não é expert na cultura.\n");

        // Informações sobre o mundo de Avalon e seus continentes
        System.out.println("O grande mundo de Avalon, o mundo sagrado pertencente aos mortais,");
        System.out.println("cuja biodiversidade se destaca de formas insanas.");
        System.out.println("Este planeta conta com 7 continentes, 17 ilhas e 4 terras flutuantes.");
        System.out.println("Cada um de seus continentes possui uma cultura, uma história, um clima e uma variedade de coisas distintas umas das outras.\n");
        System.out.println("Porém agora, nossa história vai pegar um caminho diferente, sendo o começo de algo maior.\n");

        // Criando o personagem: nome e idade
        System.out.print("\nDigite o nome do personagem: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do personagem: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        // Inicializando o personagem com especializações disponíveis
        Personagem personagem = new Personagem(nome, idade, especializacoes);

        // Escolha de especialização
        System.out.println("\nEscolha uma especialização para seu personagem:");
        System.out.println("1. Cultivo do Qi (aprimoramento físico)");
        System.out.println("2. Cultivo de Elemento (aprimoramento elemental)");
        System.out.print("Digite o número correspondente à especialização desejada: ");
        int escolhaEspecializacao = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        // Determinar a especialização com base na escolha
        switch (escolhaEspecializacao) {
            case 1 -> personagem.setEspecializacao(new CultivoQi());
            case 2 -> personagem.setEspecializacao(new CultivoElemento());
            default -> {
                System.out.println("Escolha inválida. Definindo especialização como Qi por padrão.");
                personagem.setEspecializacao(new CultivoQi());
            }
        }

        // Distribuição de atributos
        System.out.println("\n--- Distribuição de Atributos ---");
        System.out.println("Você tem " + personagem.getPontosParaDistribuir() + " pontos para distribuir nos atributos.");
        distribuirPontos(personagem, scanner);

        // Exibir ficha inicial completa do personagem
        System.out.println("\n--- Ficha do Personagem ---");
        personagem.exibirFicha();

        // História inicial do personagem
        iniciarHistoria(scanner, nome, personagem);

        scanner.close();
    }

    public static void distribuirPontos(Personagem personagem, Scanner scanner) {
        while (personagem.getPontosParaDistribuir() > 0) {
            System.out.println("\nEscolha um atributo para aumentar:");
            System.out.println("1. Força");
            System.out.println("2. Destreza");
            System.out.println("3. Resistência");
            System.out.println("4. Potência");
            System.out.println("5. Persuasão");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            System.out.print("Quantos pontos deseja adicionar? ");
            int pontos = scanner.nextInt();

            if (pontos <= personagem.getPontosParaDistribuir()) {
                switch (opcao) {
                    case 1 -> personagem.setForca(personagem.getForca() + pontos);
                    case 2 -> personagem.setDestreza(personagem.getDestreza() + pontos);
                    case 3 -> personagem.setResistencia(personagem.getResistencia() + pontos);
                    case 4 -> personagem.setPotencia(personagem.getPotencia() + pontos);
                    case 5 -> personagem.setPersuasao(personagem.getPersuasao() + pontos);
                    default -> System.out.println("Opção inválida.");
                }
                personagem.setPontosParaDistribuir(personagem.getPontosParaDistribuir() - pontos);
                System.out.println("Pontos restantes: " + personagem.getPontosParaDistribuir());
            } else {
                System.out.println("Você não tem pontos suficientes.");
            }
        }
    }

    public static void iniciarHistoria(Scanner scanner, String nomeJogador, Personagem personagem) {
        // Introdução ao presságio
        System.out.println("\nEnquanto você medita sob a sombra de uma árvore antiga, um homem misterioso aparece diante de você.");
        System.out.println("Ele fala com um tom místico, sua presença emanando um poder indescritível.");
        System.out.println("“Um presságio chegou até mim, oh escolhido. Você tem duas opções: aceitar ou rejeitar o seu destino.”");
        System.out.println("1. Aceitar o presságio");
        System.out.println("2. Rejeitar o presságio");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();

        // Reações com base na escolha do jogador
        if (escolha == 1) {
            // Continuar com a missão na caverna
            System.out.println("\nO homem misterioso sorri com um semblante sereno e diz:");
            System.out.println("“Que os ventos do destino o guiem em sua jornada. A busca por conquistas celestiais aguarda por você.”");
            System.out.println("“No profundo seio desta floresta sagrada, uma caverna oculta guarda um segredo ancestral.”");
            System.out.println("Um ser adormecido em suas profundezas aguarda o momento do despertar.");
            System.out.println("É imperativo que você, oh escolhido, adentre as sombras e elimine a criatura que ali reside,");
            System.out.println("antes que a calamidade se espalhe por este mundo.");
            iniciarCombateNaCaverna(scanner, personagem); // Inicia o combate na caverna
        } else if (escolha == 2) {
            System.out.println("\nO homem permanece neutro e apenas diz sem pestanejar:");
            System.out.println("“Não cabe a mim questionar suas escolhas. Vá, então, e siga seu caminho, pequeno mortal.”");
            System.out.println("Você decide continuar sua vida na vila, alheio aos mistérios que circundam sua existência.");
            System.out.println("Porém, o destino não é tão gentil. Enquanto você caminha pela floresta, um Wendigo emerge das sombras!");

            // Iniciando combate
            iniciarCombateComWendigo(scanner, personagem);
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public static void iniciarCombateNaCaverna(Scanner scanner, Personagem personagem) {
        System.out.println("Você se dirige à caverna, onde uma escuridão densa te envolve.");
        System.out.println("Dentro, você encontra uma criatura adormecida, um Wendigo colossal, que despertará em breve.");

        // Iniciando combate com Wendigo na caverna
        iniciarCombateComWendigo(scanner, personagem);
    }

    public static void iniciarCombateComWendigo(Scanner scanner, Personagem personagem) {
        // Criando o Wendigo
        Wendigo wendigo = new Wendigo("Wendigo");

        // Iniciando combate
        System.out.println("O Wendigo acorda e começa a se mover em sua direção!");

        // Instancia a classe de combate
        Combate combate = new Combate(personagem, wendigo);
        combate.iniciar(); // Chama o método para iniciar o combate

        // Desfecho após o combate
        if (combate.isVitoria()) {
            // Se o jogador derrotar o Wendigo
            if (personagem.getEspecializacao() instanceof CultivoQi) {
                // Final feliz para quem aceitou o presságio
                System.out.println("\nApós uma batalha intensa, você consegue derrotar o Wendigo, libertando a floresta de seu tormento.");
                System.out.println("Enquanto o corpo do Wendigo cai ao chão, uma luz radiante irrompe a região,");
                System.out.println("e você sente uma energia pura preenchendo sua essência.");
                System.out.println("O homem misterioso aparece novamente, sorrindo.");
                System.out.println("“Você cumpriu seu destino, oh escolhido! O equilíbrio foi restaurado e suas conquistas estão apenas começando.”");
                System.out.println("Você sai da caverna como um verdadeiro herói, pronto para enfrentar novas aventuras com seus novos poderes!");
            } else {
                // Final sombrio para quem rejeitou o presságio
                System.out.println("\nApós uma batalha intensa, você consegue derrotar o Wendigo, mas não sem consequências.");
                System.out.println("A escuridão da caverna parece se encolher, mas o preço da vitória é alto.");
                System.out.println("O Wendigo, ao cair, lança uma maldição sobre você.");
                System.out.println("Você sente que a sorte se voltou contra você e que desafios ainda maiores estão por vir.");
                System.out.println("Você sai da caverna, mas a sensação de que algo sombrio te persegue permanece.");
                System.out.println("Ao longe, te observando sair da caverna, o homem agora com um sorriso no rosto diz:");
                System.out.println("“Pobre ser primitivo, que sua vida mortal seja carregada por milenios de puro caos e terror, que todos a sua volta caiam em depravação. HAHAHAHAHAHA”");
            }
        } else {
            // Se o jogador perde o combate
            System.out.println("\nVocê não conseguiu derrotar o Wendigo e caiu em batalha.");
            System.out.println("A escuridão tomou conta de você, e sua jornada termina aqui.");
            System.out.println("Tente novamente.");
        }
    }
}
