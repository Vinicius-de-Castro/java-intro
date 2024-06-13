package finisu;

import static finisu.Input.actions;

public class Main {
    public static void main(String[] args) {
        String nome;
        System.out.println("Bem vindo!");
        System.out.println("Antes de começarmos, me diga seu nome:");
        nome = Input.get();
        Player player = new Player(nome);
        System.out.printf("Olá %s!\n", nome);

        while (Loop.jogando) {
            System.out.printf("Hoje é dia %d\n", player.dia);
            System.out.println("O que você quer fazer hoje?");
            actions(player, Loop.opcoesMap);
        }
    }
}
