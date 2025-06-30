package me.regionelo;

import org.bukkit.plugin.java.JavaPlugin;

public class RegionElo extends JavaPlugin {

    private static RegionElo instance;

    @Override
    public void onEnable() {
        instance = this;

        // Load config
        saveDefaultConfig();

        // Register commands
        getCommand("elo").setExecutor(new EloCommand(this));
        getCommand("elotop").setExecutor(new EloTopCommand(this));

        // Register PAPI placeholder nếu có
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new EloPlaceholder(this).register();
            getLogger().info("PlaceholderAPI hook enabled.");
        }

        getLogger().info("RegionElo đã bật thành công!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RegionElo đã tắt!");
    }

    public static RegionElo getInstance() {
        return instance;
    }
}
