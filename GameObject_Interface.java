
public interface GameObject_Interface {
    public int getX();
    public int getY();
    public Types.Vector2<Integer> getLocation();
    public int getColor();

    public void setX(int _x);
    public void setY(int _y);
    public void setLocation(Types.Vector2<Integer> pos);
    public void setColor(int _color);

}