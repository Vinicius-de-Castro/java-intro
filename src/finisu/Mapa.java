package finisu;

import java.util.Map;
import static finisu.Input.*;

public class Mapa extends Lugar{
    static Map<String, Evento> opcoesMap = Map.ofEntries(
            Map.entry("Casa", Mapa::casa),
            Map.entry("Escola", Mapa::escola),
            Map.entry("Academia", Mapa::academia),
            Map.entry("Mercado", Mapa::mercado),
            Map.entry("Construção", Mapa::construcao),
            Map.entry("Empresa", Mapa::empresa),
            Map.entry("Voltar", Mapa::voltar)
    );
    public static void casa(Player player){
        System.out.println("O que fazer em casa?");
        actions(player, Casa.optionsMap);
    }
    public static void escola(Player player){
        System.out.println("O que fazer na escola?");
        actions(player, Escola.optionsMap);
    }
    public static void academia(Player player){
        System.out.println("O que fazer na academia?");
        actions(player, Academia.optionsMap);
    }
    public static void mercado(Player player){
        System.out.println("Ainda vou implementar o mercado");
    }
    public static void construcao(Player player){
        System.out.println("Ainda vou implementar a construção");
    }
    public static void empresa(Player player) {
        System.out.println("O que fazer na empresa?");
        actions(player, Empresa.optionsMap);
    }
    public static void voltar(Player player){
        System.out.println("Você fecha o mapa");
    }
}
