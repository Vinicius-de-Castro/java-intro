package finisu;

import java.util.Map;

public class Escola extends Lugar{
    static Map<String, Evento> optionsMap = Map.ofEntries(
            Map.entry("Estudar", Escola::estudar),
            Map.entry("Beber água", Escola::beberAgua),
            Map.entry("Comprar salgado", Escola::comprarSalgado),
            Map.entry("Voltar", Escola::voltar)
    );
    public static void estudar(Player player){
        if (player.getVivo()) {
            if (player.inteligencia < player.inteligenciaMax) {
                System.out.println("Você estuda e fica mais inteligente");
                System.out.println("+1 inteligência, +1 fome, +1 sede, -1 energia");
                player.inteligencia++;
                player.fome++;
                player.sede++;
                player.energia--;
            }
            else System.out.println("Você já é inteligente demais!");
        }
        else System.out.println("Não dá pra estudar nessas condições, vá se cuidar!");
    }
    public static void beberAgua(Player player){
        if (player.sede > 0) {
            System.out.println("Você toma água com gosto ruim no bebedouro");
            player.sede--;
        }
        else System.out.println("Você nem está com sede, melhor não beber essa água");
    }
    public static void comprarSalgado(Player player){
        if (player.dinheiro > 0){
            if (player.fome > 0){
                System.out.println("Você comprar um enroladinho de pombo");
                player.fome--;
                player.dinheiro--;
            }
            else System.out.println("Você não está com fome, não vale a pena");
        }
        else System.out.println("Você não tem dinheiro pra comprar salgado :(");
    }
    public static void voltar(Player player){
        System.out.println("Você sai da escola");
    }
}
