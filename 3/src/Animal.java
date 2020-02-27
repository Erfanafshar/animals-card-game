/**
 * The Animal class have the information of an animal
 * *
 * @author Erfan
 * @version 1
 * @since 4/3/2018
 */
public class Animal {

    // Fields //

    // The name of the animal
    protected String name ;

    // The energy of the animal
    protected int energy ;

    // The life of the animal
    protected int life ;

    // The name of the first hurt method of the animal
    protected String hurtMethodOne ;

    // The amount of the first hurt method of the animal
    protected int hurtMethod1 ;

    // The name of the twice hurt method of the animal
    protected String hurtMethodTwo ;

    // The amount of the twice hurt method of the animal
    protected int hurtMethod2 ;

    // The maximum energy of the animal
    protected int maxEnergy ;

    // Constructors //

    /**
     * Create an animal object with given name and energy and other fields
     * @param name The name of the animal
     * @param energy The energy of the animal
     * @param life The life of the animal
     * @param hurtMethodOne The name of the first hurt method of the animal
     * @param hurtMethod1 The amount of the first hurt method of the animal
     * @param hurtMethodTwo The name of the twice hurt method of the animal
     * @param hurtMethod2  The amount of the twice hurt method of the animal
     * @param maxEnergy The maximum energy of the animal
     */
    public Animal(String name, int energy, int life, String hurtMethodOne, int hurtMethod1, String hurtMethodTwo, int hurtMethod2, int maxEnergy) {
        this.name = name;
        this.energy = energy;
        this.life = life;
        this.hurtMethodOne = hurtMethodOne;
        this.hurtMethod1 = hurtMethod1;
        this.hurtMethodTwo = hurtMethodTwo;
        this.hurtMethod2 = hurtMethod2;
        this.maxEnergy = maxEnergy;
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
    public Animal(String name, int energy, int life, String hurtMethodOne, int hurtMethod1 , int maxEnergy) {
        this.name = name;
        this.energy = energy;
        this.life = life;
        this.hurtMethodOne = hurtMethodOne;
        this.hurtMethod1 = hurtMethod1;
        this.maxEnergy = maxEnergy;
    }

    /**
     * Create an animal object
     */
    public Animal() {

    }

    // Methods //

    /**
     * Get the name of the animal
     * @return The name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     *  Set the name of the animal
     * @param name The name of the animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the energy of the animal
     * @return The energy of the animal
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Set the energy of the animal
     * @param energy The energy of the animal
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Get the life of the animal
     * @return The life of the animal
     */
    public int getLife() {
        return life;
    }

    /**
     * Set the life of the animal
     * @param life  The life of the animal
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Get the first hurt method of the animal
     * @return The first hurt method of the animal
     */
    public String getHurtMethodOne() {
        return hurtMethodOne;
    }

    /**
     * Set the first hurt method of the animal
     * @return The first hurt method of the animal
     */
    public void setHurtMethodOne(String hurtMethodOne) {
        this.hurtMethodOne = hurtMethodOne;
    }

    /**
     * Get the amount of first hurt method of the animal
     * @return The amount of first hurt method of the animal
     */
    public int getHurtMethod1() {
        return hurtMethod1;
    }

    /**
     * Set the amount of first hurt method of the animal
     * @param hurtMethod1 The amount of first hurt method of the animal
     */
    public void setHurtMethod1(int hurtMethod1) {
        this.hurtMethod1 = hurtMethod1;
    }

    /**
     * Get the twice hurt method of the animal
     * @return The twice hurt method of the animal
     */
    public String getHurtMethodTwo() {
        return hurtMethodTwo;
    }

    /**
     * Set the twice hurt method of the animal
     * @return The twice hurt method of the animal
     */
    public void setHurtMethodTwo(String hurtMethodTwo) {
        this.hurtMethodTwo = hurtMethodTwo;
    }

    /**
     * Get the amount of twice hurt method of the animal
     * @return The amount of twice hurt method of the animal
     */
    public int getHurtMethod2() {
        return hurtMethod2;
    }

    /**
     * Set the amount of twice hurt method of the animal
     * @return The amount of twice hurt method of the animal
     */
    public void setHurtMethod2(int hurtMethod2) {
        this.hurtMethod2 = hurtMethod2;
    }

    /**
     * Set the max energy of the animal
     * @return The max energy of the animal
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Overrride the toString method
     * @return Animal information
     */
    @Override
    public String toString() {
        return ("name->" + name + " / " + "energy->" + energy + " / " + "life->" + life + " / " +
                hurtMethodOne + "->" + hurtMethod1 + " / " + hurtMethodTwo + "->" + hurtMethod2 );
    }

}
