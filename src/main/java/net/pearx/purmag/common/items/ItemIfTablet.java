package net.pearx.purmag.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.purmag.PurMag;
import net.pearx.purmag.client.ClientUtils;
import net.pearx.purmag.client.models.IModelProvider;
import net.pearx.purmag.common.infofield.IfTier;

/**
 * Created by mrAppleXZ on 13.04.17 21:54.
 */
public class ItemIfTablet extends ItemBase  implements IModelProvider
{
    public ItemIfTablet()
    {
        setRegistryName("if_tablet");
        setHasSubtypes(true);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World w, EntityPlayer p, EnumHand hand)
    {
        ItemStack stack = p.getHeldItem(hand);
        if(w.isRemote)
        {
            PurMag.proxy.openIfTablet(stack.getItemDamage());
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> sub)
    {
        if(isInCreativeTab(tab))
        {
            for (IfTier t : PurMag.INSTANCE.if_registry.tiers)
            {
                sub.add(new ItemStack(this, 1, t.getTier()));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName(stack) + "." + stack.getItemDamage();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setupModels()
    {
        for(IfTier t : PurMag.INSTANCE.if_registry.tiers)
        {
            ClientUtils.setModelLocation(this, t.getTier(), "." + t.getTier());
        }
    }
}
