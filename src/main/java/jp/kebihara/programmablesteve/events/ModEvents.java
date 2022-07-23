package jp.kebihara.programmablesteve.events;

import jp.kebihara.programmablesteve.ProgrammableSteve;
import jp.kebihara.programmablesteve.server.APIServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = ProgrammableSteve.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onWorldLoad(WorldEvent.Load event) throws IOException {
        Logger logger = LogManager.getLogger(ProgrammableSteve.MOD_ID);
        logger.atInfo().log("on world load");

        new APIServer().start();
    }
}
