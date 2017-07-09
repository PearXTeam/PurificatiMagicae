package net.pearx.purmag.common.sip;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

/**
 * Created by mrAppleXZ on 10.04.17 9:06.
 */
public class SipType
{
    private String name;
    private int color;
    private TextFormatting formatting;

    public SipType(String name, int color, TextFormatting formatting)
    {
        setColor(color);
        setName(name);
        setFormatting(formatting);
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDisplayName()
    {
        return I18n.translateToLocalFormatted("sip." + name + ".name");
    }

    public TextFormatting getFormatting()
    {
        return formatting;
    }

    public void setFormatting(TextFormatting formatting)
    {
        this.formatting = formatting;
    }
}
