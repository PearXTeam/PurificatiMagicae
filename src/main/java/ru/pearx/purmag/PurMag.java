package ru.pearx.purmag;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import ru.pearx.purmag.common.config.PMConfig;
import ru.pearx.purmag.common.entities.EntityRegistry;
import ru.pearx.purmag.common.infofield.IfRegistry;
import ru.pearx.purmag.common.items.ItemRegistry;
import ru.pearx.purmag.common.items.papyrus.ItemPapyrus;
import ru.pearx.purmag.common.loot_tables.LootTablesRegistry;
import ru.pearx.purmag.common.networking.NetworkManager;
import ru.pearx.purmag.common.recipes.RecipeRegistry;
import ru.pearx.purmag.common.sif.SifStorageServer;
import ru.pearx.purmag.common.sip.SipEffectsRegistry;
import ru.pearx.purmag.common.sip.SipTypeRegistry;
import ru.pearx.purmag.common.tiles.TileRegistry;
import ru.pearx.purmag.common.worldgen.WorldgenRegistry;
import ru.pearx.purmag.common.commands.CommandIf;
import ru.pearx.purmag.common.CapabilityRegistry;
import ru.pearx.purmag.common.CommonProxy;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrAppleXZ on 08.04.17 10:31.
 */
@Mod(name = PurMag.NAME, modid = PurMag.MODID)
public class PurMag
{
    //todo laboratory
    //todo smeltery
    //todo SIF plant, agronomy, paris,
    //todo glove modules and upgrades
    //todo time jail
    //todo microscope
    //todo remote redstone controller
    @Mod.Instance
    public static PurMag INSTANCE;

    public static final String MODID = "purmag";
    public static final String NAME = "Purificati Magicae";
    public static final String VERSION = "@VERSION@";

    public SipTypeRegistry sip = new SipTypeRegistry();
    public SipEffectsRegistry sip_effects = new SipEffectsRegistry();
    public IfRegistry if_registry = new IfRegistry();
    public PMConfig config = new PMConfig();
    public Random random = new Random();
    public Logger log;

    public SifStorageServer sif_storage = new SifStorageServer();

    @SidedProxy(clientSide = "ru.pearx.purmag.client.ClientProxy", serverSide = "ru.pearx.purmag.server.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        log = e.getModLog();
        setupMetadata(e.getModMetadata());

        config.setup(new Configuration(new File(e.getModConfigurationDirectory(), "Purificati Magicae.cfg")));

        proxy.setupDrawables();
        sip.register();
        TileRegistry.register();
        CapabilityRegistry.register();
        EntityRegistry.register();

        proxy.setupIfTiers();

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        sip_effects.register();
        ItemRegistry.setup();
        ItemPapyrus.setup();
        if_registry.setup();
        NetworkManager.setup();
        WorldgenRegistry.setup();
        LootTablesRegistry.setup();
        RecipeRegistry.setup();

        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        EntityRegistry.setupSpawns();
    }

    private void setupMetadata(ModMetadata data)
    {
        data.autogenerated = false;
        data.credits = "afdw & Prototik - cool guys";
        data.authorList = Arrays.asList("mrAppleXZ", "DrVexsear");
        data.description = "Purificati Magicae";
        data.modId = PurMag.MODID;
        data.name = PurMag.NAME;
        data.version = PurMag.VERSION;
    }

    @Mod.EventHandler
    public void serverStartup(FMLServerStartingEvent e)
    {
        e.registerServerCommand(new CommandIf());
    }
}
