package com.rotpaddon.exampleaddon.capability;

import com.rotpaddon.exampleaddon.network.AddonPackets;
import com.rotpaddon.exampleaddon.network.s2c.TrPickaxesThrownPacket;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class LivingData implements INBTSerializable<CompoundNBT> {
    private final LivingEntity entity;
    private int pickaxesThrown = 0;
    
    public LivingData(LivingEntity entity) {
        this.entity = entity;
    }
    
    
    public void setPickaxesThrown(int pickaxes) {
        this.pickaxesThrown = pickaxes;
        if (!entity.level.isClientSide()) {
            /* 
             * Synchronize the data to the player's client and surrounding players' clients
             * (i.e. if it isn't used when rendering the entity model):
             */
            AddonPackets.sendToClientsTrackingAndSelf(new TrPickaxesThrownPacket(entity.getId(), pickaxesThrown), entity);
            
            /* 
             * If this data doesn't need to be known to other players, 
             * but there is still something like a UI that shows this value to the player,
             * instead sync it only to that player like so:
             */
//            if (entity instanceof ServerPlayerEntity) {
//                ServerPlayerEntity player = (ServerPlayerEntity) entity;
//                AddonPackets.sendToClient(new SomeDataPacket(someDataField), player);
//            }
            
            /*
             * Or, if that piece of data is only needed on the server, don't send it at all.
             */
        }
    }
    
    public int getPickaxesThrown() {
        return pickaxesThrown;
    }
    
    
    // Sync all the data that should be available to all players (mostly needed for rendering).
    public void syncWithAnyPlayer(ServerPlayerEntity player) {
        AddonPackets.sendToClient(new TrPickaxesThrownPacket(entity.getId(), pickaxesThrown), player);
    }
    
    // If there is data that should only be known to the player, and not to other ones, sync it here instead.
    public void syncWithEntityOnly(ServerPlayerEntity player) {
//        AddonPackets.sendToClient(new SomeDataPacket(someDataField), player);
    }
    
    
    // Save to & load from save file.
    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("PickaxesThrown", pickaxesThrown);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        pickaxesThrown = nbt.getInt("PickaxesThrown");
    }
}
