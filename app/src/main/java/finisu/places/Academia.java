package finisu.places;

import finisu.Player;
import java.util.HashMap;
import finisu.interfaces.Lugar;
import finisu.interfaces.Evento;

public class Academia extends Lugar {
    public static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Treinar", Academia::treinar);
        optionsMap.put("Pedir emprego", Academia::pedirEmprego);
        optionsMap.put("Voltar", Academia::voltar);
    }

    public static void treinar(Player player) {
        if (player.getVivo()) {
            if (player.forca < player.forcaMax) {
                System.out.println("Você puxa ferro e fica mais forte");
                System.out.println("+1 força, +1 fome, +1 sede, -1 energia");
                player.forca++;
                player.fome++;
                player.sede++;
                player.energia--;
            } else
                System.out.println("Você já zerou toda a academia!");
        } else
            System.out.println("Não dá pra trabalhar nessas condições, vá se cuidar!");
    }

    public static void pedirEmprego(Player player) {
        if (player.forca >= 20) {
            if (player.profissao.equals("Desempregado")) {
                System.out.println("Você foi aceito e agora é o melhor instrutor da academia!");
                academiaEntrar(player);
            } else
                System.out.println("Você já tem emprego, se quiser trabalhar aqui, pode pedir demissão onde trabalha");
        } else {
            System.out.println("Você é muito fraco, te expulsaram na base do chute");
        }
    }

    public static void instruir(Player player) {
        if (player.getVivo()) {
            System.out.println("Você treina a elite da academia");
            System.out.println("+5 dinheiro, +1 fome, +1 sede, -1 energia");
            player.dinheiro += 5;
            player.fome++;
            player.sede++;
            player.energia--;
        } else
            System.out.println("Não dá pra treinar nessas condições, vá se cuidar!");
    }

    public static void demissao(Player player) {
        System.out.println("Você quer viver novas experiências, então pede demissão");
        academiaSair(player);
    }

    public static void voltar(Player player) {
        System.out.println("Você sai da academia");
    }

    // Funções de emprego
    public static void academiaEntrar(Player player) {
        player.profissao = "Instrutor";
        optionsMap.remove("Pedir emprego");
        optionsMap.put("Instruir", Academia::instruir);
        optionsMap.put("Pedir demissão", Academia::demissao);
    }

    public static void academiaSair(Player player) {
        player.profissao = "Desempregado";
        optionsMap.remove("Instruir");
        optionsMap.remove("Pedir demissão");
        optionsMap.put("Pedir emprego", Academia::pedirEmprego);
    }
}
