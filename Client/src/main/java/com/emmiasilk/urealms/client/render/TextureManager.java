package com.emmiasilk.urealms.client.render;

import com.emmiasilk.urealms.api.logging.Logging;
import com.emmiasilk.urealms.api.util.I18n;

import java.io.File;
import java.util.HashMap;

/**
 * This class is a class. I don't know.
 */
public class TextureManager {

    public static final String[] fileExtensions = {".png", ".jpg", ".jpg", ".gif"};
    /**
     * A special default texture so the program does not crash when loading improper textures.
     */
    private static Texture DEFAULT_TEXTURE;
    private HashMap<String, Texture> textureList;
    private String texturesDirectory = "resources/textures/";

    public TextureManager() {
        textureList = new HashMap<String, Texture>();

        Logging.logDebug(new File(texturesDirectory).getAbsolutePath());


        DEFAULT_TEXTURE = fromKey("default.png");

        // Ensure default texture has successfully loaded
        if (DEFAULT_TEXTURE == null) {
            Logging.logError(I18n.getLocalizedString("client.texture.missing_default"));
        }
    }

    public Texture fromKey(String key) {
        // Texture:
        Texture texture = null;

        // Try to return a texture from the hashmap
        if (textureList.containsKey(key)) {
            return textureList.get(key);
        }

        // Try to create a new texture from the key and add it to the list
        // TODO: Ensure there is a valid path
        String path = texturesDirectory + key;

        texture = Texture.loadTexture(path, 0);

        // If texture does not exist, use the default texture
        if (texture == null) {
            texture = DEFAULT_TEXTURE;
        }
        // Add the texture to the list.
        textureList.put(key, texture);
        return texture;


    }
}
