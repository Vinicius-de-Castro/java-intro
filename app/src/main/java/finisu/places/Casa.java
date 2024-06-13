package finisu.places;

import finisu.Player;
import finisu.interfaces.Evento;
import java.util.HashMap;

public class Casa {
    public static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Beber água", Casa::beberAgua);
        optionsMap.put("Comer", Casa::comer);
        optionsMap.put("Tirar cochilo", Casa::tirarCochilo);
        optionsMap.put("Dormir", Casa::dormir);
        optionsMap.put("Voltar", Casa::voltar);
    };

    public static void beberAgua(Player player) {
        if (player.sede == 0) {
            System.out.println("Você não está com sede");
        } else {
            System.out.println("Você se enche d'água");
            player.sede = 0;
        }
    }

    public static void comer(Player player) {
        if (player.comida == 0) {
            System.out.println("Você não tem comida em casa :/");
        } else if (player.fome == 0) {
            System.out.println("Você não está com fome");
        } else {
            player.comida--;
            player.fome--;
        }
    }

    public static void tirarCochilo(Player player) {
        if (player.energia == player.energiaMax) {
            System.out.println("Você não está com sono");
        } else {
            System.out.println("Você dá uma bela cochilada");
            player.energia++;
        }
    }

    public static void dormir(Player player) {
        if (player.energia == player.energiaMax)
            System.out.println("Você não está com sono");
        else {
            System.out.println("Você dorme que nem um bebê");
            player.energia = player.energiaMax;
            player.dia++;
            if (player.diasDeConstrucao > 0)
                player.diasDeConstrucao--;
            if (player.diasDeConstrucao == 0) {
                Construcao.finalizar(player);
                System.out.println("Tem novidades no mapa");
            }
            System.out.println("----------------------------------------");
            System.out.printf("Hoje é dia %d\n", player.dia);
            System.out.println("O que você quer fazer hoje?");
        }
    }

    public static void voltar(Player player) {
        System.out.println("Você sai de casa");
    }
}
