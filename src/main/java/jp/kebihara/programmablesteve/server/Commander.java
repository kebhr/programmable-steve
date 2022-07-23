package jp.kebihara.programmablesteve.server;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class Commander {
    public static void keydown(String key) {
        KeyMapping.set(InputConstants.getKey("key.keyboard." + key), true);
    }

    public static void keyup(String key) {
        KeyMapping.set(InputConstants.getKey("key.keyboard." + key), false);
    }

    public static void yaw(float v) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.setXRot(v);
    }

    public static void pitch(float v) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.setYRot(v);
    }
}
