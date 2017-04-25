package net.pearx.purmag;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.pearx.purmag.common.CapabilityRegistry;
import net.pearx.purmag.common.CommonProxy;
import net.pearx.purmag.common.CommonEvents;
import net.pearx.purmag.common.SoundRegistry;
import net.pearx.purmag.common.blocks.BlockRegistry;
import net.pearx.purmag.common.infofield.IfRegistry;
import net.pearx.purmag.common.items.ItemRegistry;
import net.pearx.purmag.common.networking.NetworkManager;
import net.pearx.purmag.common.sip.SipTypeRegistry;
import net.pearx.purmag.common.tiles.TileRegistry;
import net.pearx.purmag.server.commands.CommandIf;

import java.util.ArrayList;

/**
 * Created by mrAppleXZ on 08.04.17 10:31.
 */
@Mod(name = PurMag.Name, modid = PurMag.ModId)
public class PurMag
{
    public static PurMag instance;

    public static final String ModId = "purmag";
    public static final String Name = "Purificati Magicae";
    public static final String Version = "1.0.0";

    public SipTypeRegistry sip = new SipTypeRegistry();
    public IfRegistry if_registry = new IfRegistry();

    @SidedProxy(clientSide = "net.pearx.purmag.client.ClientProxy", serverSide = "net.pearx.purmag.server.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        instance = this;
        setupMetadata(e.getModMetadata());
        BlockRegistry.setup();
        ItemRegistry.setup();
        TileRegistry.setup();
        SoundRegistry.setup();
        sip.setup();
        if_registry.setup();
        CapabilityRegistry.setup();
        NetworkManager.setup();

        proxy.preInit();
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init();
    }

    public void setupMetadata(ModMetadata data)
    {
        data.autogenerated = false;
        ArrayList<String> a = new ArrayList<>();
        a.add("mrAppleXZ");
        data.credits = "DrVexsear - many ideas\nafdw & Prototik - cool guys";
        data.authorList = a;
        data.description = "Purificati Magicae";
        data.modId = PurMag.ModId;
        data.name = PurMag.Name;
        data.version = PurMag.Version;
    }

    @Mod.EventHandler
    public void serverStartup(FMLServerStartingEvent e)
    {
        e.registerServerCommand(new CommandIf());
    }
}
