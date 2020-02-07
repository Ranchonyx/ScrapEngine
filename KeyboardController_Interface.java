public interface KeyboardController_Interface {

    public Types.KeyCode getKey();
    public boolean conditionalGetKey(Types.KeyCode keyCode);
    public void waitForKey(Types.KeyCode keycode);
}