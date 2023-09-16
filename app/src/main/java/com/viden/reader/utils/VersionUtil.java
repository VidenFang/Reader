package com.viden.reader.utils;

import com.viden.reader.BuildConfig;

public class VersionUtil {

    public static boolean isNewVersion(String versionTag) {
        String newVersion = versionTag.replace("v", "");
        String[] newVersions = newVersion.split("\\.");
        String[] oldVersions = BuildConfig.VERSION_NAME.split("\\.");
        try {
            for (int i = 0; i < newVersions.length; i++) {
                if (Integer.parseInt(newVersions[i]) > Integer.parseInt(oldVersions[i])) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
