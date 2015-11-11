package com.foobar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.Vector;

import java.util.ArrayList;


public class VillagerShootingGame extends JavaPlugin {
    long inGameSec = 20L;
    World world;
    BukkitScheduler gameTimer;
    GameLogic gameTask;
    ArrayList<Player> activePlayers;
    Scoreboard board;
    Objective obj;


    @Override
    public void onEnable() {
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = board.registerNewObjective("Kills", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        activePlayers = new ArrayList<Player>();
        gameTimer = getServer().getScheduler();
        world = this.getServer().getWorlds().get(0);
        gameTask = new GameLogic(this, GameState.IN_LOBBY);
        gameTimer.runTaskTimer(this, gameTask, 0L, inGameSec);
        getServer().getPluginManager().registerEvents(new GameListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public EntityType launch(World world, EntityType targetType, Location launchPoint, double speed) {
        Vector velocity = new Vector(0, speed, 0);
        Entity target = world.spawnEntity(launchPoint, targetType);
        target.setVelocity(velocity);
        return target.getType();
    }
}
