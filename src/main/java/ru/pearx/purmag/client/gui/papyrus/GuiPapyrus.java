package ru.pearx.purmag.client.gui.papyrus;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.libmc.client.gui.DrawingTools;
import ru.pearx.libmc.client.gui.GuiOnScreen;
import ru.pearx.purmag.common.Utils;
import ru.pearx.purmag.common.items.ItemRegistry;

import java.awt.*;

/**
 * Created by mrAppleXZ on 31.05.17 19:46.
 */
@SideOnly(Side.CLIENT)
public class GuiPapyrus extends GuiOnScreen
{
    private String text;

    public GuiPapyrus(String papyrusId)
    {
        text = ItemRegistry.papyrus.getPapyrus(papyrusId).getDisplayText();
        setWidth(192);
        setHeight(240);
    }

    @Override
    public void render()
    {
        DrawingTools.drawTexture(Utils.getRegistryName("textures/gui/papyrus.png"), 0, 0, getWidth(), getHeight());
        boolean unic = Minecraft.getMinecraft().fontRenderer.getUnicodeFlag();
        Minecraft.getMinecraft().fontRenderer.setUnicodeFlag(true);
        DrawingTools.drawString(text, 5, 5, Color.LIGHT_GRAY, getWidth() - 10);
        Minecraft.getMinecraft().fontRenderer.setUnicodeFlag(unic);
    }
}