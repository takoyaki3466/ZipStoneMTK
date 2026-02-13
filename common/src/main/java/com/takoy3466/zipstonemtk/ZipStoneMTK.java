package com.takoy3466.zipstonemtk;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import com.takoy3466.zipstonemtk.init.TabsInit;

public final class ZipStoneMTK {
    public static final String MOD_ID = "zipstonemtk";

    public static void init() {
        // Write common init code here.
        TabsInit.init();
        BlocksInit.init();

    }
}
