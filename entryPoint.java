class entryPoint {
    public static void main(String[] args) throws Exception{

            ScrapEngine engine = new ScrapEngine(700, 700, 4, "test", true);
            Classic2DGameController wasdController = new Classic2DGameController();
            boolean err = false;
            final Types.Vector2<Integer> pos = new Types.Vector2<Integer>(10, 10);
            final Types.Vector2<String> text = new Types.Vector2<String>("Test_Object","GameObject");
            GameObject_Class obj = new GameObject_Class(pos, text, 2, (int)700/20, (int)700/20);
            engine.Load(obj);


            while(true) {

                engine.setTileColor(obj.getX(), obj.getY(), 4);
                

                if(wasdController.onW()) {
                    obj.move(Types.KeyCode.DIRECTION_UP);
                } else if(wasdController.onA()) {
                    obj.move(Types.KeyCode.DIRECTION_LEFT);
                } else if(wasdController.onS()) {
                    obj.move(Types.KeyCode.DIRECTION_DOWN);
                } else if(wasdController.onD()) {
                    obj.move(Types.KeyCode.DIRECTION_RIGHT);
                }
                engine.renderGraphics();
                engine.setTileColor(obj.getX(), obj.getY(), 2);
                Thread.sleep(100);
                engine.renderGraphics();
                
//#region
             
                ///UPDATER FIELD
                //  INFO: PRINT STATUS CODES FROM ENUMERATOR EngineStatus
                //  INFO: CHECK FOR PROCESS ERRORS

                if(err == true) {
                    break;
                }
                System.out.println(engine.getStatus(
                 true   
                ));
                System.out.println(obj.getX() + " " + obj.getY());
                if(engine.chkErr() == true)
                    System.exit(0);
                }
               

                ///END UPDATER FIELD
//#endregion
            }
    }
