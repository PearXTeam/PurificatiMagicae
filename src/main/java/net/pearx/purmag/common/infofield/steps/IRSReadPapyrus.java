package net.pearx.purmag.common.infofield.steps;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.purmag.client.guis.if_tablet.steps.IRSPapyrusRenderer;
import net.pearx.purmag.client.guis.if_tablet.steps.IRSRenderer;
import net.pearx.purmag.common.items.ItemRegistry;

/**
 * Created by mrAppleXZ on 30.05.17 9:33.
 */
public class IRSReadPapyrus extends IRSPapyrus
{
    public IRSReadPapyrus(String id)
    {
        super(id);
    }

    @Override
    public String getUnlocalizedDescription()
    {
        return "read_papyrus";
    }

    @Override
    public String getUnlocalizedName()
    {
        return "read_papyrus";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRSRenderer getRenderer()
    {
        return new IRSPapyrusRenderer(this);
    }
}
