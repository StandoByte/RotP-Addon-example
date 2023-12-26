package com.rotpaddon.exampleaddon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ExampleStandModelBlockbench extends EntityModel<Entity> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer upperPart;
    private final ModelRenderer torso;
    private final ModelRenderer leftArm;
    private final ModelRenderer leftArmJoint;
    private final ModelRenderer leftForeArm;
    private final ModelRenderer rightArm;
    private final ModelRenderer rightArmJoint;
    private final ModelRenderer rightForeArm;
    private final ModelRenderer pickaxe;
    private final ModelRenderer leftLeg;
    private final ModelRenderer leftLegJoint;
    private final ModelRenderer leftLowerLeg;
    private final ModelRenderer rightLeg;
    private final ModelRenderer rightLegJoint;
    private final ModelRenderer rightLowerLeg;

    public ExampleStandModelBlockbench() {
        texWidth = 128;
        texHeight = 128;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        

        upperPart = new ModelRenderer(this);
        upperPart.setPos(0.0F, 12.0F, 0.0F);
        body.addChild(upperPart);
        

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, -12.0F, 0.0F);
        upperPart.addChild(torso);
        torso.texOffs(0, 64).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(6.0F, -10.0F, 0.0F);
        upperPart.addChild(leftArm);
        leftArm.texOffs(32, 108).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftArmJoint = new ModelRenderer(this);
        leftArmJoint.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftArmJoint);
        leftArmJoint.texOffs(32, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, true);

        leftForeArm = new ModelRenderer(this);
        leftForeArm.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftForeArm);
        leftForeArm.texOffs(32, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setPos(-6.0F, -10.0F, 0.0F);
        upperPart.addChild(rightArm);
        rightArm.texOffs(0, 108).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        rightArmJoint = new ModelRenderer(this);
        rightArmJoint.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightArmJoint);
        rightArmJoint.texOffs(0, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

        rightForeArm = new ModelRenderer(this);
        rightForeArm.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightForeArm);
        rightForeArm.texOffs(0, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

        pickaxe = new ModelRenderer(this);
        pickaxe.setPos(0.0F, 4.0F, 0.0F);
        rightForeArm.addChild(pickaxe);
        setRotationAngle(pickaxe, 0.9599F, 0.0F, 0.0F);
        pickaxe.texOffs(106, 10).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        pickaxe.texOffs(116, 17).addBox(-0.5F, -1.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(104, 19).addBox(-0.5F, -2.5F, -3.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(96, 19).addBox(-0.5F, -3.5F, -4.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(114, 11).addBox(-0.5F, -4.5F, -5.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(114, 7).addBox(-0.5F, -5.5F, -6.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(114, 0).addBox(-0.5F, -6.5F, -7.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(96, 14).addBox(-0.5F, -7.5F, -8.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(106, 10).addBox(-0.5F, -8.5F, -12.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        pickaxe.texOffs(96, 0).addBox(-0.5F, -7.5F, -12.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
        pickaxe.texOffs(101, 0).addBox(-0.5F, -3.5F, -11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        pickaxe.texOffs(110, 17).addBox(-0.5F, -9.5F, -11.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        pickaxe.texOffs(96, 10).addBox(-0.5F, -10.5F, -11.5F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        pickaxe.texOffs(96, 0).addBox(-0.5F, -11.5F, -11.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        pickaxe.texOffs(107, 0).addBox(-0.5F, -12.5F, -8.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(1.9F, 12.0F, 0.0F);
        body.addChild(leftLeg);
        leftLeg.texOffs(96, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftLegJoint = new ModelRenderer(this);
        leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLegJoint);
        leftLegJoint.texOffs(96, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, true);

        leftLowerLeg = new ModelRenderer(this);
        leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLowerLeg);
        leftLowerLeg.texOffs(96, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(-1.9F, 12.0F, 0.0F);
        body.addChild(rightLeg);
        rightLeg.texOffs(64, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        rightLegJoint = new ModelRenderer(this);
        rightLegJoint.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLegJoint);
        rightLegJoint.texOffs(64, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

        rightLowerLeg = new ModelRenderer(this);
        rightLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLowerLeg);
        rightLowerLeg.texOffs(64, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}