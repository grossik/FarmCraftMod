package cz.grossik.farmcraft2.backpack;

public interface IInventoryManager
{
    void setDirty();

    BackpackInventory getInventory(int id);
}