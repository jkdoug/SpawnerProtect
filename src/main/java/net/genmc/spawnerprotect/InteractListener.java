package net.genmc.spawnerprotect;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.player.PlayerInteractEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class InteractListener implements Listener {

	protected static final Logger LOGGER = Logger.getLogger("SpawnerProtect");

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.hasBlock() && event.getClickedBlock().getType() == Material.MOB_SPAWNER &&
        	event.getItem() != null && event.getItem().getType() == Material.MONSTER_EGG) {

        	Player player = event.getPlayer();

        	PermissionUser user = PermissionsEx.getUser(player);
        	if (!user.has("spawnerprotect.admin")) {
            	LOGGER.warning("[SpawnerProtect] " + player.getName() + " attempted to use a monster egg on a mob spawner");

            	event.setCancelled(true);
            	event.setUseInteractedBlock(Result.DENY);
            	event.setUseItemInHand(Result.DENY);
        	}
        }
    }

}
