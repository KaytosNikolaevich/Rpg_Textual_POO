public class GritoInfernal extends Habilidade {
    public GritoInfernal() {
        super("Grito Infernal", 
              "O Wendigo emite um grito aterrorizante que afeta todos os inimigos próximos, além de ter 1d2 de chance de chamar um aliado.", 
              20,  // Lados do dado
              30,  // Dano base
              50,  // Custo de mana
              "Afeta inimigos próximos, chance de chamar um aliado.", 
              5);  // Tempo de recarga
    }
}
