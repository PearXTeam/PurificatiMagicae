package net.pearx.purmag.common.infofield.playerdata;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.pearx.purmag.common.CapabilityRegistry;
import net.pearx.purmag.common.Utils;

import javax.annotation.Nullable;

/**
 * Created by mrAppleXZ on 22.04.17 18:18.
 */
public class IfEntryStoreProvier implements ICapabilitySerializable<NBTTagCompound>
{
    public IIfEntryStore cap = new IfEntryStore();

    @Override
    public NBTTagCompound serializeNBT()
    {
        return cap.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        cap.deserializeNBT(nbt);
    }


    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == CapabilityRegistry.ENTRY_STORE_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if(capability == CapabilityRegistry.ENTRY_STORE_CAPABILITY)
            return CapabilityRegistry.ENTRY_STORE_CAPABILITY.cast(cap);

        return null;
    }
}
