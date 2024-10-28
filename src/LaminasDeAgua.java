public class LaminasDeAgua extends Habilidade {

    public LaminasDeAgua() {
        super(
            "Lâminas de Água", // Nome da habilidade
            "Corta o inimigo com lâminas formadas por água, causando dano cortante.", // Descrição
            12, // Lados do dado (1d12)
            10, // Dano base
            8,  // Custo de mana
            "Reduz a velocidade do inimigo por 2 turnos.", // Efeito adicional
            2   // Tempo de recarga em turnos
        );
    }

    @Override
    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        System.out.println("Usando: " + getNome());
        super.usarHabilidade(atributos, tipoAtributo);
    }
}
