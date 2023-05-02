import animation.AnimationRunner;
import gameflow.GameFlow;
import levels.levelsInfo.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ass6Game.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public class main {

    /**
     * main.
     * @param args the numbers that are representing the wanted level templates.
     * in their displaying order.
     */
    public static void main(String[] args) {

        AnimationRunner runner = new AnimationRunner();
        GameFlow flow = new GameFlow(runner, runner.getGui().getKeyboardSensor());
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        flow.runLevels(levels);
    }
}

