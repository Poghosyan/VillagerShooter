package com.foobar;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class used by the launch function to pick next target to launch
 */
public class EntityTypePicker {
    Random picker;
    EntityTypePicker() {
        picker = new Random();
    }

    public EntityType pickEntityType() {
        EntityType picked;
        int probability = picker.nextInt(100);

        if (probability <= 60)
            picked = EntityType.VILLAGER;
        else if (probability > 60 && probability <= 85)
            picked = EntityType.CHICKEN;
        else
            picked = EntityType.CREEPER;

        return picked;
    }
}
