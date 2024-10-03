package Scripts.MyMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class FanScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{

            //Add a condition for when Kaegen does attempt to use the fan when he hasn't visited the student
    
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToFan", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Kaegen turns on the fan.");
                    addText("After blowing air for a few seconds, it short-circuits.");
                    addText("Kaegen: Ok! I've had enough of this!");
                    addText("GIVE ME A.C OR GIVE ME DEATH!!!!");
                    addText("I... feel weak. ");
                    addText("Shouldn’t... have... shouted.");
                }});
                addScriptAction(new ChangeFlagScriptAction("fanHasDied", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("fanHasDied", true));
                addScriptAction(new TextboxScriptAction("This fan has short-circuited./nThis is getting out of hand."));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}