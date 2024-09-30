package com.rotpaddon.exampleaddon.action;

import javax.annotation.Nullable;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.rotpaddon.exampleaddon.capability.LivingData;
import com.rotpaddon.exampleaddon.capability.LivingDataProvider;
import com.rotpaddon.exampleaddon.entity.ExamplePickaxeEntity;
import com.rotpaddon.exampleaddon.entity.ExampleStandEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

// An ability for our Example Stand.
public class ExampleStandThrowPickaxe extends StandEntityAction {

    public ExampleStandThrowPickaxe(StandEntityAction.Builder builder) {
        super(builder);
    }
    
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            // Creates a new entity for the projectile, then throw it.
            ExamplePickaxeEntity pickaxe = new ExamplePickaxeEntity(standEntity, world);
            standEntity.shootProjectile(pickaxe, 1.5F, 1.0F);
            
            LivingEntity user = userPower.getUser();
            if (user != null) {
                // Updates the data attached to the user.
                LazyOptional<LivingData> livingDataOptional = user.getCapability(LivingDataProvider.CAPABILITY);
                livingDataOptional.ifPresent(livingData -> {
                    livingData.setPickaxesThrown(livingData.getPickaxesThrown() + 1);
                });
            }
        }
    }
    
    @Override
    public void onTaskSet(World world, StandEntity standEntity, IStandPower standPower, 
            Phase phase, StandEntityTask task, int ticks) {
        if (!world.isClientSide() && standEntity instanceof ExampleStandEntity) {
            // This flag determines if a pickaxe model is rendered in the Stand's hand (see ExampleStandModel).
            ((ExampleStandEntity) standEntity).setHasPickaxe(true);
        }
    }

    @Override
    protected void onTaskStopped(World world, StandEntity standEntity, IStandPower standPower, 
            StandEntityTask task, @Nullable StandEntityAction newAction) {
        if (!world.isClientSide() && standEntity instanceof ExampleStandEntity) {
            ((ExampleStandEntity) standEntity).setHasPickaxe(false);
        }
    }

}
