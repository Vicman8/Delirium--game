package Scripts.ACParts;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCChangeVisibilityScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import ScriptActions.WaitScriptAction;
import Utils.Visibility;

public class EvaporatorCoilScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("GrabbedEvapCoil", false));

                addScriptAction(new WaitScriptAction(70));
                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("You picked up the Evaporator Coil");
                   
                }});


             

                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));

                

                addScriptAction(new ChangeFlagScriptAction("GrabbedEvapCoil", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}
