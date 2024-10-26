public class SocoDoDragaoDeJade extends Habilidade {

    public SocoDoDragaoDeJade() {
        super(
            "Soco do Dragão de Jade", // Nome da habilidade
            "Desfere um soco poderoso imbuído de energia dracônica.", // Descrição
            10,  // Lados do dado (1d10)
            20,  // Dano base
            10,  // Custo de energia
            "Empurra o inimigo para trás e reduz sua defesa por 1 turno.", // Efeito adicional
            3    // Tempo de recarga em turnos
        );
    }

    @Override
    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        System.out.println("Usando: " + getNome());
        super.usarHabilidade(atributos, tipoAtributo);
    }
}
