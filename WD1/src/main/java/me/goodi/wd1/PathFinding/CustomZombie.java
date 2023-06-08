package me.goodi.wd1.PathFinding;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;

import java.util.Objects;

public class CustomZombie extends Zombie {


    public CustomZombie(Location loc) {
        super(EntityType.ZOMBIE, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        this.setHealth(20);
        this.setAggressive(true);




        Objects.requireNonNull(this.getAttribute(Attributes.FOLLOW_RANGE)).setBaseValue(1000);





        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1d, true));
        this.targetSelector.addGoal(0, new MoveTowardsTargetGoal(this, 1, 1000));
        this.goalSelector.addGoal(2,new RandomStrollGoal(this, 1D));
        this.goalSelector.addGoal(2,new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new LookAtPlayerGoal(this, ServerPlayer.class, 1000, 100f, false));

    }
}