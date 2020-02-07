import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScrapEngine {

  public enum EngineStatus {
    RUNNING, STOPPED, STARTED, ERROR, ERRORFATAL, WARNING, DEBUG, RENDERING, DONE, CONSTRUCTING, YEET
  }

  private EngineStatus status;
  private static final int __MAX_BOUNDS_WIDTH__ = 1000;
  private static final int __MAX_BOUNDS_HEIGHT__ = 1000;
  private int width;
  private int height;
  public  int[][] grid;
  private JFrame frame;
  private MyPanel panel;
  private boolean drawReady = true;
  private boolean canUpdateTitleAtRuntime;
  
  public ScrapEngine(int width, int height, int startColor, String title, boolean titleUpdateableAtRuntime){

    this.width = width;
    this.height = height;

    status = EngineStatus.CONSTRUCTING;
    grid = new int[this.width/20][this.height/20];
    panel = new MyPanel(grid);
    frame = new JFrame();
    canUpdateTitleAtRuntime = titleUpdateableAtRuntime;

    if(this.width > __MAX_BOUNDS_WIDTH__ || this.height > __MAX_BOUNDS_HEIGHT__) {
      status = EngineStatus.ERRORFATAL;
    }

    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.setSize(this.width,this.height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel); 
    frame.setVisible(true);
    frame.setTitle(title);  
    setEverythingColored(startColor);
  }

  public void setFrameTitle(String titleName) {
      if(this.canUpdateTitleAtRuntime == true) {
        this.frame.setTitle(titleName);  
      } else {          
          return;
      }
  }

  public String formatStatus(String text) {
    return (String)"[*] "+ text + "\n\r\t";
  }

  public String getStatus(boolean verbose) {

  String out = (String)""+status+"";
    if(!verbose) {
      if(status == EngineStatus.CONSTRUCTING) {
        return "";
      } else if(status == EngineStatus.DONE) {
        return "";
      } else if(status == EngineStatus.DEBUG) {
        return "";
      } else if(status == EngineStatus.RUNNING) {
        return "";
      } else if(status == EngineStatus.RENDERING) {
        return "";
      }
    }

    return formatStatus(out);
  }



  public boolean chkErr() {
    
    if(status == EngineStatus.ERROR || status == EngineStatus.ERRORFATAL) {
      return true;
    }
    return false;
  }

  public GameObject_Class Instantiate(GameObject_Class gameobj) {
    return (GameObject_Class)gameobj;
  }

  public GameObject_Class Load(GameObject_Class obj) {
    setTileColor(obj.getX(), obj.getY(), obj.getColor());
    Types.Vector2<Integer> location = obj.getLocation();
    return obj;
  }

  public int[][] getGrid(){
    return grid;
  }  
  
  public void setField(int[][] grid){
    this.grid = grid;
  }  
  
  public void setTileColor(int x, int y, int color){
    status = EngineStatus.RENDERING;
    grid[x][y] = color;  
  }

  public void setEverythingColored(int color){
    status = EngineStatus.YEET;
    for (int i=0; i<grid[0].length; i++){
        for (int j=0;j<grid.length; j++ ) {
            grid[i][j] = color;
        }
    }
  }
    
  public void renderGraphics(){
    status = EngineStatus.YEET;
    if(drawReady != false){
      drawReady = false;
      frame.invalidate();
      frame.validate();
      frame.repaint();
      drawReady = true;
    }     
  }

  public JFrame getFrame(){
    return frame;
  }
  
}

class MyPanel extends JPanel  {

  private static final long serialVersionUID = 1L;
  int[][] grid;
  public MyPanel (int[][] grid){
    super();
    this.grid = grid;  
  }
  
  public void paint(Graphics g) {
    
    for (int i=0; i<grid.length; i++){
        for (int j=0;j<grid[0].length;j++ ) {
            switch(grid[i][j]){
                     case 0:
                     g.setColor(Color.WHITE);
                     g.fillRect(i*20, j*20, 20, 20); 
                     break;
                     case 1:
                     g.setColor(Color.red);
                     g.fillRect(i*20,j*20, 20, 20);
                     break; 
                     case 2:
                     g.setColor(Color.green);
                     g.fillRect(i*20, j*20, 20, 20);
                     break;
                     case 3:
                     g.setColor(Color.blue);
                     g.fillRect(i*20, j*20, 20, 20);      
                     break;
                     //..
                     case 4:
                     g.setColor(Color.black);
                     g.fillRect(i*20, j*20, 20, 20);
                     break;                     


            }
        } 
    }
  }
}
