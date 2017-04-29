package enemies;

import models.GameRect;

/**
 * Created by My PC on 29/04/2017.
 */
public interface Collider {
    GameRect getGameRect();
    void onCollide(Collider other);
}
