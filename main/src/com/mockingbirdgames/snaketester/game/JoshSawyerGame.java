package com.mockingbirdgames.snaketester.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mockingbirdgames.snaketester.data.GameData;
import com.mockingbirdgames.snaketester.data.YamlData;
import com.mockingbirdgames.snaketester.util.files.AppFileHandleResolver;
import com.mockingbirdgames.snaketester.util.files.loaders.YamlLoader;

/**
 * Created by Jack Kerouac on 21.09.2014.
 */
public class JoshSawyerGame extends Game {

    private boolean dataDisplayed;

    private AssetManager assetManager;

    @Override
    public void create() {
        AppFileHandleResolver resolver = new AppFileHandleResolver();
        assetManager = new AssetManager(resolver);
        assetManager.setLoader(YamlData.class, new YamlLoader(resolver));
        assetManager.load("characters.yml", YamlData.class);
    }

    @Override
    public void render() {
        super.render();
        boolean dataLoaded = assetManager.update();
        if (dataLoaded && !dataDisplayed)
            showData();
    }

    private void showData() {
        dataDisplayed = true;
        GameData.characters = assetManager.get("characters.yml");
        YamlData hangarSupervisor = GameData.characters.get("hangar_supervisor_1");
        if (hangarSupervisor != null)
            System.out.print("What's Hangar supervisor will do if something bad is happening? He will "
                    + hangarSupervisor.get("combat_behavior") + ".");
        else
            System.out.println("Failed to load Hangar supervisor's entity data.");
    }
}
