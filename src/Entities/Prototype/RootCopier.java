package Entities.Prototype;

import Entities.Root;

public class RootCopier {

    Root root;

    public RootCopier(Root root) {
        this.root = root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Root cloneRoot(){
        return (Root)root.copy();
    }
}
