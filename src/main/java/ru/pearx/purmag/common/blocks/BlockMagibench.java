package ru.pearx.purmag.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.util.Constants;
import ru.pearx.libmc.common.blocks.controllers.HorizontalFacingController;
import ru.pearx.purmag.PurMag;
import ru.pearx.purmag.common.magibench.MagibenchRegistry;
import ru.pearx.purmag.common.tiles.TileCodeStorage;
import ru.pearx.purmag.common.tiles.TileMagibench;

import javax.annotation.Nullable;

/*
 * Created by mrAppleXZ on 31.10.17 18:00.
 */
public class BlockMagibench extends BlockBase
{
    public static final int GUI_ID = 1;

    public BlockMagibench()
    {
        super("magibench", Material.WOOD);
        setSoundType(SoundType.WOOD);
        setHardness(1f);
        setHarvestLevel("axe", 0);
        setDefaultState(getDefaultState().withProperty(HorizontalFacingController.FACING_H, EnumFacing.NORTH));
    }

    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileMagibench();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te != null && te instanceof TileMagibench)
        {
            if (!worldIn.isRemote)
            {
                playerIn.openGui(PurMag.INSTANCE, GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity te = worldIn.getTileEntity(pos);
        if (te != null && te instanceof TileMagibench)
        {
            TileMagibench bench = (TileMagibench) te;
            bench.setTier(stack.getMetadata(), false);
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for(MagibenchRegistry.Tier t : PurMag.INSTANCE.getMagibenchRegistry().getTiers())
        {
            items.add(new ItemStack(this, 1, t.getTier()));
        }
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        int meta = 0;
        TileEntity te = world.getTileEntity(pos);
        if (te != null && te instanceof TileMagibench)
            meta = ((TileMagibench) te).getTier();
        return new ItemStack(this, 1, meta);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, HorizontalFacingController.FACING_H);
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirror)
    {
        return HorizontalFacingController.withMirror(state, mirror);
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return HorizontalFacingController.withRotation(state, rot);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return HorizontalFacingController.getStateFromMeta(getDefaultState(), meta);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return HorizontalFacingController.getMetaFromState(state);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return HorizontalFacingController.getStateForPlacement(getDefaultState(), placer);
    }
}