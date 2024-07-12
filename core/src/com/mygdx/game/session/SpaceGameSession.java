package com.mygdx.game.session;

import com.mygdx.game.GameSettings;
import com.mygdx.game.screens.SpaceGameScreen;

public class SpaceGameSession extends GameSession {
    private int core_collected;

    @Override
    public void startGame() {
        super.startGame();
        core_collected = 0;
        coolDown = GameSettings.SPACE_SPAWN_COOL_DOWN;
    }

    public void core_was_collected() {
        core_collected += 1;
    }

    public int getCoreCollected() {
        return core_collected;
    }

    @Override
    public boolean victory() {
        return core_collected >= 3;
    }
}
