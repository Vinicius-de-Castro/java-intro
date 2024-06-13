package finisu;

import finisu.interfaces.Evento;
import java.util.HashMap;
import java.util.Scanner;

public class Input {
    public static Scanner scan = new Scanner(System.in);

    public static String get() {
        return scan.nextLine();
    }

    public static void actions(Player player, HashMap<String, Evento> options) {
        System.out.println("Opções:");
        System.out.println(options.keySet());
        String action = get();
        if (options.containsKey(action)) {
            options.get(action).metodo(player);
            if (!action.equals("Voltar") && !action.equals("Parar jogo"))
                actions(player, options);
            else
                System.out.println("----------------------------------------");
        } else {
            System.out.println("Não entendi, pode repetir?");
            actions(player, options);
        }
    }
}
