package Scripts.Field;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class Foiled extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("???: Curses! I've been foiled!");
            addText("???: Curse you King Thimineur!\n Curse you Public Safety Knight!");
            addText("???: Oh look. It's that kid.");
            addText("???: What business does he have with that bear?");
        }});

        scriptActions.add(new ChangeFlagScriptAction("danaIntroed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
