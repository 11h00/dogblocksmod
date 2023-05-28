/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.useless.dogblockmod;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class DogblockmodModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();

	public DogblockmodModElements() {
		sounds.put(new ResourceLocation("dogblockmod", "whitezone"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "whitezone")));
		sounds.put(new ResourceLocation("dogblockmod", "elevator_done"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "elevator_done")));
		sounds.put(new ResourceLocation("dogblockmod", "hescoming"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "hescoming")));
		sounds.put(new ResourceLocation("dogblockmod", "unlucky"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "unlucky")));
		sounds.put(new ResourceLocation("dogblockmod", "nothing"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "nothing")));
		sounds.put(new ResourceLocation("dogblockmod", "diamonboxopened"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "diamonboxopened")));
		sounds.put(new ResourceLocation("dogblockmod", "openbox"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "openbox")));
		sounds.put(new ResourceLocation("dogblockmod", "mediumdoghurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "mediumdoghurt")));
		sounds.put(new ResourceLocation("dogblockmod", "mediumdogdeath"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "mediumdogdeath")));
		sounds.put(new ResourceLocation("dogblockmod", "bigdoghurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bigdoghurt")));
		sounds.put(new ResourceLocation("dogblockmod", "bigdogdeath"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bigdogdeath")));
		sounds.put(new ResourceLocation("dogblockmod", "bosshurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bosshurt")));
		sounds.put(new ResourceLocation("dogblockmod", "bossdeath"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bossdeath")));
		sounds.put(new ResourceLocation("dogblockmod", "babydogkilled"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "babydogkilled")));
		sounds.put(new ResourceLocation("dogblockmod", "babydogshurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "babydogshurt")));
		sounds.put(new ResourceLocation("dogblockmod", "fz3bgm"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "fz3bgm")));
		sounds.put(new ResourceLocation("dogblockmod", "floora1bgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "floora1bgm")));
		sounds.put(new ResourceLocation("dogblockmod", "floora2bgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "floora2bgm")));
		sounds.put(new ResourceLocation("dogblockmod", "flooraabgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "flooraabgm")));
		sounds.put(new ResourceLocation("dogblockmod", "floorr1bgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "floorr1bgm")));
		sounds.put(new ResourceLocation("dogblockmod", "floora2altbgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "floora2altbgm")));
		sounds.put(new ResourceLocation("dogblockmod", "dogtrap"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "dogtrap")));
		sounds.put(new ResourceLocation("dogblockmod", "floorpe"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "floorpe")));
		sounds.put(new ResourceLocation("dogblockmod", "red_space"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "red_space")));
		sounds.put(new ResourceLocation("dogblockmod", "blue_space"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "blue_space")));
		sounds.put(new ResourceLocation("dogblockmod", "brown_space"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "brown_space")));
		sounds.put(new ResourceLocation("dogblockmod", "harddog_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "harddog_hurt")));
		sounds.put(new ResourceLocation("dogblockmod", "harddog_death"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "harddog_death")));
		sounds.put(new ResourceLocation("dogblockmod", "cryingdog"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "cryingdog")));
		sounds.put(new ResourceLocation("dogblockmod", "patiencedoghurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "patiencedoghurt")));
		sounds.put(new ResourceLocation("dogblockmod", "patiencedog_death"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "patiencedog_death")));
		sounds.put(new ResourceLocation("dogblockmod", "bgmfloor01"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bgmfloor01")));
		sounds.put(new ResourceLocation("dogblockmod", "bgmfloor02"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bgmfloor02")));
		sounds.put(new ResourceLocation("dogblockmod", "corrupteddoghurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "corrupteddoghurt")));
		sounds.put(new ResourceLocation("dogblockmod", "corrupteddogdeath"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "corrupteddogdeath")));
		sounds.put(new ResourceLocation("dogblockmod", "inlove"), new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "inlove")));
		sounds.put(new ResourceLocation("dogblockmod", "patiencedogkilled"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "patiencedogkilled")));
		sounds.put(new ResourceLocation("dogblockmod", "finalbossdeath"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "finalbossdeath")));
		sounds.put(new ResourceLocation("dogblockmod", "bluezonebgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bluezonebgm")));
		sounds.put(new ResourceLocation("dogblockmod", "blackzone"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "blackzone")));
		sounds.put(new ResourceLocation("dogblockmod", "blackzonedeep"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "blackzonedeep")));
		sounds.put(new ResourceLocation("dogblockmod", "blackzoneverydeep"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "blackzoneverydeep")));
		sounds.put(new ResourceLocation("dogblockmod", "bgmfloor12"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "bgmfloor12")));
		sounds.put(new ResourceLocation("dogblockmod", "waterzonebgm"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "waterzonebgm")));
		sounds.put(new ResourceLocation("dogblockmod", "marketplace"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("dogblockmod", "marketplace")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("dogblockmod").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == DogblockmodModElements.ModElement.class)
						elements.add((DogblockmodModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(DogblockmodModElements.ModElement::initElements);
		MinecraftForge.EVENT_BUS.register(new DogblockmodModVariables(this));
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}

	private int messageID = 0;

	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		DogblockmodMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}

	public List<Supplier<Enchantment>> getEnchantments() {
		return enchantments;
	}

	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}

		protected final DogblockmodModElements elements;
		protected final int sortid;

		public ModElement(DogblockmodModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
