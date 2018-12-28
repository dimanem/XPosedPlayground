package com.example.diman.simplexposedmodule;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SimpleGameModule implements IXposedHookLoadPackage {

  @Override public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
    // Hook only my app
    if (!loadPackageParam.packageName.equals("com.example.diman.simplegame")) {
      return;
    }

    // Hook method com.example.diman.simplehookedapp.PlayerStorage.calcGamesLeft().
    // Return number of games left is 3 regardless number of games played
    try {
      XposedHelpers.findAndHookMethod("com.example.diman.simplegame.PlayerStorage",
          loadPackageParam.classLoader, "calcGamesLeft", (Object[]) new Object[] {
              "int", new XC_MethodHook() {

            protected void afterHookedMethod(MethodHookParam methodHookParam) {
              // Keep remaining games left 3
              methodHookParam.setResult(3);
            }
          }
          });
    } catch (Exception e) {
      XposedBridge.log(e);
    }
  }
}
