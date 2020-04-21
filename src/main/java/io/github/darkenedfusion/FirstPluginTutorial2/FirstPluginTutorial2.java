package io.github.darkenedfusion.FirstPluginTutorial2;

import io.github.darkenedfusion.FirstPluginTutorial2.Lottery.Lottery;
import io.github.darkenedfusion.FirstPluginTutorial2.commands.Sword;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstPluginTutorial2 extends JavaPlugin {
    @Override
    public void onEnable() {

        this.getCommand("sword").setExecutor(new Sword());


    }
    @Override
    public void onDisable() {

    }






}
