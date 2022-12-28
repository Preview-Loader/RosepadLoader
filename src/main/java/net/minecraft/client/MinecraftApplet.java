package net.minecraft.client;

import net.buj.loader.RosepadLoader;
import net.buj.rml.Environment;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;

import java.applet.Applet;
import java.util.ArrayList;
import java.util.List;

public class MinecraftApplet extends Applet {
    private String[] sanitize(String[] a) {
        List<String> l = new ArrayList<>();
        for (String s : a) {
            if (s != null) l.add(s);
        }
        return l.toArray(new String[0]);
    }

    public void init() {}
    public void start() {
        new RosepadLoader(this).main(
            Environment.CLIENT,
            sanitize(new String[]{
                getParameter("username"),
                getParameter("sessionid"),
                getParameter("server"),
                getParameter("port")
            }),
            Minecraft.getMinecraftDir().toPath()
        );
    }
}