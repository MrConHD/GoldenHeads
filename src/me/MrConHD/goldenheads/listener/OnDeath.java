package me.MrConHD.goldenheads.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

/**
 * Created by Connor on 3/15/2015.
 */
public class OnDeath implements Listener {

    ItemStack playerSkull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

    public void drop(Player p, Location loc) {
        SkullMeta pMeta = (SkullMeta) playerSkull.getItemMeta();
        pMeta.setOwner(p.getName());
        pMeta.setDisplayName(p.getName() + "'s Head");
        playerSkull.setItemMeta(pMeta);
        p.getWorld().dropItem(loc, playerSkull);
    }



    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
       if (e.getEntity().getKiller() instanceof Player) {
            if (!e.getDrops().isEmpty()) {
                drop(p, p.getLocation());
            } else {
                drop(p, p.getLocation());
            }
        }
       }
    }

