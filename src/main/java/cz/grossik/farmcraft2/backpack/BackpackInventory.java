package cz.grossik.farmcraft2.backpack;

import com.google.common.collect.Lists;
import net.minecraftforge.items.ItemStackHandler;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class BackpackInventory extends ItemStackHandler
{
    public static final int SLOT_COUNT = 27;

    private final IInventoryManager manager;

    final List<Reference<? extends TileBackpack>> listeners = Lists.newArrayList();
    final ReferenceQueue<TileBackpack> deadListeners = new ReferenceQueue<TileBackpack>();

    public void addWeakListener(TileBackpack e)
    {
        listeners.add(new WeakReference<TileBackpack>(e, deadListeners));
    }

    @Override
    protected void onContentsChanged(int slot)
    {
        super.onContentsChanged(slot);

        for (Reference<? extends TileBackpack>
             ref = deadListeners.poll();
             ref != null;
             ref = deadListeners.poll())
        {
            listeners.remove(ref);
        }

        for (Iterator<Reference<? extends TileBackpack>> it = listeners.iterator(); it.hasNext(); )
        {
        	TileBackpack rift = it.next().get();
            if (rift == null || rift.isInvalid())
            {
                it.remove();
            }
            else
            {
                rift.markDirty();
            }
        }

        manager.setDirty();
    }

    BackpackInventory(IInventoryManager manager)
    {
        super(SLOT_COUNT);
        this.manager = manager;
    }
}