package net.pearx.purmag.common;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

/**
 * Created by mrAppleXZ on 09.05.17 18:23.
 */
public class GlobalChunkPos
{
    private int dimension;
    private int x;
    private int z;

    public GlobalChunkPos(int x, int z, int dim)
    {
        setDimension(dim);
        setX(x);
        setZ(z);
    }

    public int getDimension()
    {
        return dimension;
    }

    public void setDimension(int dimension)
    {
        this.dimension = dimension;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getZ()
    {
        return z;
    }

    public void setZ(int z)
    {
        this.z = z;
    }

    public ChunkPos toChunkPos()
    {
        return new ChunkPos(getX(), getZ());
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof GlobalChunkPos))
            return false;
        GlobalChunkPos gcp = (GlobalChunkPos)o;
        return gcp.getX() == getX() && gcp.getZ() == getZ() && gcp.getDimension() == getDimension();
    }

    public static GlobalChunkPos fromChunk(Chunk ch)
    {
        return new GlobalChunkPos(ch.x, ch.z, ch.getWorld().provider.getDimension());
    }

    @Override
    public int hashCode()
    {
        int result = dimension;
        result = 31 * result + x;
        result = 31 * result + z;
        return result;
    }
}
