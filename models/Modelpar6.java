// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelpar6 extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public Modelpar6() {
		textureWidth = 76;
		textureHeight = 45;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-19.0F, -20.0F, 0.0F, 37.0F, 44.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}