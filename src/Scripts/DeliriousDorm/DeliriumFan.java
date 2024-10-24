package Scripts.DeliriousDorm;

import Level.Script;
import Screens.DormScreen;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

import java.util.ArrayList;

import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;

public class DeliriumFan extends Script {

    //DormScreen dormScreen;
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Is this a paper fan?\nWhat happened to the one I hath brought from home?");

            //addScriptAction(setMap(()));


        }});

        scriptActions.add(new ChangeFlagScriptAction("mcUnfainted", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }


}
