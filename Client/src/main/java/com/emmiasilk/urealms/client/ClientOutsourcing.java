package com.emmiasilk.urealms.client;

import com.emmiasilk.urealms.api.logging.Logging;
import com.emmiasilk.urealms.core.util.StepTimer;
import com.emmiasilk.urealms.core.world.GameWorld;
import org.lwjgl.opengl.GL11;

/**
 * @deprecated
 */
public class ClientOutsourcing {


    private static long thisSecond = 0;
    private static long frames = 0;

    static GameWorld createInitialGameWorld() {
        Logging.logDebug("DEBUG: Creating initial game world");
        GameWorld g = new GameWorld();

        return g;
    }

    /**
     * @param lastTick The length of the last tick in milliseconds.
     */
    static void debugFPS(Long lastTick) {
        thisSecond += lastTick;
        frames += 1;

        if (thisSecond >= StepTimer.NANOS_IN_SECOND) {
            //Logging.logDebug("FPS: " + frames);
            frames = 0;
            thisSecond -= StepTimer.NANOS_IN_SECOND;
        }
    }

    /**
     * @param fovy
     * @param aspect
     * @param zNear
     * @param zFar
     */
    public static void perspective(float fovy, float aspect, float zNear, float zFar) {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        float fieldHeight = (float) Math.tan(Math.toRadians(fovy) * zNear);
        float fieldWidth = fieldHeight * aspect;
        GL11.glFrustum(-fieldWidth, fieldWidth, -fieldHeight, fieldHeight, zNear, zFar);
    }

}
