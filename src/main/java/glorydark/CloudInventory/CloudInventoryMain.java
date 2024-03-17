package glorydark.CloudInventory;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import glorydark.CloudInventory.command.InventoryCommand;
import glorydark.CloudInventory.gui.FormListener;
import glorydark.CloudInventory.listener.BaseListener;

import java.io.File;

public class CloudInventoryMain extends PluginBase implements Listener {
    public static Plugin plugin;
    public static Integer defaultMaxSlot;

    public void onLoad() {
        this.getLogger().info("CloudInventory 正在加载中");
    }

    public void onEnable() {
        this.getLogger().info("CloudInventory 成功加载");
        this.getLogger().info("作者: Glorydark");
        this.saveDefaultConfig();
        defaultMaxSlot = new Config(this.getDataFolder() + "/config.yml", Config.YAML).getInt("默认云背包大小", 20);
        this.checkPlayerSlot();
        this.saveResource("lang.yml", false);
        this.getServer().getPluginManager().registerEvents(new FormListener(), this);
        this.getServer().getPluginManager().registerEvents(new BaseListener(), this);
        this.getServer().getCommandMap().register("", new InventoryCommand("yun"));
        plugin = this;
    }

    public void onDisable() {
        this.getLogger().info("CloudInventory 已卸载");
    }

    public void checkPlayerSlot() {
        File file = new File(this.getDataFolder().getPath() + "/players/");
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                Config config = new Config(file1.getPath(), Config.YAML);
                if (config.exists("InventorySlots")) {
                    Integer slot = config.getInt("InventorySlots");
                    if (slot < defaultMaxSlot) {
                        config.set("InventorySlots", defaultMaxSlot);
                        config.save();
                    }
                } else {
                    config.set("InventorySlots", defaultMaxSlot);
                    config.save();
                }
            }
        }
    }
}
