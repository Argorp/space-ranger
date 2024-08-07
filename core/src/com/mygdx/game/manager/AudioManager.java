package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameResources;

public class AudioManager {
    public Music spaceMusic;
    public Sound soundBullet;
    public Sound soundBoom;
    public Sound soundEnergyGive;
    public Music menuMusic;
    public Music planetMusic;


    public AudioManager() {
        spaceMusic = Gdx.audio.newMusic(Gdx.files.internal(GameResources.MUSIC_SPACE_PATH));
        soundBullet = Gdx.audio.newSound(Gdx.files.internal(GameResources.SOUND_BULLET_PATH));
        soundBoom = Gdx.audio.newSound(Gdx.files.internal(GameResources.SOUND_BOOM_PATH));
        soundEnergyGive = Gdx.audio.newSound(Gdx.files.internal(GameResources.SOUND_ENERGY_PATH));
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal(GameResources.MUSIC_MENU_PATH));
        planetMusic = Gdx.audio.newMusic(Gdx.files.internal(GameResources.MUSIC_PLANET_PATH));

        spaceMusic.setVolume(0.2f);
        menuMusic.setVolume(0.2f);
        planetMusic.setVolume(0.2f);

        spaceMusic.setLooping(true);
        menuMusic.setLooping(true);
        planetMusic.setLooping(true);

        menuMusic.play();
    }


}
