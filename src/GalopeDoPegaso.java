public class GalopeDoPegaso extends Habilidade {

    public GalopeDoPegaso() {
        super(
            "Galope do Pégaso", // Nome da habilidade
            "Move-se rapidamente como o vento, atacando o inimigo com velocidade.", // Descrição
            8,  // Lados do dado (1d8)
            8,  // Dano base
            5,  // Custo de energia
            "Aumenta a chance de esquiva por 1 turno.", // Efeito adicional
            2   // Tempo de recarga em turnos
        );
    }

    @Override
    public void usarHabilidade(Atributo atributos, String tipoAtributo) {
        System.out.println("Usando: " + getNome());
        super.usarHabilidade(atributos, tipoAtributo);
    }
}
