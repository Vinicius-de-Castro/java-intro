package finisu.places;

import finisu.Player;
import finisu.interfaces.Evento;
import java.util.HashMap;

public class Mercado {
    public static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Comprar miojo", Mercado::comprarMiojo);
        optionsMap.put("Comprar pizza", Mercado::comprarPizza);
        optionsMap.put("Voltar", Mercado::voltar);
    }

    public static void comprarMiojo(Player player) {
        if (player.dinheiro > 0) {
            System.out.println("Você compra um miojo da Turma da Mônica");
            player.dinheiro--;
            player.comida++;
        } else
            System.out.println("Você não tem dinheiro nem pra um miojo");
    }

    public static void comprarPizza(Player player) {
        if (player.dinheiro > 10) {
            System.out.println("Você compra uma pizza da Perdidão");
            player.dinheiro -= 10;
            player.comida += 15;
        } else
            System.out.println("Você não tem dinheiro pra uma pizza");
    }

    public static void voltar(Player player) {
        System.out.println("Você sai do mercado");
    }
}
