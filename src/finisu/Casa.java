package finisu;

import java.util.Map;

public class Casa extends Lugar{
     static Map<String, Evento> optionsMap = Map.ofEntries(
            Map.entry("Beber água", Casa::beberAgua),
            Map.entry("Comer", Casa::comer),
            Map.entry("Tirar cochilo", Casa::tirarCochilo),
            Map.entry("Dormir", Casa::dormir),
            Map.entry("Voltar", Casa::voltar)
    );
    public static void beberAgua(Player player){
        if (player.sede == 0) {
            System.out.println("Você não está com sede");
        }
        else {
            System.out.println("Você se enche d'água");
            player.sede = 0;
        }
    }
    public static void comer(Player player){
        if (player.comida == 0) {
            System.out.println("Você não tem comida em casa :/");
        }
        else if (player.fome == 0){
            System.out.println("Você não está com fome");
        }
        else {
            player.comida--;
            player.fome--;
        }
    }
    public static void tirarCochilo(Player player){
        if (player.energia == 10) {
            System.out.println("Você não está com sono");
        }
        else {
            System.out.println("Você dá uma bela cochilada");
            player.energia++;
        }
    }
    public static void dormir(Player player){
        if (player.energia == 10) System.out.println("Você não está com sono");
        else {
            System.out.println("Você dorme que nem um bebê");
            player.energia = 10;
            player.dia++;
            System.out.println("----------------------------------------");
            System.out.println(STR."Hoje é dia \{player.dia}");
            System.out.println("O que você quer fazer hoje?");
        }
    }
    public static void voltar(Player player) {
        System.out.println("Você sai de casa");
    }
}