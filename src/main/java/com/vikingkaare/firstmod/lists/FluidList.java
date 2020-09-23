package com.vikingkaare.firstmod.lists;

import com.vikingkaare.firstmod.events.RegistryEvents;
import com.vikingkaare.firstmod.objects.fluids.FluidOil;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;

public class FluidList {

    public static FluidOil.Source oil = null;
    public static FluidOil.Flowing flowing_oil = null;

    public static class Tags {
        public static final Tag<Fluid> OIL = new FluidTags.Wrapper(RegistryEvents.location("oil"));
    }

}
