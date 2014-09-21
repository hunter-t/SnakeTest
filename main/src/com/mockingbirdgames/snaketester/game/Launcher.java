package com.mockingbirdgames.snaketester.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created by Jack Kerouac on 21.09.2014.
 */
public class Launcher {

    public static void main(String[] args) {
        new LwjglApplication(new JoshSawyerGame(), new LwjglApplicationConfiguration());
    }

}
