package finisu;

import java.util.HashMap;

public class Construcao extends Lugar{
    static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Perguntar sobre", Construcao::perguntarSobre);
        optionsMap.put("Pedir trabalho", Construcao::pedirTrabalho);
        optionsMap.put("Voltar", Construcao::voltar);
    }
    public static void perguntarSobre(Player player){
        System.out.println("Você pergunta sobre a construção");
        System.out.println("Um dos trabalhadores te diz que vai ser algum tipo de \"Templo\"");
        System.out.println(STR."Além disso, ele te diz que faltam \{player.diasDeConstrucao} dias pra conclusão");
        System.out.println("Mas se você ajudar, pode ir mais rápido");
    }
    public static void pedirTrabalho(Player player){
        if (player.diasDeConstrucao > 1){
            System.out.println("Você ajuda na obra e é pago por isso");
            System.out.println("+1 dinheiro, +1 fome, +1 sede, -1 energia");
            player.dinheiro++;
            player.fome++;
            player.sede++;
            player.energia--;
        }
        else System.out.println("A obra já está quase pronta, não precisa mais ajudar");
    }
    public static void voltar(Player player){
        System.out.println("Você sai da construção");
    }
    //Função de finalizar a obra
    public static void finalizar(Player player){
        player.temploPronto = true;
        Mapa.optionsMap.remove("Construção");
        Mapa.optionsMap.put("Templo", Mapa::templo);
    }
}
