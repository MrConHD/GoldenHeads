package me.MrConHD.goldenheads.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Connor on 3/15/2015.
 */
public class OnConsume implements Listener {

    public void onConsume(PlayerItemConsumeEvent e) {
        if (e.getItem().getType() == Material.GOLDEN_APPLE) {
            ItemStack goldenHead = e.getItem();
            if (goldenHead.getItemMeta().getLore().contains("Golden Head")) {
                Player p = e.getPlayer();
                PotionEffect pe = new PotionEffect(PotionEffectType.ABSORPTION, 2400, 1);
                PotionEffect re = new PotionEffect(PotionEffectType.REGENERATION, 200, 2);
                pe.apply(p);
                re.apply(p);
            }

        }
    }
}
