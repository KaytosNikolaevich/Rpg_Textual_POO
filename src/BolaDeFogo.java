public class BolaDeFogo extends Habilidade {

    public BolaDeFogo() {
        super(
            "Bola de Fogo", // Nome da habilidade
            "Lança uma poderosa bola de fogo contra o inimigo, causando dano em área.", // Descrição
            20, // Lados do dado (1d20)
            15, // Dano base
            10, // Custo de mana
            "Queima o inimigo por 2 turnos, causando dano contínuo.", // Efeito adicional
            3 // Tempo de recarga em turnos
        );
    }

    // Método para usar a habilidade, agora integrando o modificador de atributo
    @Override
    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        System.out.println("Lançando: " + getNome());
        super.usarHabilidade(atributos, tipoAtributo);  // Usamos o método da classe Habilidade
    }
}
