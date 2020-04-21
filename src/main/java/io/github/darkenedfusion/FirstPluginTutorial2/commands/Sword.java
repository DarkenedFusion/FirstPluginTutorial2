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


// deals with the actual command and detecting if the inventory is full or not
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory playerInventory = player.getInventory();

        if(inventoryIsFull(playerInventory)) {
            handleFullInventory(player);
            player.sendMessage(ChatColor.DARK_RED + "Error: inventory is full!");
        } else {
            givePlayerSword(playerInventory);
            playGiveTitle(player);
        }


        return true;
    }


// if the inventory is full aka the integer -1  and has no open slots returns true if not then false
    private boolean inventoryIsFull(Inventory playerInventory) {
         int fullInventoryIndex = -1;
         int openSlotIndex = playerInventory.firstEmpty();
        if(openSlotIndex == fullInventoryIndex) {
            return true;
        } else {
            return false;
        }
    }
// Detects the item diamond sword and if players inventory has space gives them the sword.
    private void givePlayerSword(Inventory playerInventory) {
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        playerInventory.addItem(diamondSword);
    }

// If players inventory is full it will show a title in dark red
    private void playTitle(Player player) {
        String title = ChatColor.DARK_RED + "Your inventory is full!";
        String subTitle = null;
        int duration = 50;
        int fadeIn = 10;
        int fadeOut = 5;
        player.sendTitle(title, null, duration, fadeIn, fadeOut);
    }
// Plays a sound if the players inventory is full
    private void playSound(Player player) {
        Location location = player.getLocation();
        Sound fullInventorySound = Sound.ENTITY_VILLAGER_NO;
        float volume = 1;
        float pitch = 1;
        player.playSound(location, fullInventorySound, volume, pitch);
    }

// Player see's a title when they get a diamond sword
    private void playGiveTitle(Player player) {
        String title = ChatColor.GOLD + "You have received your sword!";
        String subTitle = null;
        int duration = 50;
        int fadeIn = 10;
        int fadeOut = 5;
        player.sendTitle(title, null, duration, fadeIn, fadeOut);
    }



// if the method handleFullInventory is called it plays the full inventory sound and title!
    private void handleFullInventory(Player player) {

        playTitle(player);
        playSound(player);

    }

}
