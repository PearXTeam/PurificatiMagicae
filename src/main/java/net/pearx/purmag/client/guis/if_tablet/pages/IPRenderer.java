package net.pearx.purmag.client.guis.if_tablet.pages;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.purmag.client.GuiDrawableRegistry;
import net.pearx.purmag.client.guis.DrawingTools;
import net.pearx.purmag.client.guis.controls.Control;
import net.pearx.purmag.client.guis.if_tablet.GuiIfTabletSP;
import net.pearx.purmag.common.infofield.pages.IIfPage;

/**
 * Created by mrAppleXZ on 03.05.17 21:30.
 */
@SideOnly(Side.CLIENT)
public class IPRenderer<T extends IIfPage> extends Control
{
    public T page;
    public IPRenderer(T page)
    {
        this.page = page;
    }

    @Override
    public void init()
    {
        setWidth(getTablet().getWidth() - 16);
        //top + bottom + back height + text + splitter + margins
        setHeight(getTablet().getHeight() - (8 + 8 + 16 + DrawingTools.getFontHeight() + GuiDrawableRegistry.splitter.getHeight() + 4));
        setX(8);
        setY(8 + DrawingTools.getFontHeight() + GuiDrawableRegistry.splitter.getHeight() + 4);
    }

    public GuiIfTabletSP getTablet()
    {
        return (GuiIfTabletSP)getParent();
    }
}
