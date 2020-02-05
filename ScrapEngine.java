import java.awt.*;
import java.awt.event.*;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

import javax.swing.*;

public class ScrapEngine{

  public enum EngineStatus {
    RUNNING, STOPPED, STARTED, ERROR, ERRORFATAL, WARNING, DEBUG, RENDERING, DONE, CONSTRUCTING, YEET
  }

  private EngineStatus status;
  private static final int __MAX_BOUNDS_WIDTH__ = 1000;
  private static final int __MAX_BOUNDS_HEIGHT__ = 1000;
  private int width;  
  private int height;
  private int[][] grid;
  private JFrame frame;
  private MyPanel panel;
  private boolean drawReady = true;
  private boolean canUpdateTitleAtRuntime;
  
  public ScrapEngine(int width, int height, int startColor, String title, boolean titleUpdateableAtRuntime){

    if(width > __MAX_BOUNDS_WIDTH__ || height > __MAX_BOUNDS_HEIGHT__) {
      status = EngineStatus.ERRORFATAL;
    }

    status = EngineStatus.CONSTRUCTING;
    this.width = width;
    this.height = height;
    canUpdateTitleAtRuntime = titleUpdateableAtRuntime;
    grid = new int[width/20][height/20];
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame = new JFrame();
    frame.setSize(width,height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new MyPanel(grid);
    frame.add(panel); 
    frame.setVisible(true);
    setEverythingColored(startColor);
    this.frame.setTitle(title);  
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
    status = EngineStatus.RENDERING;
    for (int i=0; i<grid[0].length; i++){
        for (int j=0;j<grid.length ;j++ ) {
            grid[i][j] = color;
        }
    }
  }
    
  public void renderGraphics(){
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
  public MyPanel (int[][] _grid){
    super();
    this.grid = _grid;  
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
                     case 6:
                     g.setColor(Color.black);
                     g.fillRect(i*20, j*20, 20, 20);
                     break;                     


            }
        } 
    }
  }
}
