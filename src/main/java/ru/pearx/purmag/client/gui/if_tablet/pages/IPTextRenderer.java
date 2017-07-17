package ru.pearx.purmag.client.gui.if_tablet.pages;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.libmc.client.gui.DrawingTools;
import ru.pearx.purmag.common.infofield.pages.IfPageText;

import java.awt.*;

/**
 * Created by mrAppleXZ on 04.05.17 8:39.
 */
@SideOnly(Side.CLIENT)
public class IPTextRenderer extends IPRenderer<IfPageText>
{

    public IPTextRenderer(IfPageText page)
    {
        super(page);
    }

    @Override
    public void render()
    {
        super.render();
        DrawingTools.drawString(page.getDisplayText(), 5, 0, Color.WHITE, getWidth() - 5);
    }
}