package com.celestia.ritual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joml.Vector3f;

import com.celestia.entity.AstraDragonEntity;
import com.celestia.entity.ModEntities;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

/**
 * The summoning ritual started by using Everys on the Star Altar. Lasts 5 seconds:
 * a spiral of stardust closes in and rises, chimes speed up, a shock ring bursts out,
 * lightning strikes the altar and Huya, the Violet Star Dragon, appears above it.
 */
public final class StarRituals {
    public static final int DURATION = 100;
    private static final Vector3f PURPLE = new Vector3f(0.62f, 0.36f, 1.0f);
    private static final Vector3f PINK = new Vector3f(1.0f, 0.6f, 0.85f);
    private static final Vector3f GOLD = new Vector3f(1.0f, 0.85f, 0.4f);

    private record Ritual(ServerWorld world, BlockPos pos, int[] t) {
    }

    private static final List<Ritual> ACTIVE = new ArrayList<>();

    public static boolean isRunningAt(ServerWorld world, BlockPos pos) {
        return ACTIVE.stream().anyMatch(r -> r.world() == world && r.pos().equals(pos));
    }

    public static boolean dragonNearby(ServerWorld world, BlockPos pos) {
        return !world.getEntitiesByClass(AstraDragonEntity.class, new Box(pos).expand(96), e -> e.isAlive()).isEmpty();
    }

    public static void start(ServerWorld world, BlockPos pos) {
        ACTIVE.add(new Ritual(world, pos.toImmutable(), new int[] {0}));
        world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS, 2.0f, 0.6f);
        world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 3.0f, 0.7f);
        for (var p : world.getPlayers(p -> p.squaredDistanceTo(Vec3d.ofCenter(pos)) < 48 * 48)) {
            p.sendMessage(Text.translatable("ritual.celestia.start").formatted(Formatting.LIGHT_PURPLE, Formatting.ITALIC), true);
        }
    }

    public static void init() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            Iterator<Ritual> it = ACTIVE.iterator();
            while (it.hasNext()) {
                Ritual r = it.next();
                int t = ++r.t()[0];
                tick(r.world(), r.pos(), t);
                if (t >= DURATION) {
                    it.remove();
                }
            }
        });
    }

    private static void tick(ServerWorld w, BlockPos pos, int t) {
        Vec3d c = Vec3d.ofCenter(pos).add(0, 0.6, 0);
        float k = t / (float) DURATION;
        // 1) converging double spiral of stardust
        double radius = 6.0 * (1 - k) + 0.6;
        for (int arm = 0; arm < 2; arm++) {
            double a = t * 0.35 + arm * Math.PI;
            double y = (t % 20) * 0.15;
            w.spawnParticles(new DustParticleEffect(arm == 0 ? PURPLE : PINK, 1.6f),
                    c.x + Math.cos(a) * radius, c.y + y, c.z + Math.sin(a) * radius, 2, 0.05, 0.05, 0.05, 0);
            w.spawnParticles(ParticleTypes.END_ROD, c.x + Math.cos(a) * radius, c.y + y, c.z + Math.sin(a) * radius, 1, 0, 0, 0, 0.01);
        }
        // 2) a rising beam over the altar that grows brighter
        if (t > 30) {
            for (int i = 0; i < 1 + t / 25; i++) {
                w.spawnParticles(ParticleTypes.END_ROD, c.x, c.y + w.random.nextDouble() * 12 * k, c.z, 1, 0.08, 0.2, 0.08, 0.02);
            }
            w.spawnParticles(ParticleTypes.PORTAL, c.x, c.y + 1, c.z, 6, 0.5, 1.0, 0.5, 0.6);
        }
        // 3) chimes speeding up
        int every = t < 50 ? 10 : (t < 80 ? 5 : 2);
        if (t % every == 0) {
            w.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 2.0f, 0.5f + k * 1.5f);
        }
        // 4) shock ring
        if (t == 80) {
            for (int i = 0; i < 72; i++) {
                double a = i * Math.PI * 2 / 72;
                w.spawnParticles(new DustParticleEffect(GOLD, 2.0f), c.x, c.y, c.z, 0, Math.cos(a), 0, Math.sin(a), 0.6);
                w.spawnParticles(ParticleTypes.END_ROD, c.x, c.y, c.z, 0, Math.cos(a), 0.05, Math.sin(a), 0.5);
            }
            w.playSound(null, pos, SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0f, 1.4f);
        }
        // 5) lightning + the dragon
        if (t == DURATION) {
            LightningEntity bolt = EntityType.LIGHTNING_BOLT.create(w);
            if (bolt != null) {
                bolt.refreshPositionAfterTeleport(c.x, c.y, c.z);
                bolt.setCosmetic(true);
                w.spawnEntity(bolt);
            }
            w.spawnParticles(ParticleTypes.EXPLOSION_EMITTER, c.x, c.y + 3, c.z, 1, 0, 0, 0, 0);
            w.spawnParticles(ParticleTypes.FIREWORK, c.x, c.y + 4, c.z, 150, 1.5, 2, 1.5, 0.35);
            AstraDragonEntity dragon = ModEntities.ASTRA_DRAGON.create(w, null, pos.up(6), SpawnReason.EVENT, false, false);
            if (dragon != null) {
                dragon.setHome(pos);
                w.spawnEntity(dragon);
            }
            w.playSound(null, pos, SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.HOSTILE, 8.0f, 0.75f);
            for (var p : w.getPlayers(p -> p.squaredDistanceTo(c) < 96 * 96)) {
                p.sendMessage(Text.translatable("ritual.celestia.awaken").formatted(Formatting.DARK_PURPLE, Formatting.BOLD), true);
            }
        }
    }

    private StarRituals() {
    }
}
