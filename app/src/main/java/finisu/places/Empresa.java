package finisu.places;

import finisu.Player;
import finisu.interfaces.Evento;
import java.util.HashMap;

public class Empresa {
    public static HashMap<String, Evento> optionsMap = new HashMap<>();
    static {
        optionsMap.put("Pedir emprego", Empresa::pedirEmprego);
        optionsMap.put("Voltar", Empresa::voltar);
    }

    public static void pedirEmprego(Player player) {
        if (player.inteligencia >= 20) {
            if (player.profissao.equals("Desempregado")) {
                System.out.println("Você foi aceito, agora você é engenheiro da Apple!");
                empresaEntrar(player);
            } else
                System.out.println("Você já tem emprego, se quiser trabalhar aqui, pode pedir demissão onde trabalha");
        } else {
            System.out.println("Você é muito burro, te expulsaram na base do chute");
        }
    }

    public static void desenvolver(Player player) {
        if (player.getVivo()) {
            System.out.println("Você desenvolve tecnologias muito brabas");
            System.out.println("+5 dinheiro, +1 fome, +1 sede, -1 energia");
            player.dinheiro += 5;
            player.fome++;
            player.sede++;
            player.energia--;
        } else
            System.out.println("Não dá pra trabalhar nessas condições, vá se cuidar!");
    }

    public static void demissao(Player player) {
        System.out.println("Você quer viver novas experiências, então pede demissão");
        empresaSair(player);
    }

    public static void voltar(Player player) {
        System.out.println("Você sai da empresa");
    }

    // Funções de emprego
    public static void empresaEntrar(Player player) {
        player.profissao = "Engenheiro";
        optionsMap.remove("Pedir emprego");
        optionsMap.put("Desenvolver tecnologias", Empresa::desenvolver);
        optionsMap.put("Pedir demissão", Empresa::demissao);
    }

    public static void empresaSair(Player player) {
        player.profissao = "Desempregado";
        optionsMap.remove("Desenvolver tecnologias");
        optionsMap.remove("Pedir demissão");
        optionsMap.put("Pedir emprego", Empresa::pedirEmprego);
    }
}
