// Add Random and Scanner calsses
import java.util.Random;
import java.util.Scanner;
/**
 * The Game class have some methods for creating games
 * *
 * @author Erfan
 * @version 1
 * @since 4/3/2018
 */
public class Game {

    // Fields //

    // An object of the Random class
    private Random random = new Random();

    // An array of the random numbers
    protected int randNumbers[];

    // An array of animal names
    private String animalnames[];

    // Is computer or not
    private boolean isComputer ;

    // Constructor //

    /**
     * Create a game object
     */
    public Game() {
        randNumbers = new int[12];
        animalnames = new String[12];
    }

    // Methods //

    /**
     * Get it is computer or not
     * @return It is computer or not
     */
    public boolean isComputer() {
        return isComputer;
    }

    /**
     * Get that start the game with computer or not
     * @return Start the game with computer or not
     */
    public boolean isCom (){
        String string ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] Play with computer .");
        System.out.println("[2] Play two player .");
        string = scanner.nextLine();
        if ( string.length() == 1 && ( string.charAt(0) == '1' || string.charAt(0) == '2') ){
            if (string.charAt(0) == '1' ){
                isComputer = true;
            }
            if (string.charAt(0) == '2' ){
                isComputer = false;
            }
            return true;
        }
        else {
            System.out.println("wrong input");
            return false;
        }
    }

    /**
     * Create all existed animal object
     * @param index Create which animal
     * @return The Created card
     */
    public Card createCardObjects(int index) {
        if (index == 1) {
            Card lion = new Card("lion", 1000, 900, "injure", 150, "kill", 500, 1000);
            return lion;
        }
        if (index == 2) {
            Card bear = new Card("bear", 900, 850, "injure", 130, "kill", 600, 900);
            return bear;
        }
        if (index == 3) {
            Card tiger = new Card("tiger", 850, 850, "injure", 120, "kill", 650, 850);
            return tiger;
        }
        if (index == 4) {
            Card vulture = new Card("vulture", 600, 350, "injure", 100, 600);
            return vulture;
        }
        if (index == 5) {
            Card fox = new Card("fox", 600, 400, "injure", 90, 600);
            return fox;
        }
        if (index == 6) {
            Card elephant = new Card("elephant", 500, 1200, "hurt", 70, "attack", 50, 500);
            return elephant;
        }
        if (index == 7) {
            Card wolf = new Card("wolf", 700, 450, "kill", 700, 700);
            return wolf;
        }
        if (index == 8) {
            Card boar = new Card("boar", 500, 1100, "hurt", 80, 500);
            return boar;
        }
        if (index == 9) {
            Card hippopotamus = new Card("hippopotamus", 360, 1000, "attack", 110, 360);
            return hippopotamus;
        }
        if (index == 10) {
            Card cow = new Card("cow", 400, 750, "attack", 90, "injure", 100, 400);
            return cow;
        }
        if (index == 11) {
            Card rabbit = new Card("rabbit", 350, 200, "bite", 80, 350);
            return rabbit;
        }
        if (index == 12) {
            Card turtle = new Card("turtle", 230, 350, "bite", 200, 230);
            return turtle;
        }
        return null;
    }

    /**
     * Create animal names objects
     */
    public void createAnimalNames() {
        for (int i = 0; i < 12; i++) {
            animalnames[i] = createCardObjects(i + 1).getName();
        }
    }

    /**
     * Find random number between 0 to 5
     * @return The random number
     */
    public int findRandnNum() {
        return Math.abs(random.nextInt() % 6);
    }

    /**
     * find the appropriate random number for computer
     */
    public void findAppropriateRandNum() {
        while (true) {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                randNumbers[i] = findRandnNum();
                sum += randNumbers[i];
            }
            if (sum == 30) {
                break;
            }
        }
    }

    /**
     * Print existed cards
     */
    public void printcards() {
        int k = 1;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < randNumbers[i]; j++) {
                System.out.println(k + "-" + animalnames[i]);
                k++;
            }
        }
    }

    /**
     * Print Animal Information
     */
    public void printAnimalInformation() {
        System.out.println();
        System.out.println("Animal Information ");
        System.out.println();
        System.out.println();
        for (int i = 0; i < 12; i++) {
            System.out.println(createCardObjects(i + 1).tooStirng());
        }
        System.out.println();
        System.out.println();
        System.out.println("Choose 10 card from these 30 card ");
        System.out.println();
        System.out.println();
    }

    /**
     * Get the random numbers array
     * @return The random numbers array
     */
    public int[] getRandNumbers() {
        return randNumbers;
    }




}
