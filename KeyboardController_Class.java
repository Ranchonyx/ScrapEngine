import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardController_Class implements KeyboardController_Interface {

    private Types.KeyCode currentKey;

    public Types.KeyCode getKey() {
        
        GlobalKeyboardHook hook = new GlobalKeyboardHook(true);
        hook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {        
                switch(event.getVirtualKeyCode()) {
                    case GlobalKeyEvent.VK_A:
                        currentKey = Types.KeyCode.A;
                    break;
                    case GlobalKeyEvent.VK_B:
                        currentKey = Types.KeyCode.B;
                    break;
                    case GlobalKeyEvent.VK_C:
                        currentKey = Types.KeyCode.C;
                    break;
                    case GlobalKeyEvent.VK_D:
                        currentKey = Types.KeyCode.D;
                    break;
                    case GlobalKeyEvent.VK_E:
                        currentKey = Types.KeyCode.E;
                    break;
                    case GlobalKeyEvent.VK_F:
                        currentKey = Types.KeyCode.F;
                    break;
                    case GlobalKeyEvent.VK_G:
                        currentKey = Types.KeyCode.G;
                    break;
                    case GlobalKeyEvent.VK_H:
                        currentKey = Types.KeyCode.H;
                    break;
                    case GlobalKeyEvent.VK_I:
                        currentKey = Types.KeyCode.I;
                    break;
                    case GlobalKeyEvent.VK_J:
                        currentKey = Types.KeyCode.J;
                    break;
                    case GlobalKeyEvent.VK_K:
                        currentKey = Types.KeyCode.K;
                    break;
                    case GlobalKeyEvent.VK_L:
                        currentKey = Types.KeyCode.L;
                    break;
                    case GlobalKeyEvent.VK_M:
                        currentKey = Types.KeyCode.M;
                    break;
                    case GlobalKeyEvent.VK_N:
                        currentKey = Types.KeyCode.N;
                    break;
                    case GlobalKeyEvent.VK_O:
                        currentKey = Types.KeyCode.O;
                    break;
                    case GlobalKeyEvent.VK_P:
                        currentKey = Types.KeyCode.P;
                    break;
                    case GlobalKeyEvent.VK_Q:
                        currentKey = Types.KeyCode.Q;
                    break;
                    case GlobalKeyEvent.VK_R:
                        currentKey = Types.KeyCode.R;
                    break;
                    case GlobalKeyEvent.VK_S:
                        currentKey = Types.KeyCode.S;
                    break;
                    case GlobalKeyEvent.VK_T:
                        currentKey = Types.KeyCode.T;
                    break;
                    case GlobalKeyEvent.VK_U:
                        currentKey = Types.KeyCode.U;
                    break;
                    case GlobalKeyEvent.VK_V:
                        currentKey = Types.KeyCode.V;
                    break;
                    case GlobalKeyEvent.VK_W:
                        currentKey = Types.KeyCode.W;
                    break;
                    case GlobalKeyEvent.VK_X:
                        currentKey = Types.KeyCode.X;
                    break;
                    case GlobalKeyEvent.VK_Y:
                        currentKey = Types.KeyCode.Y;
                    break;
                    case GlobalKeyEvent.VK_Z:
                        currentKey = Types.KeyCode.Z;
                    break;
                    default:
                    return;

                }
            }});
        return currentKey;
    }

    public boolean conditionalGetKey(Types.KeyCode key) {
        if(getKey() == key) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForKey(Types.KeyCode key) {
        while(getKey() != key) {
            try {
                Thread.sleep(100);
            } catch(Exception e) {
                System.out.print(e);
            }

        }
    }
}