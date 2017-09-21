package com.emmiasilk.urealms.client;

import com.emmiasilk.urealms.api.logging.Logging;
import com.emmiasilk.urealms.api.util.I18n;
import com.emmiasilk.urealms.client.render.RenderEngine;
import com.emmiasilk.urealms.client.window.Window;
import com.emmiasilk.urealms.core.util.StepTimer;
import com.emmiasilk.urealms.core.world.GameWorld;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Represents the client itself
 *
 * @since 0.0.1
 */
public class URealmsClient {

    /**
     * Instance of the client.
     */
    private static URealmsClient instance;

    /**
     * Wrapper for the GLFW window.
     */
    private Window window;
    private GameWorld gameWorld;
    /**
     * Handler for OpenGL rendering.
     */
    private RenderEngine renderEngine;

    /**
     * Timer for tracking the length of a frame.
     */
    private StepTimer fpsTimer;

    URealmsClient() {
        instance = this;
    }

    /**
     * Get the instance of the client.
     *
     * @return the instance of the client.
     */
    public static URealmsClient getInstance() {
        return instance;
    }

    void run() {
        Logging.logInfo("LWJGL version " + Version.getVersion() + "");
        init();
        loop();

        // Free the window callbacks and destroy the window
        window.destroy();

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        window = new Window();
        //gameWorld = ClientOutsourcing.createInitialGameWorld();
        renderEngine = new RenderEngine();

        window.createCallbacks();

        fpsTimer = new StepTimer();
    }

    private void loop() {
        // Number of times we expect this loop to go through each second
        final double TARGET_FPS = 60.0;
        final double OPTIMAL_TIME = StepTimer.NANOS_IN_SECOND / TARGET_FPS;

        // Timer should be set for the moment the loop starts.
        fpsTimer.set();

        while (!window.shouldClose()) {
            float timeStep = (float) (fpsTimer.getLastTickLength() / OPTIMAL_TIME);
            ClientOutsourcing.debugFPS(fpsTimer.getLastTickLength());

            // Check input
            window.poll();
            // Update game logic
            gameWorld.step(timeStep);
            // Draw
            renderEngine.draw();
            window.update();

            // Limiting FPS to 60fps
            try {
                long nanos = (long) OPTIMAL_TIME + fpsTimer.getLastTickTime() - System.nanoTime();
                if (nanos > 0 && window.isVsync()) {
                    Thread.sleep(nanos / StepTimer.NANOS_IN_MILLISECOND);
                } else {
                    Thread.sleep(0);
                }
            } catch (InterruptedException exception) {
                Logging.logError(I18n.getLocalizedString("client.loopException"), exception);
                break;
            }

            // Tick the frame timer
            fpsTimer.tick();
        }
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public RenderEngine getRenderEngine() {
        return renderEngine;
    }

}
