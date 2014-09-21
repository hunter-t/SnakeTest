package com.mockingbirdgames.snaketester.data;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Jack Kerouac on 21.09.2014.
 */
public class YamlData {

    public final HashMap data;

    public YamlData(HashMap data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public void put(String key, Object value) {
        data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, T defaultValue) {
        Object result = data.get(key);
        if (result == null)
            return defaultValue;
        if (result instanceof HashMap) {
            result = new YamlData((HashMap) result);
            data.put(key, result);
        }
        return (T) result;
    }

    public <T> T get(String key) {
        return get(key, null);
    }

    public boolean has(String key) {
        return data.containsKey(key);
    }

    @SuppressWarnings("unchecked")
    public Set<String> keys() {
        return data.keySet();
    }

    public int size() {
        return data.size();
    }

    public void remove(String key) {
        data.remove(key);
    }

}
