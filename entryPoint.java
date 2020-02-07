class entryPoint {
    public static void main(String[] args) throws Exception{
            ScrapEngine engine = new ScrapEngine(700, 700, 4, "test", true);
            boolean err = false;
            while(true) {
                final Types.Vector2<Integer> pos = new Types.Vector2<Integer>(10, 10);
                final Types.Vector2<String> text = new Types.Vector2<String>("Test_Object","GameObject");
                final Types.Vector2<Integer> size = new Types.Vector2<Integer>(700/20, 700/20);
                GameObject_Class obj = new GameObject_Class(pos, text, size, 2);
                engine.Load(obj);

                    //YOUR CODE HERE


                    
//#region
                if(err == true) {
                    break;
                }
                ///UPDATER FIELD
                //  INFO: PRINT STATUS CODES FROM ENUMERATOR EngineStatus
                //  INFO: CHECK FOR PROCESS ERRORS
                System.out.println(engine.getStatus(
                 true   
                ));

                if(engine.chkErr() == true)
                    System.exit(0);
                }
                engine.renderGraphics();
                Thread.sleep(100);
                ///END UPDATER FIELD
//#endregion
            }
    }
