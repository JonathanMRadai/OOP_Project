package gameobjects.listener;
/**
 * GameObjects.listener.HitNotifier.
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl .
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events .
     * @param hl .
     */
    void removeHitListener(HitListener hl);

}
