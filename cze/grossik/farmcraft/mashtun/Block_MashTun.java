package cze.grossik.farmcraft.mashtun;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cze.grossik.farmcraft.FarmCraft;
import cze.grossik.farmcraft.handler.BlockHandler;

public class Block_MashTun extends BlockContainer {

    private static boolean isBurning;
    private final boolean isBurning2;
    private final Random random = new Random();
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon topVrch;

    public Block_MashTun(boolean isActive) {
        super(Material.rock);
        isBurning2 = isActive;
    }

    public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
        int direction = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        isBurning = true;

        if (burning) {
            world.setBlock(x, y, z, BlockHandler.MashTunOn);
        } else {
            world.setBlock(x, y, z, BlockHandler.MashTunOff);
        }

        isBurning = false;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);

        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon("farmcraft:mashtun_top");
        this.front = iconregister.registerIcon(this.isBurning2 ? "farmcraft:mashtun_top" : "farmcraft:mashtun_top");
        this.top = iconregister.registerIcon("farmcraft:mashtun_top");
        this.topVrch = iconregister.registerIcon("farmcraft:mashtun_top_vrch");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.topVrch : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.front));
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        player.openGui(FarmCraft.instance, 1, world, x, y, z);

        return true;
    }

    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemFromBlock(BlockHandler.MashTunOff);
    }

    public Item getItem(World world, int par2, int par3, int par4) {
        return Item.getItemFromBlock(BlockHandler.MashTunOff);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityMashTun();
    }

    @SideOnly(Side.CLIENT)
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.direction(world, x, y, z);
    }

    private void direction(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block direction = world.getBlock(x, y, z - 1);
            Block direction1 = world.getBlock(x, y, z + 1);
            Block direction2 = world.getBlock(x - 1, y, z);
            Block direction3 = world.getBlock(x + 1, y, z);
            byte byte0 = 3;

            if (direction.func_149730_j() && direction.func_149730_j()) {
                byte0 = 3;
            }

            if (direction1.func_149730_j() && direction1.func_149730_j()) {
                byte0 = 2;
            }

            if (direction2.func_149730_j() && direction2.func_149730_j()) {
                byte0 = 5;
            }

            if (direction3.func_149730_j() && direction3.func_149730_j()) {
                byte0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (direction == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (direction == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (direction == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (direction == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemstack.hasDisplayName()) {
            ((TileEntityMashTun) world.getTileEntity(x, y, z)).field_145958_o(itemstack.getDisplayName());
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!isBurning) {
            TileEntityMashTun tileentitytutfurnace = (TileEntityMashTun) world.getTileEntity(x, y, z);

            if (tileentitytutfurnace != null) {
                for (int i = 0; i < tileentitytutfurnace.getSizeInventory(); ++i) {
                    ItemStack itemstack = tileentitytutfurnace.getStackInSlot(i);

                    if (itemstack != null) {
                        float f = this.random.nextFloat() * 0.6F + 0.1F;
                        float f1 = this.random.nextFloat() * 0.6F + 0.1F;
                        float f2 = this.random.nextFloat() * 0.6F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j = this.random.nextInt(21) + 10;

                            if (j > itemstack.stackSize) {
                                j = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j;
                            EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
                            }

                            float f3 = 0.025F;
                            entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                            entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
                            entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, meta);
    }


}