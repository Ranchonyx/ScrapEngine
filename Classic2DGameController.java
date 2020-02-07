public class Classic2DGameController extends KeyboardController_Class{

    public boolean onW() {
        if(conditionalGetKey(Types.KeyCode.W)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onA() {
        if(conditionalGetKey(Types.KeyCode.A)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onS() {
        if(conditionalGetKey(Types.KeyCode.S)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onD() {
        if(conditionalGetKey(Types.KeyCode.D)) {
            return true;
        } else {
            return false;
        }
    }
    
}