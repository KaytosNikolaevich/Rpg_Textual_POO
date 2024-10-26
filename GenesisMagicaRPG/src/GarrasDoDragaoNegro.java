public class GarrasDoDragaoNegro extends Habilidade {

    public GarrasDoDragaoNegro() {
        super(
            "Garras do Dragão Negro", // Nome da habilidade
            "Invoca as garras de um dragão negro para dilacerar o inimigo.", // Descrição
            16, // Lados do dado (1d16)
            18, // Dano base
            12, // Custo de energia
            "Aplica um sangramento no inimigo, causando dano contínuo.", // Efeito adicional
            3   // Tempo de recarga em turnos
        );
    }

    @Override
    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        System.out.println("Usando: " + getNome());
        super.usarHabilidade(atributos, tipoAtributo);
    }
}
