package com.mockingbirdgames.snaketester.util.files;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * This helper class has only one static method that returns a {@link com.badlogic.gdx.files.FileHandle}
 * of specified file name.
 */
public class FileHelper {

    public static FileHandle get(String filename) {
        FileHandle result;

        result = Gdx.files.local("/data/" + filename);
        if (result.exists()) return result;

        result = Gdx.files.internal(filename);
        if (result.exists()) return result;

        throw new IllegalStateException("Can not find file " + filename + " in Android asset folder or in local folder.");
    }
}
