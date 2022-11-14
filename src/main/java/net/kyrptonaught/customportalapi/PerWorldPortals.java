package net.kyrptonaught.customportalapi;

import net.kyrptonaught.customportalapi.util.PortalLink;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PerWorldPortals {
    private static final Set<Identifier> worldPortals = ConcurrentHashMap.newKeySet();

    public static void removeOldPortalsFromRegistry() {
        for (Identifier id : worldPortals) {
            CustomPortalApiRegistry.portals.remove(id);
        }
        worldPortals.clear();
    }

    public static void registerWorldPortal(PortalLink portalLink) {
        if (!CustomPortalApiRegistry.portals.containsKey(portalLink.id)) {
            Block blockId = Registry.BLOCK.get(portalLink.block);
            worldPortals.add(portalLink.id);
            CustomPortalApiRegistry.addPortal(blockId, portalLink);
        }
    }
}
