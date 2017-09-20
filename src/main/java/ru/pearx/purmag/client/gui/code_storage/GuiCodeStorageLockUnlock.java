package ru.pearx.purmag.client.gui.code_storage;

import net.minecraft.util.ResourceLocation;
import ru.pearx.libmc.client.gui.DrawingTools;
import ru.pearx.libmc.client.gui.controls.GuiOnScreen;
import ru.pearx.purmag.common.Utils;

/*
 * Created by mrAppleXZ on 19.09.17 18:59.
 */
public class GuiCodeStorageLockUnlock extends GuiOnScreen
{
    public static final ResourceLocation TEXTURE = Utils.getResourceLocation("textures/gui/code_storage_lockunlock.png");

    protected int margin = 16;

    public GuiCodeStorageLockUnlock()
    {
        setWidth(288);
        setHeight(128);
    }

    @Override
    public void render()
    {
        DrawingTools.drawTexture(TEXTURE, 0, 0, getWidth(), getHeight());
    }
}