package cz.grossik.farmcraft2.jei;

import javax.annotation.Nonnull;

public class JeiAccessor {

  static boolean jeiRuntimeAvailable = false;

  public static boolean isJeiRuntimeAvailable() {
    return jeiRuntimeAvailable;
  }

  public static void setFilterText(@Nonnull String filterText) {
    if (jeiRuntimeAvailable) {
    	JEIFarmCraft2Plugin.setFilterText(filterText);
    }
  }

  public static @Nonnull String getFilterText() {
    if (jeiRuntimeAvailable) {
      return JEIFarmCraft2Plugin.getFilterText();
    }
    return "";
  }

}