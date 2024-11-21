package Scripts.ACParts;

import java.util.ArrayList;

import Game.ScreenCoordinator;
import Level.Script;
import Level.ScriptState;
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

public class CondensingCoilScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("GrabbedConCoil", false));

                addScriptAction(new WaitScriptAction(70));
                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("You picked up the Condensing Coil");
                   
   addScriptAction(new ScriptAction() {
                        @Override
                        public ScriptState execute() {
                            // change door to the open door map tile
                            ScreenCoordinator.condensing = true;                
                           
                            return ScriptState.COMPLETED;
                        }
                    });



                }});


             

                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));

                                

                addScriptAction(new ChangeFlagScriptAction("GrabbedConCoil", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}
