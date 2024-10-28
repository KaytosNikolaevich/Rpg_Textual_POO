import java.util.List;

public class CultivoElemento extends Especializacao {

    public CultivoElemento() {
        super(
            "Especialista em Cultivo de Elemento", // Nome da especialização
            "Usa poderes elementais para aumentar a força e manipulação de elementos.", // Descrição
            List.of(
                new BolaDeFogo(), // Usa a subclasse existente BolaDeFogo
                new LaminasDeAgua(), // Usa a subclasse existente LaminasDeAgua
                new CorrentesDaMorte() // Usa a subclasse existente CorrentesDaMorte
            )
        );
    }
}
