package finisu;


import java.util.Map;

import static finisu.Input.actions;

public class Loop extends Lugar{
    static boolean jogando = true;
    static Map<String, Evento> opcoesMap = Map.ofEntries(
            Map.entry("Abrir mapa", Loop::abrirMapa),
            Map.entry("Mostrar stats", Loop::mostrarStats),
            Map.entry("Parar jogo", Loop::pararJogo)
    );
    public static void abrirMapa(Player player){
        System.out.println("Onde você quer ir?");
        actions(player, Mapa.opcoesMap);
    }
    public static void mostrarStats(Player player){
        System.out.println("Stats do jogador:");
        System.out.println(STR."Nome: \{player.nome}");
        System.out.println(STR."Profissão: \{player.profissao}");
        System.out.println(STR."Dinheiro: \{player.dinheiro}");
        System.out.println(STR."Estoque de comida:\{player.comida}");
        System.out.println(STR."Energia: \{player.energia}\\\{player.energiaMax}");
        System.out.println(STR."Fome: \{player.fome}\\\{player.fomeMax}");
        System.out.println(STR."Sede: \{player.sede}\\\{player.sedeMax}");
        System.out.println(STR."Força: \{player.forca}\\\{player.forcaMax}");
        System.out.println(STR."Inteligência: \{player.inteligencia}\\\{player.inteligenciaMax}");
        System.out.println("----------------------------------------");
    }
    public static void pararJogo(Player player){
        System.out.println(STR."Obrigado por jogar, \{player.nome}!");
        jogando = false;
    }
}