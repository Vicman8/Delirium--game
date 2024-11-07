package Scripts.VictorRoom;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class ImYou extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Kaegen: Who... art thou? ");
            addText("Cat: I’m thou and thou art I. ");
            addText("Kaegen: What doth thee cullionly you’re me?\nYou’re a gib!");
            addText("Cat: You see this ball?\nI found this in a tree lost to time.");
            addText("Kaegen: What?");
            addText("Cat: Walrus and Dino helped me find it.");
            addText("Kaegen: Walrus? Dino?\nWhat art thee talking about?");
            addText("Cat: I pushed a rock and climbed\ninto a tree to find my lost ball.");
            addText("Kaegen: You’re ignoring mine questioneth!\nWho art thou?!");
            addText("Cat: And then... a victory screen appeared\nand that’s that.");
            addText("Kaegen: Yond doesn’t solveth aught!\nWherefore art thee talking liketh this?");
            addText("Cat: And then I was placed here... along with other\nunused assets such as my friends Jesus and Moses.");
            addText("Kaegen: This is hopeless...");
        }});

        scriptActions.add(new ChangeFlagScriptAction("dDanaIntroed", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
