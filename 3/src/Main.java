/**
 * The Main class have the some other classes objects and continue the program
 * *
 * @author Erfan
 * @version 1
 * @since 4/3/2018
 */
public class Main {

    // Method //

    public static void main(String[] args) {

        int i = 0;
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();

        while (!game.isCom()) ;
        if (game.isComputer()) {
            player1.setComp(false);
            player2.setComp(true);
        } else {
            player1.setComp(false);
            player2.setComp(false);
        }

        game.findAppropriateRandNum();
        game.createAnimalNames();
        game.printAnimalInformation();
        game.printcards();

        player1.giveChoosenNumbers(game.getRandNumbers());
        player1.createCarts(game.getRandNumbers());
        player1.printCards("First player cards : ", " ");

        game.findAppropriateRandNum();
        game.printAnimalInformation();
        game.printcards();

        player2.giveChoosenNumbers(game.getRandNumbers());
        player2.createCarts(game.getRandNumbers());
        player2.printCards("Twice player cards :", "Computer cards :");

        while (true) {

            player2.canContinue(player1);

            player1.printCards("First player cards : ", " ");
            player2.printCards("Twice player cards :", "Computer cards :");
            while (!player1.attacking(player1.getAttackInput("First player turn : " , player2), player2)) {
                i++;
                if (i == 6 && !player1.isComp()) {
                    System.out.println();
                    System.out.println("You lose !! ");
                    System.exit(0);
                }
            }
            i = 0;

            player1.canContinue(player2);

            player1.printCards("First player cards : ", " ");
            player2.printCards("Twice player cards :", "Computer cards :");
            while (!player2.attacking(player2.getAttackInput("Twice player turn : " , player1), player1)) {
                i++;
                if (i == 1000 && player2.isComp()) {
                    System.out.println();
                    System.out.println("computer lose ! //");
                    System.exit(0);
                }
                if (i == 6 && !player2.isComp()) {
                    System.out.println();
                    System.out.println("You lose ! ");
                    System.exit(0);
                }
            }
            i = 0;

        }
    }

}
