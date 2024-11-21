package Level;

import GameObject.Frame;

public class Item {
    protected Frame frame;
    public Item(Frame frame){

        this.frame = frame;
    }
    public Frame getFrame(){
        return this.frame;
    }
}
