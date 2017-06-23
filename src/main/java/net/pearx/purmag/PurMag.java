package net.pearx.purmag;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.pearx.purmag.common.*;
import net.pearx.purmag.common.blocks.BlockRegistry;
import net.pearx.purmag.common.config.PMConfig;
import net.pearx.purmag.common.entities.EntityRegistry;
import net.pearx.purmag.common.infofield.IfRegistry;
import net.pearx.purmag.common.items.ItemRegistry;
import net.pearx.purmag.common.items.papyrus.ItemPapyrus;
import net.pearx.purmag.common.networking.NetworkManager;
import net.pearx.purmag.common.sif.SifEvents;
import net.pearx.purmag.common.sip.SipEffectsRegistry;
import net.pearx.purmag.common.sip.SipEvents;
import net.pearx.purmag.common.sip.SipTypeRegistry;
import net.pearx.purmag.common.tiles.TileRegistry;
import net.pearx.purmag.common.worldgen.WorldgenRegistry;
import net.pearx.purmag.common.commands.CommandIf;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrAppleXZ on 08.04.17 10:31.
 */
@Mod(name = PurMag.Name, modid = PurMag.ModId)
public class PurMag
{
    //todo laboratory, smeltery, SIF plant, agronomy, paris, import plumfero texture, end translation desk, add beetle loot
    public static PurMag instance;

    public static Random rand = new Random();

    public static final String ModId = "purmag";
    public static final String Name = "Purificati Magicae";
    public static final String Version = "1.0.0";

    public SipTypeRegistry sip = new SipTypeRegistry();
    public SipEffectsRegistry sip_effects = new SipEffectsRegistry();
    public IfRegistry if_registry = new IfRegistry();
    public PMConfig config = new PMConfig();

    @SidedProxy(clientSide = "net.pearx.purmag.client.ClientProxy", serverSide = "net.pearx.purmag.server.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        instance = this;
        setupMetadata(e.getModMetadata());

        config.setup(new Configuration(new File(e.getModConfigurationDirectory(), "Purificati Magicae.cfg")));

        sip.setup();
        sip_effects.setup();
        BlockRegistry.setup();
        ItemRegistry.setup();
        ItemPapyrus.setup();
        TileRegistry.setup();
        if_registry.setup();
        SoundRegistry.setup();
        CapabilityRegistry.setup();
        NetworkManager.setup();
        WorldgenRegistry.setup();
        EntityRegistry.setup();

        proxy.preInit();
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
        MinecraftForge.EVENT_BUS.register(new SifEvents());
        MinecraftForge.EVENT_BUS.register(new SipEvents());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {

        proxy.init();
    }

    private void setupMetadata(ModMetadata data)
    {
        data.autogenerated = false;
        data.credits = "afdw & Prototik - cool guys";
        data.authorList = Arrays.asList("mrAppleXZ", "DrVexsear");
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
