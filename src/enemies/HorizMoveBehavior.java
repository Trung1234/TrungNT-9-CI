package enemies;

import models.GameRect;

/**
 * Created by My PC on 29/04/2017.
 */
public class HorizMoveBehavior implements MoveBehavior{
    @Override
    public void move(GameRect gameRect) {
        gameRect.move(3,3);
    }
}
