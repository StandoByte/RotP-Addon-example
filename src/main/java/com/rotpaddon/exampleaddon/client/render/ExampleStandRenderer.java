package com.rotpaddon.exampleaddon.client.render;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.rotpaddon.exampleaddon.AddonMain;
import com.rotpaddon.exampleaddon.entity.ExampleStandEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class ExampleStandRenderer extends StandEntityRenderer<ExampleStandEntity, StandEntityModel<ExampleStandEntity>> {
    
    public ExampleStandRenderer(EntityRendererManager renderManager) {
        super(renderManager, new ExampleStandModel(), 
                new ResourceLocation(AddonMain.MOD_ID, "textures/entity/stand/example_stand.png"), 0);
    }
}
