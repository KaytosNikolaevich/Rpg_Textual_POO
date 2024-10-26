public class Habilidade {
    private String nome;
    private String descricao;
    private int ladosDado; // O número de lados do dado utilizado na habilidade
    private int danoBase; // Dano base da habilidade
    private int custo; // Custo de mana ou energia
    private String efeito; // Efeito adicional que a habilidade causa
    private int tempoRecarga; // Tempo de recarga da habilidade (em turnos)
    private int tempoRestante; // Tempo restante para poder usar a habilidade novamente
    private Dado dado; // Instância da classe Dado para rolar os valores

    public Habilidade(String nome, String descricao, int ladosDado, int danoBase, int custo, String efeito, int tempoRecarga) {
        this.nome = nome;
        this.descricao = descricao;
        this.ladosDado = ladosDado; // Armazenamos o número de lados do dado
        this.danoBase = danoBase;
        this.custo = custo;
        this.efeito = efeito;
        this.tempoRecarga = tempoRecarga;
        this.tempoRestante = 0; // Inicialmente, a habilidade pode ser usada
        this.dado = new Dado(); // Inicializamos a instância da classe Dado
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getLadosDado() {
        return ladosDado;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public int getCusto() {
        return custo;
    }

    public String getEfeito() {
        return efeito;
    }

    public int getTempoRecarga() {
        return tempoRecarga;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    // Atualiza o tempo restante de recarga
    public void reduzirTempoRecarga() {
        if (tempoRestante > 0) {
            tempoRestante--;
        }
    }

    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        if (tempoRestante == 0) {
            // Obtém o modificador do atributo baseado no tipo
            int modificador = atributos.getModificador(tipoAtributo);
            
            // Realiza a rolagem do dado usando o modificador baseado no tipo de atributo
            int resultadoDado = dado.rolarComModificador(ladosDado, modificador);

            // Calcula o dano final somando o dano base ao resultado da rolagem
            int danoFinal = danoBase + resultadoDado;

            // Exibe o dano causado
            System.out.println("Usando habilidade: " + nome);
            System.out.println("Dano causado com " + nome + " (" + tipoAtributo + "): " + danoFinal);

            // Reinicia o tempo de recarga
            tempoRestante = tempoRecarga;
        } else {
            System.out.println("A habilidade " + nome + " ainda está em recarga. Tempo restante: " + tempoRestante);
        }
    }
    @Override
    public String toString() {
        return "Habilidade: " + nome + " - " + descricao + " (Dado: 1d" + ladosDado + ", Dano Base: " + danoBase +
               ", Custo: " + custo + ", Efeito: " + efeito + ", Recarga: " + tempoRecarga + " turnos)";
    }
}
