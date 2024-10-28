public class CorrentesDaMorte extends Habilidade {

    public CorrentesDaMorte() {
        super(
            "Correntes da Morte", // Nome da habilidade
            "Conjura correntes espectrais que aprisionam e drenam a vida do inimigo.", // Descrição
            10, // Lados do dado (1d10)
            12, // Dano base
            15, // Custo de mana
            "Imobiliza o inimigo por 1 turno e drena vida.", // Efeito adicional
            4   // Tempo de recarga em turnos
        );
    }

    @Override
    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        System.out.println("Usando: " + getNome());
        super.usarHabilidade(atributos, tipoAtributo);
    }
}
