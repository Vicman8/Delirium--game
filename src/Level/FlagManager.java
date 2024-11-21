package Level;

import java.util.HashMap;
import java.util.Map.Entry;

public class FlagManager {
    protected static HashMap<String, Boolean> flags = new HashMap<>();

    public void addFlag(String flagName) {
        FlagManager.flags.put(flagName, false);
    }

    public void addFlag(String flagName, boolean startingValue) {
        FlagManager.flags.put(flagName, startingValue);
    }

    public static void setFlag(String flagName) {
        if (flags.containsKey(flagName)) {
            FlagManager.flags.put(flagName, true);
        }
    }

    public void unsetFlag(String flagName) {
        if (flags.containsKey(flagName)) {
            FlagManager.flags.put(flagName, false);
        }
    }

    public void reset() {
        for (Entry<String, Boolean> entry : FlagManager.flags.entrySet()) {
            entry.setValue(false);
        }
    }

    public static boolean isFlagSet(String flagName) {
        if (FlagManager.flags.containsKey(flagName)) {
            return FlagManager.flags.get(flagName);
        }
        return false;
    }
}
