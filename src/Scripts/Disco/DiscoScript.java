package Scripts.Disco;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCStandScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import Utils.Direction;

public class DiscoScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        
        scriptActions.add(new LockPlayerScriptAction());

        
        

        scriptActions.add(new TextboxScriptAction() {{
            addText("I FEEL A SONG COMING ON, I GOTTA DANCE!");
            
        }});


        scriptActions.add(new ChangeFlagScriptAction("DiscoStart", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
