package me.MrConHD.goldenheads;

import me.MrConHD.goldenheads.listener.OnConsume;
import me.MrConHD.goldenheads.listener.OnDeath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

/**
 * Created by Connor on 3/15/2015.
 */
public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnConsume(), this);
        getServer().getPluginManager().registerEvents(new OnDeath(), this);

        setupHeads();
    }

    @Override
    public void onDisable() {

    }

    public void setupHeads() {
        ItemStack goldenHead = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta gMeta = goldenHead.getItemMeta();
        gMeta.setDisplayName(ChatColor.AQUA + "Golden Head");
        gMeta.setLore(Arrays.asList("You've crafted a Golden Head!", "Consuming this will grant you even greater effects", "than a normal Golden Apple!"));
        goldenHead.setItemMeta(gMeta);

        ShapedRecipe goldenHeadRecipe = new ShapedRecipe(goldenHead);
        goldenHeadRecipe.shape(
                "@@@",
                "@#@" ,
                "@@@");
        goldenHeadRecipe.setIngredient('@', Material.GOLD_INGOT);
        goldenHeadRecipe.setIngredient('#', Material.SKULL_ITEM, (short) 3);
        Bukkit.getServer().addRecipe(goldenHeadRecipe);
    }
}

