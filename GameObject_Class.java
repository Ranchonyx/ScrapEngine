

public class GameObject_Class  {
        private int x,y;
        private String name,tag;
        private int width,height;
        private int color;

    
    public GameObject_Class(Types.Vector2<Integer> pos){
        this.x = pos.x;
        this.y = pos.y;
    }
    public GameObject_Class(Types.Vector2<Integer> pos,String name) {
        this.x = pos.x;
        this.y = pos.y;
        this.name = name;
    }
    public GameObject_Class(Types.Vector2<Integer> pos,Types.Vector2<String> text) {
        this.x = pos.x;
        this.y = pos.y;
        this.name = text.x;
        this.tag = text.y;
    }
    public GameObject_Class(Types.Vector2<Integer> pos,Types.Vector2<String> text, Types.Vector2<Integer> size) {
        this.x = pos.x;
        this.y = pos.y;
        this.name = text.x;
        this.tag = text.y;
        this.width = size.x;
        this.height = size.y;
    }
    public GameObject_Class(Types.Vector2<Integer> pos,Types.Vector2<String> text, Types.Vector2<Integer> size, int _color) {
        this.x = pos.x;
        this.y = pos.y;
        this.name = text.x;
        this.tag = text.y;
        this.width = size.x;
        this.height = size.y;
        this.color = _color;
    }
    

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public Types.Vector2<Integer> getLocation() {
        return new Types.Vector2<Integer>(this.x, this.y);
    }
    public int getColor() {
        return this.color;
    }

    public void setX(int _x) {
        this.x = _x;
    }
    public void setY(int _y) {
        this.y = _y;
    }
    public void setLocation(Types.Vector2<Integer> pos) {
        this.x = pos.x;
        this.y = pos.y;
    }
    public void setColor(int _color) {
        this.color = _color;
    }
}