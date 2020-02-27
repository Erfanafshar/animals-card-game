// Add ArrrayList and Scanner and Random classes
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 * The Player class have the information of an player
 * Like his cards and his input attack
 * *
 * @author Erfan
 * @version 1
 * @since 4/3/2018
 */
public class Player extends Game {

    // Fields //

    // An array list of player cards
    private ArrayList<Card> cards;

    // An array list of choosen numbers
    private int[] choosenNumbers;

    // An object of Scanner class for getting input
    private Scanner scanner = new Scanner(System.in);

    // An array list that contain each attack input
    private String[] attack;

    // Is input S or not
    private boolean isS = false;

    // The size of the cards array
    private int cardsSize = 10;

    // How many times EnergyToMax used
    private int useEnergyToMax = 0;

    // This player is computer or not
    private boolean isComp;

    // Constructor //

    /**
     * Create a player object
     */
    public Player() {
        cards = new ArrayList<Card>();
        choosenNumbers = new int[10];
        attack = new String[10];
    }

    // Methods //

    /**
     * Get this player is computer or not
     * @return This player is computer or not
     */
    public boolean isComp() {
        return isComp;
    }

    /**
     * Set this player is computer or not
     * @param comp This player is computer or not
     */
    public void setComp(boolean comp) {
        isComp = comp;
    }

    /**
     * Get the cards array size
     * @return The cards array size
     */
    public int getCardsSize() {
        return cardsSize;
    }

    /**
     * Set the cards array size
     * @return The cards array size
     */
    public void setCardsSize(int cardsSize) {
        this.cardsSize = cardsSize;
    }

    /**
     * Add a card in cards array
     * @param card the added card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card from array
     * @param cardNumber the removed array
     */
    public void removeCard(int cardNumber) {
        Card card = new Card();
        card = getCardFromNumber(cardNumber);
        for (int i = 0; i < cardsSize; i++) {
            if (cards.get(i).equals(card)) {
                cards.remove(i);
                return;
            }
        }
        if (!isComp) {
            System.out.println("card not found ");
        }
    }

