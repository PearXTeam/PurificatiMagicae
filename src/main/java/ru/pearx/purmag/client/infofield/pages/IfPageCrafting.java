package ru.pearx.purmag.client.infofield.pages;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.lib.Supplied;
import ru.pearx.purmag.client.gui.controls.recipes.CraftingControl;
import ru.pearx.purmag.client.gui.if_tablet.pages.IPCraftingRenderer;
import ru.pearx.purmag.client.gui.if_tablet.pages.IPRenderer;

import java.util.Arrays;
import java.util.List;

/*
 * Created by mrAppleXZ on 03.09.17 21:33.
 */
@SideOnly(Side.CLIENT)
public class IfPageCrafting implements IIfPage
{
    private List<Supplied<CraftingControl>> crafts;

    @SafeVarargs
    public IfPageCrafting(Supplied<CraftingControl>... crafts)
    {
        setCrafts(Arrays.asList(crafts));
    }

    public List<Supplied<CraftingControl>> getCrafts()
    {
        return crafts;
    }

    public void setCrafts(List<Supplied<CraftingControl>> crafts)
    {
        this.crafts = crafts;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IPRenderer getRenderer()
    {
        return new IPCraftingRenderer(this);
    }
}
