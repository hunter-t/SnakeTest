package com.mockingbirdgames.snaketester.util.files;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by Jack Kerouac on 21.09.2014.
 */
public class AppFileHandleResolver implements FileHandleResolver {

    @Override
    public FileHandle resolve(String fileName) {
        return FileHelper.get(fileName);
    }

}