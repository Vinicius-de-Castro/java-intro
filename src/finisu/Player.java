package finisu;

public class Player {

    public Player(String nome){
        this.nome = nome;
    }
    //Stats
    String nome, profissao = "Desempregado";
    int dinheiro = 0, dia = 1, comida = 20;
    int energia = 10, energiaMax = 10;
    int fome = 0, fomeMax = 10;
    int sede = 0, sedeMax = 10;
    int forca = 20, forcaMax = 20;
    int inteligencia = 20, inteligenciaMax = 20;
    boolean vivo = true;
    public boolean getVivo(){
        vivo = !((energia == 0) || (fome == fomeMax) || (sede == sedeMax));
        return vivo;
    }
    //Lore
    int diasDeConstrucao = 30;
    boolean temploPronto = false;
    boolean conseguiuEmprego = false;
    boolean foiAtacado = false;
}
