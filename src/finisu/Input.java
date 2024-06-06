package finisu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Input {
    public static String get(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public static void actions(Player player, HashMap<String, Evento> options){
        System.out.println("Opções:");
        System.out.println(options.keySet());
        String action = get();
        if (options.containsKey(action)){
            options.get(action).metodo(player);
            if (!action.equals("Voltar") && !action.equals("Parar jogo")) actions(player, options);
            else System.out.println("----------------------------------------");
        }
        else{
            System.out.println("Não entendi, pode repetir?");
            actions(player, options);
        }
    }
}
