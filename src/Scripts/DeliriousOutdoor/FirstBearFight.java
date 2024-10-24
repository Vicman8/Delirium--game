package Scripts.DeliriousOutdoor;

import Level.MapTile;
import Level.Script;
import Level.ScriptState;
import Level.TileType;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCChangeVisibilityScriptAction;
import ScriptActions.NPCWalkScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;

public class FirstBearFight extends Script {
    //Unused. Will delete later.
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Great gadzooks! Looketh here!\nThis beast must be removed posthaste!");
            addText("Kaegen: Upon furth'r inspection, thee behold familiar.");
            addText("Kaegen: Thee.\nThou art the one who is't hast did destroy our A.C unit!");
            addText("Black Bear: Womp Womp.");
            addText("Kaegen: Thy sland'r knoweth nay bounds.\nI shalt slayeth thee!");
        }});

        scriptActions.add(new ChangeFlagScriptAction("bearFought", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
