package Scripts.MyMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class StudentScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToStudent", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Sweaty Student: Hey. You may have a better time \ncooling off some other way.");
                    addText("Kaegen: The line’s too long!\nIt's going outside the bathroom door!");
                    addText("Kaegen: Guess it’s time to use the fan in my room\nagain");
                    addText("Kaegen: It’s been so long since I’ve showered.");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToStudent", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToStudent", true));
                addScriptAction(new TextboxScriptAction("Kaegen: I should head back to my room.\nThe fan always works when I need it to."));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}