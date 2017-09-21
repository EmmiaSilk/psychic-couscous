package com.emmiasilk.urealms.client.render;

import com.emmiasilk.urealms.api.logging.Logging;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.*;

import static org.lwjgl.opengl.GL11.*;

public class RenderEngine {

    // TODO: Generate vertices and faces from models
    private static float[] defaultVertices = new float[]{
            // Positions            // Colors           // Texture coords
            0.5f, -0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, // Top right
            0.5f, 0.5f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, // Bottom right
            -0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, // Bottom left
            -0.5f, -0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, // Top left
    };
    private static int[] defaultIndices = new int[]{
            0, 1, 3,    // First triangle
            1, 2, 3,
    };
    // Managers
    private TextureManager textureManager;
    // Temporary objects that will be put in managers in the future
    private ShaderProgram program;
    // private someWorldGameObject
    // Model definition
    private VertexArrayObject vao;
    private VertexBufferObject vbo; // Vertex data
    private ElementBufferObject ebo; // Face definitions
    // Textures used by objects
    private Texture texture0;
    private Texture texture1;

    public RenderEngine() {
        GL.createCapabilities();

        //viewport(800, 600);

        createBufferObjects();
        createTextures();
        createShaders();
    }

    /**
     * Draw things!
     */
    public void draw() {
        // Clear
        glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

        // Temp
        double time = GLFW.glfwGetTime();
        float x = (float) (Math.sin(time) / 2.0f);
        float y = (float) (Math.cos(time) / 2.0f);

        // Draw
        program.use();
        program.setFloat4fv("offset", new float[]{x, y, 0.0f, 0.0f});
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        texture0.bindTo(0);
        texture1.bindTo(1);

        vao.bind();
        glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
        GL30.glBindVertexArray(0);
    }

    private void createBufferObjects() {
        Logging.logInfo("Creating VBOs");
        // Create buffer objects
        vao = new VertexArrayObject();
        vbo = new VertexBufferObject();
        ebo = new ElementBufferObject();
        // Bind VAO
        vao.bind();
        // Fill VBO with vertex data
        vbo.bind();
        vbo.writeData(defaultVertices, GL15.GL_STATIC_DRAW);
        // Fill EBO with vertex indices
        ebo.bind();
        ebo.writeData(defaultIndices, GL15.GL_STATIC_DRAW);

        ////// Vertex attribute pointers
        // Position attribute
        GL20.glVertexAttribPointer(0, 3, GL_FLOAT, false, 8 * 4, 0);
        GL20.glEnableVertexAttribArray(0);
        // Color attribute
        GL20.glVertexAttribPointer(1, 3, GL_FLOAT, false, 8 * 4, 3 * 4);
        GL20.glEnableVertexAttribArray(1);
        // Texture attribute
        GL20.glVertexAttribPointer(2, 2, GL_FLOAT, false, 8 * 4, 6 * 4);
        GL20.glEnableVertexAttribArray(2);
    }

    /**
     * Setup shaders. The purpose of this function may be replaced by a shader manager.
     */
    private void createShaders() {
        Logging.logInfo("Creating Shaders");
        Shader vertShader = Shader.loadShaderResource(GL20.GL_VERTEX_SHADER, "simple.vsh.glsl");
        Shader fragShader = Shader.loadShaderResource(GL20.GL_FRAGMENT_SHADER, "simple.fsh.glsl");

        program = new ShaderProgram(vertShader, fragShader);

        // Set important stuffs
        program.use();
        program.setInt("texture0", 0);
        program.setInt("texture1", 1);
    }

    /**
     * Create textures. This fuction may fall away in the future as textures are mapped to objects.
     */
    private void createTextures() {
        Logging.logInfo("Creating Textures");
        textureManager = new TextureManager();
        texture0 = textureManager.fromKey("urealms/type_legendary.jpg");
        texture1 = textureManager.fromKey("urealms/art_alchemist.png");
    }

    public void viewport(int width, int height) {
        glViewport(0, 0, width, height);
    }

}
