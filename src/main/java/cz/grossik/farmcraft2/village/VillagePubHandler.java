package cz.grossik.farmcraft2.village;

import java.util.List;
import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class VillagePubHandler implements IVillageCreationHandler {

	@Override
	public PieceWeight getVillagePieceWeight(Random random, int i) {
        return new StructureVillagePieces.PieceWeight(ComponentVillagePub.class, 20, MathHelper.getRandomIntegerInRange(random, 0 + i, 1 + i));
	}

	@Override
	public Class<?> getComponentClass() {
        return ComponentVillagePub.class;
	}

	@Override
	public Village buildComponent(PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces,
			Random random, int p1, int p2, int p3, EnumFacing facing, int p5) {
        return ComponentVillagePub.createPiece(startPiece, pieces, random, p1, p2, p3, facing, p5);
	}

}