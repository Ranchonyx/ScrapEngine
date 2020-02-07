

public class GameObject_Class implements GameObject_Interface {
        private int x,y,xMax,yMax,color;
        private String name,tag;

    
    public GameObject_Class(Types.Vector2<Integer> pos, int xMax, int yMax){
        this.x = pos.x;
        this.y = pos.y;
        this.xMax = xMax;
        this.yMax = yMax;
    }
    public GameObject_Class(Types.Vector2<Integer> pos, int _color, int xMax, int yMax) {
        this.x = pos.x;
        this.y = pos.y;
        this.color = _color;
        this.xMax = xMax;
        this.yMax = yMax;
    }
    public GameObject_Class(Types.Vector2<Integer> pos, String name, int _color, int xMax, int yMax) {
        this.x = pos.x;
        this.y = pos.y;
        this.color = _color;
        this.name = name;
        this.xMax = xMax;
        this.yMax = yMax;
    }
    public GameObject_Class(Types.Vector2<Integer> pos,Types.Vector2<String> text, int _color, int xMax, int yMax) {
        this.x = pos.x;
        this.y = pos.y;
        this.name = text.x;
        this.tag = text.y;
        this.color = _color;    
        this.xMax = xMax;
        this.yMax = yMax;                                                                                                                      
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

    public String getName() {
        return this.name;
    }

    public String getTag() {
        return this.tag;
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
    
    public void move(Types.KeyCode direction) throws Exception {

        if(this.x < 1) {
            direction = Types.KeyCode.DIRECTION_RIGHT;
        } else if(this.x >= xMax-2) {
            direction = Types.KeyCode.DIRECTION_LEFT;
        }

        if(this.y < 1) {
            direction = Types.KeyCode.DIRECTION_DOWN;
        } else if(this.y >= yMax-2) {
            direction = Types.KeyCode.DIRECTION_UP;
        }

        switch (direction) {
            case DIRECTION_UP:
                this.y -=1;
                break;
            case DIRECTION_DOWN:
                this.y +=1;
                break;
            case DIRECTION_LEFT:
                this.x -=1;
                break;
            case DIRECTION_RIGHT:
                this.x +=1;
                break;
            default:
            return;
        } try {
        } catch(Exception e) {
            throw e;
        }
        Thread.sleep(100);
    }
    
}