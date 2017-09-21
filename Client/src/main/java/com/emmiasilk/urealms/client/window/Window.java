package com.emmiasilk.urealms.client.window;

import com.emmiasilk.urealms.client.URealmsClient;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * A wrapper for a GLFW window.
 */
public class Window {

    /**
     * Stores the window handle.
     */
    private final long handle;

    /**
     * Key callback for the window.
     */
    private GLFWKeyCallback keyCallback;

    /**
     * Whether vertical sync is enabled for rendering frames.
     */
    private boolean vsync;

    public Window() {
        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        // Make OpenGL yell at me for doing things in the wrong version of OpenGL.
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
        // Window properties
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the handle
        handle = glfwCreateWindow(800, 600, "Hello World!", NULL, NULL);
        if (handle == NULL)
            throw new RuntimeException("Failed to create the GLFW handle");

        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the handle size passed to glfwCreateWindow
            glfwGetWindowSize(handle, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    handle,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(handle);
        // Enable v-sync
        setVsync(true);

        // Make the window visible
        glfwShowWindow(handle);
    }

    public void update() {
        glfwSwapBuffers(handle); // swap the color buffers
    }

    /**
     * Poll for GLFW window events. The key callback will only be updated
     * during the poll.
     */
    public void poll() {
        // Poll for window events. The key callback above will only be
        // invoked during this call.
        glfwPollEvents();
    }

    public void destroy() {
        glfwFreeCallbacks(handle);
        glfwDestroyWindow(handle);
    }

    public void createCallbacks() {
        // Key callback is called every time a key is pressed.
        keyCallback = glfwSetKeyCallback(handle, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        // Framebuffer Size callback is called every time the window changes size.
        glfwSetFramebufferSizeCallback(handle, (window, width, height) -> URealmsClient.getInstance().getRenderEngine().viewport(width, height));
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(handle);
    }

    public boolean isVsync() {
        return vsync;
    }

    public void setVsync(boolean vsync) {
        this.vsync = vsync;
        if (vsync) {
            glfwSwapInterval(1);
        } else {
            glfwSwapInterval(0);
        }
    }
}
