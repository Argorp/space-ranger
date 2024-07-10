package com.mygdx.game.session;

import static com.mygdx.game.GameSettings.PLANET_SPAWN_COOL_DOWN;
import static com.mygdx.game.GameSettings.SPACE_SPAWN_COOL_DOWN;

import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.GameSettings;

public class PlanetGameSession extends GameSession {
    private long lastLightningSpawnTime;
    private long lastAlienSpawnTime;

    @Override
    public void startGame() {
        super.startGame();
        coolDown = PLANET_SPAWN_COOL_DOWN;
    }

    @Override
    public boolean victory() {
        return false;
    }

    public boolean shouldSpawnLighting() {
        if (TimeUtils.millis() - lastLightningSpawnTime > (coolDown)) {
            lastLightningSpawnTime = TimeUtils.millis();
            return true;
        }
        return false;
    }

    public boolean shouldSpawnCore() {
        if (TimeUtils.millis() - lastAlienSpawnTime > (coolDown * 2L)) {
            lastAlienSpawnTime = TimeUtils.millis();
            return true;
        }
        return false;
    }
}