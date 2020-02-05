class entryPoint {
    public static void main(String[] args) throws Exception{
            ScrapEngine engine = new ScrapEngine(500, 500, 6, "test", true);
            boolean err = false;
            while(true) {
                


                    //YOUR CODE HERE




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
                ///END UPDATER FIELD
            }
    }
