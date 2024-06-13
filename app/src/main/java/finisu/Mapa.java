package finisu;

import java.util.HashMap;
import static finisu.Input.*;

public class Mapa extends Lugar {
    static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Casa", Mapa::casa);
        optionsMap.put("Escola", Mapa::escola);
        optionsMap.put("Academia", Mapa::academia);
        optionsMap.put("Mercado", Mapa::mercado);
        optionsMap.put("Construção", Mapa::construcao);
        optionsMap.put("Empresa", Mapa::empresa);
        optionsMap.put("Voltar", Mapa::voltar);
    }

    public static void casa(Player player) {
        System.out.println("O que fazer em casa?");
        actions(player, Casa.optionsMap);
    }

    public static void escola(Player player) {
        System.out.println("O que fazer na escola?");
        actions(player, Escola.optionsMap);
    }

    public static void academia(Player player) {
        System.out.println("O que fazer na academia?");
        actions(player, Academia.optionsMap);
    }

    public static void mercado(Player player) {
        System.out.println("O que fazer no mercado?");
        System.out.println("Preços:");
        System.out.println("Miojo (1 dinheiro), Pizza (10 dinheiros)");
        actions(player, Mercado.optionsMap);
    }

    public static void construcao(Player player) {
        System.out.println("O que fazer na construção?");
        actions(player, Construcao.optionsMap);
    }

    public static void empresa(Player player) {
        System.out.println("O que fazer na empresa?");
        actions(player, Empresa.optionsMap);
    }

    public static void voltar(Player player) {
        System.out.println("Você fecha o mapa");
    }

    // Lugares desbloqueáveis
    public static void templo(Player player) {

    }
}
