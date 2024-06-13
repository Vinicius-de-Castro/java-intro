package finisu;

public class Player {

    public Player(String nome) {
        this.nome = nome;
    }

    // Stats
    public String nome, profissao = "Desempregado";
    public int dinheiro = 0, dia = 1, comida = 20;
    public int energia = 10, energiaMax = 10;
    public int fome = 0, fomeMax = 10;
    public int sede = 0, sedeMax = 10;
    public int forca = 0, forcaMax = 20;
    public int inteligencia = 0, inteligenciaMax = 20;
    public boolean vivo = true;

    public boolean getVivo() {
        vivo = !((energia == 0) || (fome == fomeMax) || (sede == sedeMax));
        return vivo;
    }

    // Lore
    public int diasDeConstrucao = 50;
    public boolean temploPronto = false;
    public boolean conseguiuEmprego = false;
    public boolean foiAtacado = false;
}
