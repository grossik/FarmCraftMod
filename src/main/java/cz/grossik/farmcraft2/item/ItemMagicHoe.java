package cz.grossik.farmcraft2.item;

import java.util.List;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMagicHoe extends Item
{
    private final float speed;
    protected Item.ToolMaterial theToolMaterial;

    public ItemMagicHoe(Item.ToolMaterial material)
    {
        this.theToolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.speed = material.getDamageVsEntity() + 1.0F;
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	
        BlockPos pos1 = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ());
        BlockPos pos2 = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1);
        BlockPos pos3 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
        BlockPos pos4 = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ());
        BlockPos pos5 = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1);
        BlockPos pos6 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
        BlockPos pos7 = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1);
        BlockPos pos8 = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1);
        
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack)  ||
        		!playerIn.canPlayerEdit(pos1.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos2.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos3.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos4.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos5.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos6.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos7.offset(facing), facing, stack) || 
        		!playerIn.canPlayerEdit(pos8.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

            int hook1 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos1);
            if (hook1 != 0) return hook1 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook2 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos2);
            if (hook2 != 0) return hook2 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook3 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos3);
            if (hook3 != 0) return hook3 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook4 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos4);
            if (hook4 != 0) return hook4 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook5 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos5);
            if (hook5 != 0) return hook5 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook6 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos6);
            if (hook6 != 0) return hook6 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook7 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos7);
            if (hook7 != 0) return hook7 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            int hook8 = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos8);
            if (hook8 != 0) return hook8 > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
            
            IBlockState iblockstate = worldIn.getBlockState(pos);
            IBlockState iblockstate1 = worldIn.getBlockState(pos1);
            IBlockState iblockstate2 = worldIn.getBlockState(pos2);
            IBlockState iblockstate3 = worldIn.getBlockState(pos3);
            IBlockState iblockstate4 = worldIn.getBlockState(pos4);
            IBlockState iblockstate5 = worldIn.getBlockState(pos5);
            IBlockState iblockstate6 = worldIn.getBlockState(pos6);
            IBlockState iblockstate7 = worldIn.getBlockState(pos7);
            IBlockState iblockstate8 = worldIn.getBlockState(pos8);

            Block block = iblockstate.getBlock();
            Block block1 = iblockstate1.getBlock();
            Block block2 = iblockstate2.getBlock();
            Block block3 = iblockstate3.getBlock();
            Block block4 = iblockstate4.getBlock();
            Block block5 = iblockstate5.getBlock();
            Block block6 = iblockstate6.getBlock();
            Block block7 = iblockstate7.getBlock();
            Block block8 = iblockstate8.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
            {
                if (block == Blocks.GRASS &&
                	block1 == Blocks.GRASS &&
                	block2 == Blocks.GRASS &&
                	block3 == Blocks.GRASS &&
                	block4 == Blocks.GRASS &&
                	block5 == Blocks.GRASS &&
                	block6 == Blocks.GRASS &&
                	block7 == Blocks.GRASS &&
                	block8 == Blocks.GRASS)
                {
                    this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos1, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos2, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos3, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos4, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos5, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos6, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos7, Blocks.FARMLAND.getDefaultState());
                    this.setBlock(stack, playerIn, worldIn, pos8, Blocks.FARMLAND.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }
            }

            return EnumActionResult.PASS;
        }
    }

    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4)
    {
       list.add(TextFormatting.BLUE + "3x3");
    }
    
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }

    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!worldIn.isRemote)
        {
            worldIn.setBlockState(pos, state, 11);
            stack.damageItem(1, player);
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public String getMaterialName()
    {
        return this.theToolMaterial.toString();
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 0.0D, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)(this.speed - 4.0F), 0));
        }
        return multimap;
    }
}