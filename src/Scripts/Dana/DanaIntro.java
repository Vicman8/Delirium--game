package Scripts.Dana;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class DanaIntro extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Preeda: Did you ACTUALLY fight a black bear?!");
            addText("Kaegen: I suppose I did.\nMultiple people came up to me and asked me if I was fine.");
            addText("Preeda: Don’t you ever attempt anything like that again!\nYou could’ve been killed!");
            addText("Kaegen: Fine.");
            addText("Preeda: Wait, didn’t you say you were going to the dining hall?\nLemme grab you something.");
            addText("Kaegen: Thanks.");
            addText("Kaegen: It seems hotter.\nAre you guys having an A.C problem too?!");
            addText("Preeda: Not really. Today’s just a hot day.");
            addText("Kaegen: I... feel hot again. ");
            addText("Preeda: Kaegen?!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("introStarted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
