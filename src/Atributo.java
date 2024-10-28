import java.util.HashMap;

public class Atributo {
    private int forca;
    private int destreza;
    private int potencia;
    private int resistencia;
    private int persuasao;

    // Construtor padrão
    public Atributo() {
        this.forca = 0;
        this.destreza = 0;
        this.potencia = 0;
        this.resistencia = 0;
        this.persuasao = 0;
    }

    // Construtor com parâmetros
    public Atributo(int forca, int destreza, int potencia, int resistencia, int persuasao) {
        this.forca = forca;
        this.destreza = destreza;
        this.potencia = potencia;
        this.resistencia = resistencia;
        this.persuasao = persuasao;
    }

    // Método para distribuir pontos nos atributos
    public void distribuirPontos(String tipoAtributo, int pontos) {
        switch (tipoAtributo.toLowerCase()) {
            case "forca":
                this.forca += pontos;
                break;
            case "destreza":
                this.destreza += pontos;
                break;
            case "potencia":
                this.potencia += pontos;
                break;
            case "resistencia":
                this.resistencia += pontos;
                break;
            case "persuasao":
                this.persuasao += pontos;
                break;
            default:
                System.out.println("Atributo inválido.");
                break;
        }
    }

    // Método para calcular modificador baseado no valor do atributo
    public int calcularModificador(int valorAtributo) {
        return valorAtributo / 10;  // Arredonda para baixo dividindo por 10
    }

    // Método para exibir os atributos
    public void exibirAtributos() {
        System.out.println("Atributos:");
        System.out.println("Força: " + this.forca);
        System.out.println("Destreza: " + this.destreza);
        System.out.println("Potência: " + this.potencia);
        System.out.println("Resistência: " + this.resistencia);
        System.out.println("Persuasão: " + this.persuasao);
    }

    // Método para retornar os atributos em um HashMap
    public HashMap<String, Integer> getAtributos() {
        HashMap<String, Integer> atributosMap = new HashMap<>();
        atributosMap.put("forca", this.forca);
        atributosMap.put("destreza", this.destreza);
        atributosMap.put("potencia", this.potencia);
        atributosMap.put("resistencia", this.resistencia);
        atributosMap.put("persuasao", this.persuasao);
        return atributosMap;
    }

    // Método para obter o valor de um atributo por nome
    public int getAtributoPorNome(String nomeAtributo) {
        switch (nomeAtributo.toLowerCase()) {
            case "forca":
                return this.forca;
            case "destreza":
                return this.destreza;
            case "potencia":
                return this.potencia;
            case "resistencia":
                return this.resistencia;
            case "persuasao":
                return this.persuasao;
            default:
                System.out.println("Atributo inválido: " + nomeAtributo);
                return 0;
        }
    }
 // Método getModificador
    public int getModificador(String tipoAtributo) {
        switch (tipoAtributo.toLowerCase()) {
            case "forca":
                return calcularModificador(forca);
            case "destreza":
                return calcularModificador(destreza);
            case "potencia":
                return calcularModificador(potencia);
            case "resistencia":
                return calcularModificador(resistencia);
            case "persuasao":
                return calcularModificador(persuasao);
            default:
                return 0; // Retorna 0 se o tipo de atributo não for encontrado
        }
    }

    // Getters e Setters para cada atributo
    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getPersuasao() {
        return persuasao;
    }

    public void setPersuasao(int persuasao) {
        this.persuasao = persuasao;
    }
}
