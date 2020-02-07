class entryPoint {
    public static void main(String[] args) throws Exception{
            ScrapEngine engine = new ScrapEngine(700, 700, 4, "test", true);
            boolean err = false;
            while(true) {
                


                    //YOUR CODE HERE

                    engine.setTileColor(10, 10, 3);
                    engine.renderGraphics();
                    

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
                Thread.sleep(100);
                ///END UPDATER FIELD
            }
    }
