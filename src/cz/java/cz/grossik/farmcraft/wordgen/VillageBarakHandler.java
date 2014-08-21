package cz.grossik.farmcraft.wordgen;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;

import java.util.List;
import java.util.Random;

public class VillageBarakHandler implements IVillageCreationHandler {
    @Override
    public PieceWeight getVillagePieceWeight(Random random, int i) {
        return new PieceWeight(Village_Barak.class, 30, i + random.nextInt(4));
    }

    @Override
    public Class<?> getComponentClass() {
        return Village_Barak.class;
    }

    @Override
    public Object buildComponent(PieceWeight villagePiece, Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        return Village_Barak.func_74906_a(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }
}
