package animation;

import biuoop.DrawSurface;

/**
 * Animation.
 * @author Yonatan Mevarech-Radai.
 * @version 21/06/2021.
 */
public interface Animation {

    /**
     * doOneFrame
     * display one frame of the Animation.
     * check the conditions of the Animation in order,
     * to change if necessary the running status of the Animation.
     * @param d the DrawSurface of the gui.
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop.
     * alert the AnimationRunner loop to stop Animation if necessary.
     * give a running status of the Animation.
     * @return the running status of the Animation.
     */
    boolean shouldStop();
}
