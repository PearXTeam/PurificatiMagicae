package ru.pearx.purmag.common.infofield.steps;

import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.purmag.client.gui.if_tablet.steps.IRSIngredientRenderer;
import ru.pearx.purmag.client.gui.if_tablet.steps.IRSRenderer;

/**
 * Created by mrAppleXZ on 26.04.17 14:16.
 */
public class IRSCollect extends IRSIngredient
{
    private boolean showStack;

    public IRSCollect(Ingredient ing, String unlocDesc, boolean showStack)
    {
        setIngredient(ing);
        this.showStack = showStack;
        setUnlocalizedDescription(unlocDesc);
    }

    @Override
    public String getUnlocalizedName()
    {
        return "collect";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRSRenderer getRenderer()
    {
        return new IRSIngredientRenderer(this);
    }

    @Override
    public boolean shouldShowStack()
    {
        return showStack;
    }
}
