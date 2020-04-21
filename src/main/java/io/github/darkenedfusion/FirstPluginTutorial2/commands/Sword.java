package io.github.darkenedfusion.FirstPluginTutorial2.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Sword implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory playerInventory = player.getInventory();

        if(inventoryIsFull(playerInventory)) {
            handleFullInventory(player);
            player.sendMessage(ChatColor.DARK_RED + "Error: inventory is full!");
        } else {
            givePlayerSword(playerInventory);
            player.sendMessage(ChatColor.AQUA + "Received diamond sword in your first hot bar slot!");
        }


        return true;
    }



    private boolean inventoryIsFull(Inventory playerInventory) {
         int fullInventoryIndex = -1;
         int openSlotIndex = playerInventory.firstEmpty();
        if(openSlotIndex == fullInventoryIndex) {
            return true;
        } else {
            return false;
        }
    }

    private void givePlayerSword(Inventory playerInventory) {
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        playerInventory.addItem(diamondSword);
    }


    private void playTitle(Player player) {
        String title = ChatColor.DARK_RED + "Your inventory is full!";
        String subTitle = null;
        int duration = 100;
        int fadeIn = 15;
        int fadeOut = 20;
        player.sendTitle(title, null, duration, fadeIn, fadeOut);
    }

    private void playSound(Player player) {
        Location location = player.getLocation();
        Sound fullInventorySound = Sound.ENTITY_VILLAGER_NO;
        float volume = 1;
        float pitch = 1;
        player.playSound(location, fullInventorySound, volume, pitch);
    }

    private void handleFullInventory(Player player) {

        playTitle(player);
        playSound(player);

    }

}
