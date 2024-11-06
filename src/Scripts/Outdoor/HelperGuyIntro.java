package Scripts.Outdoor;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;


public class HelperGuyIntro extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Hey there! I'm a helper guy!");
            addText("You'll see me around, remember you can press p \nat anytime to pause the game!");
            addText("Talk to me for helpful info!");
            addText("For example... there's some weird dude trying to \nsell 'water' over at Dana to the left...");

            
        }});

        

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
