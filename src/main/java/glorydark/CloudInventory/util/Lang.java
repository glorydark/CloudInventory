package glorydark.CloudInventory.util;

import cn.nukkit.utils.Config;
import glorydark.CloudInventory.CloudInventoryMain;

public class Lang {
    public static String getTranslation(String s) {
        Config config = new Config(CloudInventoryMain.plugin.getDataFolder() + "/lang.yml");
        return config.getString(s, "Can not find the translation!");
    }
}
