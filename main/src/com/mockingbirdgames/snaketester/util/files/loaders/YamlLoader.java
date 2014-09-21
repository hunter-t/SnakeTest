package com.mockingbirdgames.snaketester.util.files.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.mockingbirdgames.snaketester.data.YamlData;
import org.yaml.snakeyaml.Yaml;

import java.io.StringReader;
import java.util.HashMap;

/**
 * Created by Jack Kerouac on 21.09.2014.
 */
public class YamlLoader extends AsynchronousAssetLoader<YamlData, AssetLoaderParameters<YamlData>> {

    private YamlData data;

    public YamlLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, AssetLoaderParameters<YamlData> parameter) {
        data = null;
        String str = new String(resolve(fileName).readBytes());
        HashMap raw = (HashMap) new Yaml().load(new StringReader(str));
        data = new YamlData(raw);
    }

    @Override
    public YamlData loadSync(AssetManager manager, String fileName, FileHandle file, AssetLoaderParameters<YamlData> parameter) {
        return data;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AssetLoaderParameters<YamlData> parameter) {
        return null;
    }
}
