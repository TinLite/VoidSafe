package vn.vinhgaming.voidsafe;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().hasPermission("voidsafe.bypass")) return;
        if (!(ConfigManager.inEnabledWorlds(event.getPlayer().getWorld().getName())))
            return;
        Player player = event.getPlayer();
        ConfigurationSection worldConfig = ConfigManager.getWorldConfig(event.getPlayer().getWorld().getName());
        if (!player.hasPermission(worldConfig.getString("permission", "voidsafe.activeall")) && !player.hasPermission("voidsafe.activeall"))
            return;
        Location playerLocation = player.getLocation();
        if (playerLocation.getY() <= worldConfig.getDouble("y-trigger"))
            // just in case
            player.teleport(ConfigManager.getDestination(playerLocation.getWorld().getName()), PlayerTeleportEvent.TeleportCause.PLUGIN);
    }
}
