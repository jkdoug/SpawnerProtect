package net.genmc.spawnerprotect;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnerProtect extends JavaPlugin {

	private static InteractListener interactListener = new InteractListener();

	@Override
	public void onDisable() {
		HandlerList.unregisterAll(interactListener);
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(interactListener, this);
	}

}
