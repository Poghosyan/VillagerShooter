package com.foobar;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GameListener implements Listener {
    VillagerShootingGame game;
    GameListener(VillagerShootingGame g) {
        game = g;
    }

    @EventHandler
    public void addToGame(PlayerInteractEvent e) {
        if(e.getClickedBlock().getType().equals(Material.SIGN_POST)) {
            if(game.activePlayers.size() < 1) {
                game.activePlayers.add(e.getPlayer());
                game.activePlayers.get(0).setScoreboard(game.board);
            }
        }
    }
}
