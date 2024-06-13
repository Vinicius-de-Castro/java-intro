package finisu.places;

import finisu.Player;
import finisu.Mapa;
import finisu.interfaces.Lugar;
import finisu.interfaces.Evento;
import java.util.HashMap;

public class Construcao extends Lugar {
    public static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Perguntar sobre", Construcao::perguntarSobre);
        optionsMap.put("Pedir trabalho", Construcao::pedirTrabalho);
        optionsMap.put("Voltar", Construcao::voltar);
    }

    public static void perguntarSobre(Player player) {
        System.out.println("Você pergunta sobre a construção");
        System.out.println("Um dos trabalhadores te diz que vai ser algum tipo de \"Templo\"");
        System.out.printf("Além disso, ele te diz que faltam %d dias pra conclusão\n", player.diasDeConstrucao);
        System.out.println("Mas se você ajudar, pode ir mais rápido");
    }

    public static void pedirTrabalho(Player player) {
        if (player.diasDeConstrucao > 1) {
            if (player.getVivo()) {
                System.out.println("Você ajuda na obra e é pago por isso");
                System.out.println("+2 dinheiro, +2 fome, +2 sede, -2 energia");
                player.dinheiro += 2;
                player.fome += 2;
                player.sede += 2;
                player.energia -= 2;
                player.diasDeConstrucao--;
            } else
                System.out.println("Não dá pra trabalhar nessas condições, vá se cuidar!");
        } else
            System.out.println("A obra já está quase pronta, não precisa mais ajudar");
    }

    public static void voltar(Player player) {
        System.out.println("Você sai da construção");
    }

    // Função de finalizar a obra
    public static void finalizar(Player player) {
        player.temploPronto = true;
        Mapa.optionsMap.remove("Construção");
        Mapa.optionsMap.put("Templo", Mapa::templo);
    }
}
