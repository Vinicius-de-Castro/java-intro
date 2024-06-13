package finisu;

import java.util.HashMap;

import static finisu.Input.actions;

public class Loop extends Lugar {
    static boolean jogando = true;
    static HashMap<String, Evento> opcoesMap = new HashMap<>();
    static {
        opcoesMap.put("Abrir mapa", Loop::abrirMapa);
        opcoesMap.put("Mostrar stats", Loop::mostrarStats);
        opcoesMap.put("Parar jogo", Loop::pararJogo);
    };

    public static void abrirMapa(Player player) {
        System.out.println("Onde você quer ir?");
        actions(player, Mapa.optionsMap);
    }

    public static void mostrarStats(Player player) {
        System.out.println("Stats do jogador:");
        System.out.printf("Nome: %s\n", player.nome);
        System.out.printf("Profissão: %s\n", player.profissao);
        System.out.printf("Dinheiro: %d\n", player.dinheiro);
        System.out.printf("Estoque de comida: %d\n", player.comida);
        System.out.printf("Energia: %d\\%d\n", player.energia, player.energiaMax);
        System.out.printf("Fome: %d\\%d\n", player.fome, player.fomeMax);
        System.out.printf("Sede: %d\\%d\n", player.sede, player.sedeMax);
        System.out.printf("Força: %d\\%d\n", player.forca, player.forcaMax);
        System.out.printf("Inteligência: %d\\%d\n", player.inteligencia, player.inteligenciaMax);
        System.out.println("----------------------------------------");
    }

    public static void pararJogo(Player player) {
        System.out.printf("Obrigado por jogar, %s!\n", player.nome);
        jogando = false;
    }
}
