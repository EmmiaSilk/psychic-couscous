#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec3 aColor;
layout (location = 2) in vec2 aTexCoord;

uniform vec4 offset;

out vec3 vertexColor;
out vec2 texCoord;

void main() {
    gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);
    //gl_Position = gl_Position + offset;

    vertexColor = aColor;
    texCoord = aTexCoord;
}
