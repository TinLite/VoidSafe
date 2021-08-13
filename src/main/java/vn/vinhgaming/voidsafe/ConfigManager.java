package vn.vinhgaming.voidsafe;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {
    private static FileConfiguration config;
    private static List<String> worlds;
    private static Map<String, Location> destinations;

    /**
     * Initialize the configuration manager.
     */
    public static void init() {
        config = VoidSafe.getInstance().getConfig();
        worlds = new ArrayList<>(config.getConfigurationSection("worlds").getKeys(false));

        // just so we don't have to recalculate this shit again for everytime someone fall into the void
        if (destinations == null) destinations = new HashMap<>();
        else destinations.clear();
        for (String world : worlds) {
            String[] splited = config.getString("worlds." + world + ".destination").split(",");
            Location location = new Location(Bukkit.getWorld(splited[0]), Double.parseDouble(splited[1]), Double.parseDouble(splited[2])
                    , Double.parseDouble(splited[3]), Float.parseFloat(splited[4]), Float.parseFloat(splited[5]));
            destinations.put(world, location);
        }
    }

    /**
     * Check if the world name are configured to teleport player back from the void
     *
     * @param world World need to check
     * @return true if the configuration file contains config needed. Otherwise, false.
     */
    public static boolean inEnabledWorlds(String world) {
        return worlds.contains(world);
    }

    /**
     * Get the ConfigurationSection for the world
     *
     * @param world Name of the world we need the ConfigurationSection
     * @return ConfigurationSection for that world
     */
    public static ConfigurationSection getWorldConfig(String world) {
        return config.getConfigurationSection("worlds." + world);
    }


    /**
     * Get the teleport destination if someone fall into the void in given world.
     *
     * @param world Name of the world
     * @return Location of destination
     */
    public static Location getDestination(String world) {
        return destinations.get(world);
    }
}
