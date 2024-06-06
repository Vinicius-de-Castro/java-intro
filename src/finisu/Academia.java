package finisu;

import java.util.Map;

public class Academia extends Lugar{
    static Map<String, Evento> optionsMap = Map.ofEntries(
            Map.entry("Treinar", Academia::treinar),
            Map.entry("Pedir emprego", Academia::pedirEmprego),
            Map.entry("Voltar", Academia::voltar)
    );
    public static void treinar(Player player){
        if (player.getVivo()) {
            if (player.forca < player.forcaMax) {
                System.out.println("Você puxa ferro e fica mais forte");
                System.out.println("+1 força, +1 fome, +1 sede, -1 energia");
                player.forca++;
                player.fome++;
                player.sede++;
                player.energia--;
            }
            else System.out.println("Você já zerou toda a academia!");
        }
        else System.out.println("Não dá pra treinar nessas condições, vá se cuidar!");
    }

    public static void pedirEmprego(Player player){
        if (player.forca >= 20) {
            if (player.profissao.equals("Desempregado")){
                System.out.println("Você foi aceito, agora você é o melhor instrutor da academia");
                player.profissao = "Instrutor";
                Empresa.optionsMap.remove("pedirEmprego");
                Empresa.optionsMap.put("Desenvolver tecnologias", Academia::instruir);
                Empresa.optionsMap.put("Pedir demissão", Academia::demissao);
            }
            else System.out.println("Você já tem emprego, se quiser trabalhar aqui, pode pedir demissão onde trabalha");
        }
        else {
            System.out.println("Você é muito fraco, te expulsaram na base do chute");
        }
    }
    public static void instruir(Player player){
        System.out.println("Você treina a elite da academia");
        System.out.println("+5 dinheiro, +1 fome, +1 sede, -1 energia");
        player.dinheiro += 5;
        player.fome++;
        player.sede++;
        player.energia--;
    }
    public static void demissao(Player player){
        System.out.println("Você quer viver novas experiências, então pede demissão");
        player.profissao = "Desempregado";
        Academia.optionsMap.remove("Instruir");
        Academia.optionsMap.put("Pedir emprego", Academia::pedirEmprego);
    }
    public static void voltar(Player player){
        System.out.println("Você sai da academia");
    }
}
