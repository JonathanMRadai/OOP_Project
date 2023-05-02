package gameobjects.listener;
/**
 * GameObjects.listener.Counter.
 * counts .
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class Counter {

    private int counter;

    /**
     * contractor .
     * @param number .
     */
    public Counter(int number) {
        this.counter = number;
    }
    /**
     * increase .
     * add number to current count .
     * @param number .
     */
    public void increase(int number) {

        this.counter = this.counter + number;
    }
    /**
     * increase .
     * subtract number from current count .
     * @param number .
     */
    public void decrease(int number) {

        this.counter = this.counter - number;
    }
    /**
     * getter .
     * @return counter .
     */
    public int getValue() {

        return counter;
    }
}