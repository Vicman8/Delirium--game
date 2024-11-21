package Scripts.ACParts;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;
import Level.MapTile;
import Level.Script;
import Level.ScriptState;
import Level.TileType;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCChangeVisibilityScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCStandScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.NPCWalkScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import ScriptActions.WaitScriptAction;
import Utils.Point;
import Utils.Visibility;

public class CompressorScript extends Script{
     protected static boolean compressor = false;
    
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("GrabbedCompressor", false));

                addScriptAction(new WaitScriptAction(70));
                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("You picked up the Compressor");

                }});
                
                
                
                
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                
                
                
                addScriptAction(new ChangeFlagScriptAction("GrabbedCompressor", true));
            }});
        }});
        
        compressor = true;

        scriptActions.add(new UnlockPlayerScriptAction());
        
        return scriptActions;
    }
}

