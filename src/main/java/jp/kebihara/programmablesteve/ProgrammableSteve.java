package jp.kebihara.programmablesteve;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("programmablesteve")
public class ProgrammableSteve {
    public static final String MOD_ID = "programmablesteve";
    public ProgrammableSteve() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