    /**
     * Get the card
     * @param index The index of the card
     * @return the card
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * get cards array
     * @return cards array
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Get the input numbers
     * @return The input
     */
    public int getInputNumbers() {
        while (true) {
            String string;
            string = scanner.nextLine();
            if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
                return Character.getNumericValue(string.charAt(0));
            } else {
                if (string.length() == 2 && Character.isDigit(string.charAt(0)) && Character.isDigit(string.charAt(1))) {
                    return (10 * Character.getNumericValue(string.charAt(0)) + Character.getNumericValue(string.charAt(1)));
                } else {
                    System.out.println("Wrong input .");
                }
            }

        }
    }

    public int[] findSmartCard(int[] randNums) {
        int a = 0;
        int k = 0;
        int numbers[] = new int[10];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < randNums[i]; j++) {
                a++;
                if (i == 0 || i == 1 || i == 2 || i == 6 || i == 7 || i == 8) {
                    if (k < 10) {
                        numbers[k] = a;
                        k++;
                    }
                }
            }
        }
        return numbers;
    }

    public void giveChoosenNumbers(int randNums[]) {
        int a;
        int[] numbers;
        numbers = findSmartCard(randNums);
        for (int i = 0; i < 10; i++) {
            if (isComp) {
                a = numbers[i];
            } else {
                a = getInputNumbers();
            }
            if (!checkRepeat(a)) {
                if (0 < a && a <= 30) {
                    choosenNumbers[i] = a;
                } else {
                    if (!isComp) {
                        System.out.println("Out of range .");
                    }
                    i--;
                }
            } else {
                if (!isComp) {
                    System.out.println("You choose this number later .");
                }
                i--;
            }
        }
    }

    public boolean checkRepeat(int check) {
        for (int i = 0; i < 10; i++) {
            if (check == choosenNumbers[i]) {
                return true;
            }
        }
        return false;
    }

    public int findRandNum1() {
        Random random = new Random();
        return Math.abs((random.nextInt() % 30) + 1);

    }

    public void createCarts(int randNums[]) {
        Card card = new Card();
        int index = 0;
        int t = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < randNums[i]; j++) {
                t++;
                for (int k = 0; k < 10; k++) {
                    if (choosenNumbers[k] == t) {
                        card = createCardObjects(i + 1);
                        index++;
                        card.setNumber(index);
                        addCard(card);
                    }
                }
            }
        }
    }

    public void printCards(String string1, String string2) {
        System.out.println();
        if (isComp) {
            System.out.println(string2);
        } else {
            System.out.println(string1);
        }
        System.out.println();
        for (int i = 0; i < cardsSize; i++) {
            System.out.println(getCard(i));
        }
    }

    public boolean smartChoose(int attackerNumber, Player player) {
        String [] attack2 = new String[10];
        attack2[0] = "K";
        if (cards.get(attackerNumber).getHurtMethod2() > 400 && cards.get(attackerNumber).getEnergy() > cards.get(attackerNumber).getHurtMethod2()) {
            attack2[1] = Integer.toString(cards.get(attackerNumber).getNumber());
        } else {
            return false;
        }
        attack2[2] = "S";
        for (int i = 0; i < player.getCardsSize(); i++){
            if (player.getCards().get(i).getLife() < getCardFromNumber(Integer.valueOf(attack2[1])).getHurtMethod2()) {
                attack2[3] = Integer.toString(player.getCards().get(i).getNumber());
                attack = attack2 ;
                return true;
            }
        }
        return false;
    }

    public int getAttackInput(String string1, Player player) {
        boolean isLast = false;
        boolean isFirst = false;
        int i = 0;
        if (!isComp) {
            System.out.println();
            System.out.println(string1);
            System.out.println();
        }

        if (isComp) {
            for (int j = 0; j < cardsSize; j++) {
                if(smartChoose(j, player)){
                    return 4 ;
                }
            }
        }

        while (!checkFirstAttackLetters(i)) ;
        if (attack[0].equals("N")) {
            isS = true;
        } else {
            while (true) {
                i++;
                if (i == 1) {
                    isFirst = true;
                } else {
                    isFirst = false;
                }
                if (i == 8) {
                    if (!isComp) {
                        System.out.println("bad input");
                        System.out.println("enter the opponents card number :");
                    }
                    attack[i] = "S";
                    isS = true;
                    break;
                }
                while (!checkAttackNumbers(i, isLast, isFirst)) ;
                if (isS) {
                    break;
                }
            }
        }

        if (isS) {
            isS = false;
            isLast = true;
            while (!checkAttackNumbers((i + 1), isLast, isFirst)) ;
        }
        return (i + 2);
    }

    public void printAttack(int j) {
        for (int i = 0; i < j; i++) {
            System.out.println(attack[i]);
        }

    }

    public String findRandAttackLetter() {
        Random random = new Random();
        int rand;
        rand = Math.abs(random.nextInt() % 6);
        if (rand == 0)
            return "I";
        if (rand == 1)
            return "K";
        if (rand == 2)
            return "H";
        if (rand == 3)
            return "A";
        if (rand == 4)
            return "B";
        if (rand == 5)
            return "N";
        return "O";
    }

    public boolean checkFirstAttackLetters(int i) {
        String string;
        if (isComp) {
            string = findRandAttackLetter();
        } else {
            string = scanner.nextLine();
        }
        if (!string.isEmpty()) {
            if ((string.length() == 1) && (string.charAt(0) == 'I' || string.charAt(0) == 'K' || string.charAt(0) == 'H' ||
                    string.charAt(0) == 'A' || string.charAt(0) == 'B' || string.charAt(0) == 'N')) {
                attack[i] = string;
                return true;
            } else {
                if (!isComp) {
                    System.out.println("wrong .");
                }
                return false;
            }
        } else {
            if (!isComp) {
                System.out.println("wrong ...");
            }
            return false;
        }
    }

    public String randAttackNumber(boolean isFirst, boolean isLast) {
        Random random = new Random();
        int a;
        if (isFirst || isLast) {
            while (true) {
                a = Math.abs((random.nextInt() % 10) + 1);
                if (isFirst) {
                    if (cardNumberIsValid(a)) {
                        break;
                    }
                }
                if (isLast) {
                    break;
                }
            }
        } else {
            while (true) {
                a = Math.abs((random.nextInt() % 20) + 1);
                if (a > 10) {
                    return "S";
                }
                if (cardNumberIsValid(a)) {
                    break;
                }
            }
        }
        return Integer.toString(a);
    }

    public boolean checkAttackNumbers(int i, boolean isLast, boolean isFirst) {
        String string;

        if (isComp) {
            string = randAttackNumber(isFirst, isLast);
        } else {
            string = scanner.nextLine();
        }

        if (string.length() == 1 && Character.isDigit(string.charAt(0)) && string.charAt(0) != '0') {
            attack[i] = string;
            return true;
        } else {
            if (string.length() == 2 && string.charAt(0) == '1' && string.charAt(1) == '0') {
                attack[i] = string;
                return true;
            } else {
                if (string.length() == 1 && string.charAt(0) == 'S' && !isLast && !isFirst) {
                    isS = true;
                    attack[i] = string;
                    return true;
                } else {
                    if (!isComp) {
                        System.out.println("wrong !");
                    }
                    return false;
                }
            }
        }
    }

    public Card getCardFromNumber(int index) {
        for (int i = 0; i < cardsSize; i++) {
            if (cards.get(i).getNumber() == index) {
                return cards.get(i);
            }
        }
        return null;
    }

    public boolean cardNumberIsValid(int cardNumber) {
        for (int i = 0; i < cardsSize; i++) {
            if (cards.get(i).getNumber() == cardNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean numberAreValid(int size) {
        for (int i = 1; i < size - 2; i++) {
            if (!cardNumberIsValid(Integer.valueOf(attack[i]))) {
                return false;
            }
        }
        return true;
    }

    public boolean attacking(int size, Player player) {
        int a = 0;
        int sum = 0;
        int avarege ;
        if (attack[0].equals("N")) {
            if (!cardNumberIsValid(Integer.valueOf(attack[size - 1]))) {
                if (!isComp) {
                    System.out.println("one card number isnt available .");
                }
                return false;
            }
            if (useEnergyToMax == 3) {
                if (!isComp) {
                    System.out.println("You use Max energy 3 times !!");
                }
                return false;
            }
            if (!getCardFromNumber(Integer.valueOf(attack[size - 1])).increaseEnergyToMax()) {
                if (!isComp) {
                    System.out.println("This animal energy is full ]");
                    return false;
                }
            }
            useEnergyToMax++;
            printComputerChoices(size);
            return true;
        }

        if (!(numberAreValid(size) && player.cardNumberIsValid(Integer.valueOf(attack[size - 1])))) {
            if (!isComp) {
                System.out.println("one card number isnt available .");
            }
            return false;
        }

        for (int i = 1; i < size - 2; i++) {
            if (!(getAttackModel(attack[0]).equals(getCardFromNumber(Integer.valueOf(attack[i])).getHurtMethodOne())
                    || getAttackModel(attack[0]).equals(getCardFromNumber(Integer.valueOf(attack[i])).getHurtMethodTwo()))) {
                if (!isComp) {
                    System.out.println("wrong hurt method .");
                }
                return false;
            }
        }
        for (int i = 1; i < size - 2; i++) {
            if (getAttackModel(attack[0]).equals(getCardFromNumber(Integer.valueOf(attack[i])).getHurtMethodOne())) {
                a = getCardFromNumber(Integer.valueOf(attack[i])).getHurtMethod1();
            } else {
                if (getAttackModel(attack[0]).equals(getCardFromNumber(Integer.valueOf(attack[i])).getHurtMethodTwo())) {
                    a = getCardFromNumber(Integer.valueOf(attack[i])).getHurtMethod2();
                }
            }
            sum += a;
        }

        avarege = sum / (size - 3);

        for (int i = 1; i < size - 2; i++) {
            if (getCardFromNumber(Integer.valueOf(attack[i])).getEnergy() - avarege < 0) {
                if (!isComp) {
                    System.out.println("One of the animals energy is under zero .");
                }
                return false;
            }
        }
        for (int i = 1; i < size - 2; i++) {
            getCardFromNumber(Integer.valueOf(attack[i])).decreaseEnergy(avarege);
        }

        if (player.getCardFromNumber(Integer.valueOf(attack[size - 1])).decreaseLife(sum)) {
            player.removeCard(Integer.valueOf(attack[size - 1]));
            player.setCardsSize(player.getCardsSize() - 1);
        }

        if (player.getCardsSize() == 0) {
            System.out.println();
            if (!isComp) {
                System.out.println("You win !! ");
            } else {
                System.out.println("you lose !!");
            }
            System.exit(0);
        }
        printComputerChoices(size);
        return true;

    }

    private void printComputerChoices(int size) {
        if (isComp) {
            System.out.println();
            System.out.println("Computer turn ");
            System.out.println();
            printAttack(size);
        }
    }

    public String getAttackModel(String string) {
        if (string.charAt(0) == 'I') {
            return "injure";
        }
        if (string.charAt(0) == 'K') {
            return "kill";
        }
        if (string.charAt(0) == 'H') {
            return "hurt";
        }
        if (string.charAt(0) == 'A') {
            return "attack";
        }
        if (string.charAt(0) == 'B') {
            return "bite";
        }
        if (string.charAt(0) == 'N') {
            return "no";
        }
        return " ";
    }

    public void canContinue(Player player) {
        boolean firstLose = false;
        boolean twiceLose = false;
        for (int i = 0; i < cardsSize; i++) {
            if (cards.get(i).getHurtMethod1() < cards.get(i).getEnergy()) {
                firstLose = true;
            }
        }
        for (int i = 0; i < player.getCardsSize(); i++) {
            if (player.getCards().get(i).getHurtMethod1() < player.getCards().get(i).getEnergy()) {
                twiceLose = true;
            }
        }

        if (!firstLose && !twiceLose) {
            System.out.println("draw .!!");
            System.exit(0);
        }
        if (!firstLose && twiceLose) {
            System.out.println("you lose .!!");
            System.exit(0);
        }
    }

}

