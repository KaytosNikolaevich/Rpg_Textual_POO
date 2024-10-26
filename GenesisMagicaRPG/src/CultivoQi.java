import java.util.List;

public class CultivoQi extends Especializacao {

    public CultivoQi() {
        super(
            "Especialista em Cultivo de Qi", // Nome da especialização
            "Utiliza a energia vital para aprimorar o corpo e realizar ataques poderosos.", // Descrição
            List.of(
                new Habilidade("Galope do Pegaso", "Aumenta a velocidade do jogador.", 6, 10, 5, "Aumenta agilidade", 3),
                new Habilidade("Garras do Dragão Negro", "Cria garras poderosas feitas de energia Qi.", 8, 12, 8, "Aumenta dano físico", 4),
                new Habilidade("Soco do Dragão de Jade", "Um soco com força extrema imbuído de Qi.", 10, 15, 10, "Chance de atordoar o inimigo", 5)
            )
        );
    }
}
