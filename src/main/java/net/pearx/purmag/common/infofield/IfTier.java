package net.pearx.purmag.common.infofield;

import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by mrAppleXZ on 20.04.17 10:30.
 */
public class IfTier
{
    private int tier;

    public IfTier(int tier)
    {
        setTier(tier);
    }

    public int getTier()
    {
        return tier;
    }

    public void setTier(int tier)
    {
        this.tier = tier;
    }

    public String getDisplayName()
    {
        return I18n.translateToLocal("if_tier." + tier + ".name");
    }
}
