package onlysole.imaginarynumbertech.api.capability.pollution;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class PollutionProvider implements ICapabilitySerializable<NBTTagCompound> {
    private final Impl instance = new Impl();
    private final Storage storage = new Storage();

    @CapabilityInject(IPollution.class)
    public static Capability<IPollution> pollution = null;

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == pollution;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == pollution) return pollution.cast(instance);
        return null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("pollution", Objects.requireNonNull(storage.writeNBT(pollution, instance, null)));
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        storage.readNBT(pollution, instance, null, nbt.getTag("pollution"));
    }

    public static class Storage implements Capability.IStorage<IPollution> {

        @Nullable
        @Override
        public NBTBase writeNBT(Capability<IPollution> capability, IPollution instance, EnumFacing side) {
            return new NBTTagLong(instance.getPollution());
        }

        @Override
        public void readNBT(Capability<IPollution> capability, IPollution instance, EnumFacing side, NBTBase nbt) {
            // 在Java 8中，需要进行显式的类型转换
            if (nbt instanceof NBTTagLong) {
                NBTTagLong tag = (NBTTagLong) nbt;
                instance.setPollution(tag.getLong());
            }
        }
    }


    public static class Impl implements IPollution {
        private long pollution;

        @Override
        public long getPollution() {
            return pollution;
        }

        @Override
        public void setPollution(long newAmount) {
            this.pollution = newAmount;
        }

        @Override
        public void addPollution(long amount) {
            this.pollution = pollution + amount;
        }

        @Override
        public void minusPollution(long amount) {
            this.pollution = pollution - amount;
        }
    }
}
