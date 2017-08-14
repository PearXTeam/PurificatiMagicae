package ru.pearx.purmag.common.sip;

import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by mrAppleXZ on 10.04.17 9:05.
 */
public class SipTypeRegistry
{
    private List<SipType> types = new ArrayList<>();
    private List<String> allowedValues = new ArrayList<>();

    public void register(SipType t)
    {
        types.add(t);
        allowedValues.add(t.getName());
    }

    public void unregister(String type)
    {
        for(SipType t : types)
        {
            if(t.getName().equals(type))
            {
                types.remove(t);
                break;
            }
        }
        allowedValues.remove(type);
    }

    public SipType getType(String name)
    {
        for(SipType type : types)
            if(type.getName().equals(name))
                return type;
        return null;
    }

    /**
     * Only for iteration! Don't remove or add your types there.
     */
    public List<SipType> getTypes()
    {
        return types;
    }

    /**
     * Only for iteration! Don't remove or add your types there.
     */
    public List<String> getAllowedValues()
    {
        return allowedValues;
    }

    public SipType getDefaultType()
    {
        return getTypes().get(0);
    }

    public void register()
    {
        //todo air and vision gen.
        register(new SipType("rock", 0x9e9e9e, TextFormatting.GRAY));
        register(new SipType("sea", 0x42A5F5, TextFormatting.BLUE));
        register(new SipType("flame", 0xFB8C00, TextFormatting.GOLD));
        register(new SipType("air", 0xFFE57F, TextFormatting.YELLOW));
        register(new SipType("information", 0x68C397, TextFormatting.GREEN));
        register(new SipType("vision", 0x4527A0, TextFormatting.DARK_PURPLE));
        register(new SipType("analysis", 0x57759C, TextFormatting.BLUE));
        register(new SipType("electricity", 0xFFEB3B, TextFormatting.YELLOW));
    }
}
