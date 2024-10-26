import java.util.List;
import java.util.ArrayList;

public class Especializacao {
    private String nome;
    private String descricao;
    private List<Habilidade> habilidades;

    // Construtor
    public Especializacao(String nome, String descricao, List<Habilidade> habilidades) {
        this.nome = nome;
        this.descricao = descricao;
        this.habilidades = habilidades; // Inicializa com as habilidades fornecidas
    }

    // Método para adicionar uma habilidade
    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }
    
    // Getter para habilidades
    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    // Getter para o nome da especialização
    public String getNome() {
        return nome;
    }

    // Getter para a descrição da especialização
    public String getDescricao() {
        return descricao;
    }

    // Exibe as opções de habilidades para a especialização
    public void mostrarOpcoes() {
        System.out.println("Especialização: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Escolha uma habilidade:");
        
        for (int i = 0; i < habilidades.size(); i++) {
            System.out.println((i + 1) + ". " + habilidades.get(i).getNome() + " - " + habilidades.get(i).getDescricao());
        }
    }

    // Novo método para mostrar os detalhes completos das habilidades
    public void mostrarDetalhesHabilidades() {
        System.out.println("Habilidades Liberadas para Escolha: " + nome);
        for (int i = 0; i < habilidades.size(); i++) {
            Habilidade habilidade = habilidades.get(i);
            System.out.println((i + 1) + ". " + habilidade.getNome());
            System.out.println("   Descrição: " + habilidade.getDescricao());
            System.out.println("   Dano Base: " + habilidade.getDanoBase());
            System.out.println("   Custo: " + habilidade.getCusto());
            System.out.println("   Efeito: " + habilidade.getEfeito());
            System.out.println("   Tempo de Recarga: " + habilidade.getTempoRecarga() + " turnos");
            System.out.println("   Dados: 1d" + habilidade.getLadosDado());
            System.out.println();
        }
    }
}
