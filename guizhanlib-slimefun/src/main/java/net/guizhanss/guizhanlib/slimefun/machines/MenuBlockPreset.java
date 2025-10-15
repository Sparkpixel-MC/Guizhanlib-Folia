package net.guizhanss.guizhanlib.slimefun.machines;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A {@link MenuBlockPreset} is a preset of a menu block.
 * <p>
 * Modified from InfinityLib.
 *
 * @author Mooy1
 * @author ybw0014
 */
final class MenuBlockPreset extends BlockMenuPreset {

    private final MenuBlock menuBlock;

    @ParametersAreNonnullByDefault
    MenuBlockPreset(MenuBlock menuBlock) {
        super(menuBlock.getId(), menuBlock.getItemName());
        this.menuBlock = menuBlock;
        menuBlock.setup(this);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void newInstance(BlockMenu menu, Block b) {
        menuBlock.onNewInstance(menu, b);
    }

    @ParametersAreNonnullByDefault
    @Override
    public int[] getSlotsAccessedByItemTransport(DirtyChestMenu menu, ItemTransportFlow flow, ItemStack item) {
        return menuBlock.getTransportSlots(menu, flow, item);
    }

    @Override
    public void init() {
        // do nothing yet
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean canOpen(Block b, Player p) {
        return Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK)
            && menuBlock.canUse(p, false);
    }

    @ParametersAreNonnullByDefault
    @Override
    public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
        return new int[0];
    }
}
