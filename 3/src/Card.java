/**
 * The Card class have the information of an animal and the card number
 * *
 * @author Erfan
 * @version 1
 * @since 4/3/2018
 */

public class Card extends Animal {


    // Fields //

    // The number of the card
    private int number;

    // Constructors //

    /**
     * Create an Card object with given name and energy and other fields
     * @param name The name of the animal
     * @param energy The energy of the animal
     * @param life The life of the animal
     * @param hurtMethodOne The name of the first hurt method of the animal
     * @param hurtMethod1 The amount of the first hurt method of the animal
     * @param hurtMethodTwo The name of the twice hurt method of the animal
     * @param hurtMethod2  The amount of the twice hurt method of the animal
     * @param maxEnergy The maximum energy of the animal
     */
    public Card(String name, int energy, int life, String hurtMethodOne, int hurtMethod1, String hurtMethodTwo, int hurtMethod2, int maxEnergy) {
        super(name, energy, life, hurtMethodOne, hurtMethod1, hurtMethodTwo, hurtMethod2, maxEnergy);
    }

    /**
     * Create an animal object with given name and energy and other fields
     * @param name The name of the animal
     * @param energy  The energy of the animal
     * @param life The life of the animal
     * @param hurtMethodOne The name of the first hurt method of the animal
     * @param hurtMethod1 The amount of the first hurt method of the animal
     * @param maxEnergy The maximum energy of the animal
     */
    public Card(String name, int energy, int life, String hurtMethodOne, int hurtMethod1, int maxEnergy) {
        super(name, energy, life, hurtMethodOne, hurtMethod1, maxEnergy);
    }

    /**
     * Create an animal object
     */
    public Card() {

    }

    // Methods //

    /**
     * Get the card number
     * @return The card number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set the card number
     * @return The card number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Decrease the energy of the animal
     * @param decrease the energy must decreased
     */
    public void decreaseEnergy(int decrease) {
        setEnergy(energy - decrease);
    }

    /**
     * Increase the energy of the animal to max
     * @return Can set to max or not
     */
    public boolean increaseEnergyToMax() {
        if ( getEnergy() == getMaxEnergy()){
            return false ;
        } else {
            setEnergy(getMaxEnergy());
            return true;
        }
    }

    /**
     *  Decrease the life of the animal
     * @param sum the life must decresed
     * @return The life is positive or not
     */
    public boolean decreaseLife(int sum) {
        //System.out.println("sum = " + sum);
        //setLife(life - sum);
        if (life - sum <= 0) {
            return true;
        } else
            setLife(life - sum);
        return false;
    }

    /**
     * Overrride the toString method
     * @return Card information
     */
    @Override
    public String toString() {
        return ("card number -> " + number + " / " + "name -> " + name + " / " + "energy->" + energy + " / " + "life->" + life + " / " +
                hurtMethodOne + "->" + hurtMethod1 + " / " + hurtMethodTwo + "->" + hurtMethod2);
    }

    /**
     * The tooString method
     * @return Animal information
     */
    public String tooStirng() {
        return super.toString();
    }

    /**
     * Check that two card are equal or not
     * @param object the input object
     * @return cards are equal or not
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Card)) {
            return false;
        }

        Card other = (Card) object;
        return ((name.equals(other.name)) && (energy == other.energy) && (life == other.life) && (hurtMethodOne.equals(other.hurtMethodOne))
                && (hurtMethod1 == other.hurtMethod1) /*&& (hurtMethodTwo.equals(other.hurtMethodTwo)) && (hurtMethod2 == other.hurtMethod2)*/
                && (maxEnergy == other.maxEnergy) && (number == other.number));
    }

}
