package glorydark.CloudInventory;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import glorydark.CloudInventory.gui.GuiListener;

public class MainClass extends PluginBase implements Listener {
    public static Plugin plugin;

    public void onLoad() {
        this.getLogger().info("CloudInventory 正在加载中");
    }

    public void onEnable(){
        this.getLogger().info("CloudInventory 成功加载");
        this.getLogger().info("作者: Glorydark");
        this.getLogger().info("本插件引用了若水的NBT物品保存代码");
        this.saveResource("lang.yml",false);
        this.getServer().getPluginManager().registerEvents(new GuiListener(), this);
        this.getServer().getPluginManager().registerEvents(new Event(),this);
        this.getServer().getCommandMap().register("",new InventoryCommand("yun"));
        plugin = this;
    }

    public void onDisable(){
        this.getLogger().info("CloudInventory 已卸载");
    }
}
