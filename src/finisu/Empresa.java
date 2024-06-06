package finisu;

import java.util.Map;

public class Empresa extends Lugar{
    static Map<String, Evento> optionsMap = Map.ofEntries(
            Map.entry("Pedir emprego", Empresa::pedirEmprego),
            Map.entry("Voltar", Empresa::voltar)
    );
    public static void pedirEmprego(Player player){
        if (player.inteligencia >= 20) {
            if (player.profissao.equals("Desempregado")){
                System.out.println("Você foi aceito, agora você é engenheiro da Apple!");
                player.profissao = "Engenheiro";
                Empresa.optionsMap.remove("pedirEmprego");
                Empresa.optionsMap.put("Desenvolver tecnologias", Empresa::desenvolver);
                Empresa.optionsMap.put("Pedir demissão", Empresa::demissao);
            }
            else System.out.println("Você já tem emprego, se quiser trabalhar aqui, pode pedir demissão onde trabalha");
        }
        else {
            System.out.println("Você é muito burro, te expulsaram na base do chute");
        }
    }
    public static void desenvolver(Player player){
        System.out.println("Você desenvolve tecnologias muito brabas");
        System.out.println("+5 dinheiro, +1 fome, +1 sede, -1 energia");
        player.dinheiro += 5;
        player.fome++;
        player.sede++;
        player.energia--;
    }
    public static void demissao(Player player){
        System.out.println("Você quer viver novas experiências, então pede demissão");
        player.profissao = "Desempregado";
        Empresa.optionsMap.remove("Desenvolver tecnologias");
        Empresa.optionsMap.put("Pedir emprego", Empresa::pedirEmprego);
    }
    public static void voltar(Player player){
        System.out.println("Você sai da empresa");
    }
}