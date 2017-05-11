package net.pearx.purmag.common.networking;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.pearx.purmag.PurMag;
import net.pearx.purmag.common.networking.packets.CPacketDisplayMessage;
import net.pearx.purmag.common.networking.packets.CPacketSyncEntryStore;
import net.pearx.purmag.common.networking.packets.CPacketSyncSif;

/**
 * Created by mrAppleXZ on 23.04.17 11:23.
 */
public class NetworkManager
{
    private static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(PurMag.ModId);
    private static int id = 0;

    public static void setup()
    {
        INSTANCE.registerMessage(CPacketSyncEntryStore.Handler.class, CPacketSyncEntryStore.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(CPacketDisplayMessage.Handler.class, CPacketDisplayMessage.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(CPacketSyncSif.Handler.class, CPacketSyncSif.class, id++, Side.CLIENT);
    }

    public static void sendTo(IMessage msg, EntityPlayerMP p)
    {
        INSTANCE.sendTo(msg, p);
    }

    public static void sendToAllAround(IMessage msg, int x, int y, int z, int dim, int radius)
    {
        INSTANCE.sendToAllAround(msg, new NetworkRegistry.TargetPoint(dim, x, y, z, radius));
    }

    public static void sendToServer(IMessage msg)
    {
        INSTANCE.sendToServer(msg);
    }
}
