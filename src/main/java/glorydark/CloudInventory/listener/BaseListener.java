package glorydark.CloudInventory.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.Config;
import glorydark.CloudInventory.CloudInventoryMain;

import java.util.ArrayList;

public class BaseListener implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent event) {
        Config config = new Config(CloudInventoryMain.plugin.getDataFolder() + "/players/" + event.getPlayer().getName() + ".yml");
        if (!config.exists("Inventory")) {
            config.set("Inventory", new ArrayList<String>());
            config.save();
        }
    }
}
