package ru.pearx.purmag.client;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.purmag.client.sif.SifStorageClient;

/**
 * Created by mrAppleXZ on 27.06.17 15:38.
 */
@SideOnly(Side.CLIENT)
public class PurMagClient
{
    public static final PurMagClient INSTANCE = new PurMagClient();

    public SifStorageClient sif_storage = new SifStorageClient();
}