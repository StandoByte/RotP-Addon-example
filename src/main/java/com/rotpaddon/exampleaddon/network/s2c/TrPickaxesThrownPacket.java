package com.rotpaddon.exampleaddon.network.s2c;

import java.util.function.Supplier;

import com.github.standobyte.jojo.client.ClientUtil;
import com.rotpaddon.exampleaddon.capability.LivingData;
import com.rotpaddon.exampleaddon.capability.LivingDataProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;

// I just put "Tr" to the name of the packets which are sent to all players tracking the entity, 
// as opposed to when a packet only sends the data to a specific client
public class TrPickaxesThrownPacket {
    private final int entityId;
    private final int pickaxesThrown;

    public TrPickaxesThrownPacket(int entityId, int pickaxesThrown) {
        this.entityId = entityId;
        this.pickaxesThrown = pickaxesThrown;
    }



    public static void encode(TrPickaxesThrownPacket msg, PacketBuffer buf) {
        buf.writeInt(msg.entityId);
        buf.writeInt(msg.pickaxesThrown);
    }

    public static TrPickaxesThrownPacket decode(PacketBuffer buf) {
        int entityId = buf.readInt();
        int pickaxesThrown = buf.readInt();
        return new TrPickaxesThrownPacket(entityId, pickaxesThrown);
    }

    public static void handle(TrPickaxesThrownPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Entity entity = ClientUtil.getEntityById(msg.entityId);
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                LazyOptional<LivingData> playerDataOptional = livingEntity.getCapability(LivingDataProvider.CAPABILITY);
                playerDataOptional.ifPresent(playerData -> {
                    playerData.setPickaxesThrown(msg.pickaxesThrown);
                });
                
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
