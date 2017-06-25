package net.pearx.purmag.common.sif;

import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.purmag.PurMag;
import net.pearx.purmag.common.GlobalChunkPos;
import net.pearx.purmag.common.networking.NetworkManager;
import net.pearx.purmag.common.networking.packets.CPacketSyncSif;

/**
 * Created by mrAppleXZ on 13.05.17 9:25.
 */
@Mod.EventBusSubscriber(modid = PurMag.MODID)
public class SifEvents
{
    @SubscribeEvent
    public static void onChunkSave(ChunkDataEvent.Save e)
    {
        e.getData().setFloat("sif_power", PurMag.proxy.getSifStorage().getPower(GlobalChunkPos.fromChunk(e.getChunk())));
    }

    @SubscribeEvent
    public static void onChunkLoad(ChunkDataEvent.Load e)
    {
        PurMag.proxy.getSifStorage().setPower(GlobalChunkPos.fromChunk(e.getChunk()), e.getData().getFloat("sif_power"));
    }

    @SubscribeEvent
    public static void onChunkUnload(ChunkEvent.Unload e)
    {
        PurMag.proxy.getSifStorage().removeChunk(GlobalChunkPos.fromChunk(e.getChunk()));
    }

    @SubscribeEvent
    @SideOnly(Side.SERVER)
    public static void onChunkWatch(ChunkWatchEvent.Watch e)
    {
        GlobalChunkPos pos = new GlobalChunkPos(e.getChunk().x, e.getChunk().z, e.getPlayer().world.provider.getDimension());
        NetworkManager.sendTo(new CPacketSyncSif(pos, false, PurMag.proxy.getSifStorage().getPower(pos)), e.getPlayer());
    }

    @SubscribeEvent
    @SideOnly(Side.SERVER)
    public static void onChunkUnwatch(ChunkWatchEvent.UnWatch e)
    {
        GlobalChunkPos pos = new GlobalChunkPos(e.getChunk().x, e.getChunk().z, e.getPlayer().world.provider.getDimension());
        NetworkManager.sendTo(new CPacketSyncSif(pos, true, 0), e.getPlayer());
    }
}
