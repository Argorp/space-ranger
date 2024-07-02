package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.GameSettings;
import com.mygdx.game.Type;

import java.util.Random;

public class ShipObject extends GameObject{
    int livesLeft;
    Sprite sprite;
    Random random = new Random();

    public long lastShotTime;

    public float shot_cool_down;

    public ShipObject(int x, int y, int wight, int height, String texturePath, World world) {
        super(texturePath, x, y, wight, height, world);
        livesLeft = 3;
        body.setLinearDamping(10);
        sprite = new Sprite(texture);
        sprite.setOrigin(wight / 2f, height / 2f);
        shot_cool_down = GameSettings.SHOOTING_COOL_DOWN;
    }

    public void move() {
        if (22.5 > getRotation() % 360 || getRotation() % 360 > 337.5) {
            setY(getY() + GameSettings.SPEED_SHIP);
        } else if (337.5 > getRotation() % 360 && getRotation() % 360 > 292.5) {
            setY(getY() + GameSettings.SPEED_SHIP);
            setX(getX() + GameSettings.SPEED_SHIP);
        }else if (292.5 > getRotation() % 360 && getRotation() % 360 > 247.5) {
            setX(getX() + GameSettings.SPEED_SHIP);
        }else if (247.5 > getRotation() % 360 && getRotation() % 360 > 202.5) {
            setY(getY() - GameSettings.SPEED_SHIP);
            setX(getX() + GameSettings.SPEED_SHIP);
        }else if (202.5 > getRotation() % 360 && getRotation() % 360 > 157.5) {
            setY(getY() - GameSettings.SPEED_SHIP);
        }else if (157.5 > getRotation() % 360 && getRotation() % 360 > 112.5) {
            setY(getY() - GameSettings.SPEED_SHIP);
            setX(getX() - GameSettings.SPEED_SHIP);
        }else if (112.5 > getRotation() % 360 && getRotation() % 360 > 67.5) {
            setX(getX() - GameSettings.SPEED_SHIP);
        }else if (67.5 > getRotation() % 360 && getRotation() % 360 > 22.5) {
            setY(getY() + GameSettings.SPEED_SHIP);
            setX(getX() - GameSettings.SPEED_SHIP);
        }

       System.out.println(getRotation() % 360);


    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setBounds(getX() - width / 2f, getY() - height / 2f, width, height);
        sprite.draw(batch);
    }

    public boolean needToShoot() {
        if (TimeUtils.millis() - lastShotTime >= shot_cool_down) {
            lastShotTime = TimeUtils.millis();
            return true;
        }
        return false;
    }

    @Override
    public void hit(Type type) {
        if (type == Type.Enemy) {
            livesLeft -= 1;
        }
    }

    public float getRotation() {
        return sprite.getRotation() + 90;
    }

    public void setRotation(float degrees) {
        sprite.setRotation(degrees);
    }

    public Type type() {
        return  Type.Ship;
    }

    @Override
    public void draw() {

    }

    public boolean isAlive() {
        return  livesLeft > 0;
    }
}
