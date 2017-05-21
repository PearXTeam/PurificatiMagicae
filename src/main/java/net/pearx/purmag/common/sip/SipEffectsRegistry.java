package net.pearx.purmag.common.sip;

import net.minecraft.init.MobEffects;
import net.pearx.purmag.PurMag;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrAppleXZ on 21.05.17 17:09.
 */
public class SipEffectsRegistry
{
    private Map<String, SipEffect> map = new HashMap<>();

    public Map<String, SipEffect> getMap()
    {
        return map;
    }

    public void setup()
    {
        getMap().put("rock", new SipEffect(MobEffects.RESISTANCE, 3, -1));
        getMap().put("sea", new SipEffect(MobEffects.WATER_BREATHING, 3, -1));
        getMap().put("flame", new SipEffect(MobEffects.FIRE_RESISTANCE, 3, -1));
        getMap().put("air", new SipEffect(MobEffects.SPEED, 3, -1));
        getMap().put("information", new SipEffect(MobEffects.BLINDNESS, 1, -1));
    }
}
