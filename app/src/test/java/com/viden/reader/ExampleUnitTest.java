package com.viden.reader;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isNewVersion() {
        String versionTag = "v1.12.8";
        System.out.println(isNewVersion(versionTag));
    }

    public boolean isNewVersion(String versionTag) {
        String newVersion = versionTag.replace("v", "");
        String[] newVersions = newVersion.split("\\.");
        String[] oldVersions = "0.12.8".split("\\.");
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