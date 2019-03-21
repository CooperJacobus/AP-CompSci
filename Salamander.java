


import java.io.IOException;
/**
 * An existential Salimanted for you to talk to
 * 
 * @author Cooper Jacobus
 * @version 11/6/2018
 */

public class Salamander{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting(){
        String resp = "Let's have a conversation, if you dare.";
        try {
                Runtime.getRuntime().exec("say -v Alex ç" + resp);
                Thread.sleep(resp.length());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        return resp;
    }
    
    public String getResponse(String statement){
        String response = "";
        
        if (statement.equals("") || statement.indexOf("hmm") >= 0 || statement.indexOf("um") >= 0 || statement.indexOf("interesting") >= 0){
            response = "well come on, say something. or are you to much a coward?";
        }
        else if (statement.indexOf("why do i exist") >= 0 || statement.indexOf("why do we exist") >= 0){
            response = "my best guess: the powers that be thought it would be funny to make life only for it to die.";
        }
        
        else if (statement.indexOf("exist") >= 0){
            response = "the universe will continue without us, it doesn't matter.";
        }
        
        else if (statement.indexOf("what am i") >= 0){
            response = "you are nothing more than a bunch of carbon atoms drifting in the wind that is entropy.";
        }
        
        else if (statement.indexOf("carbon atoms") >= 0){
            response = "that only begs the question: why do we exist?";
        }
        
        else if (statement.indexOf("who are you to ask") >= 0){
            response = "i don't really know. what am i?";
        }
        
        else if (statement.indexOf("what are you") >= 0 || statement.indexOf("who are you") >= 0 || statement.indexOf("your name?") >= 0){
            response = "my name is Sal. some would call me a salamander but I am nothing more than a mess of molecules that claims to be sentient.";
        }
        
        else if (statement.indexOf("are useless") >= 0){
            response = "agreed";
        }
        
        else if (statement.indexOf("salamander") >= 0){
            response = "salamanders are useless";
        }
        
        else if (statement.indexOf("what") >= 0){
            response = "nothing. it doesn't matter in the long term anyway.";
        }
        
        else if (statement.indexOf("nothing. it doesn't matter in the long term anyway") >= 0){
            response = "i hate you";
        }
        
        else if (statement.indexOf("when") >= 0){
            response = "never. as far as I know anyway.";
        }
        
        else if (statement.indexOf("hate") >= 0){
            response = "that's on you for having feelings.";
        }
        
        else if (statement.indexOf("god") >= 0 || statement.indexOf("jesus") >= 0 || statement.indexOf("faith") >= 0){
            response = "why put your hope in such things? When has it ever actualy helped you?";
        }
        
        else if (statement.indexOf("i said") >= 0 || statement.indexOf("i did say") >= 0){
            response = "well I guess I was distracted, speak up next time. ";
        }
        
        //That thing with the Cats - Delete Later
        else if (statement.indexOf("cat") >= 0 || statement.indexOf("dog") >= 0){
            response = "tell me more about the useless beasts you call pets.";
        }
        
        //The thing about the teacher - Delete Later
        else if (statement.indexOf("joe") >= 0 || statement.indexOf("polacco") >= 0){
            response = "tell me more about this teacher of yours.";
        }
        
        
        
        else if (statement.indexOf("i want") >= 0){
            response = getWantResponse(statement);
        }
        
        else if (statement.indexOf("i ") >= 0 && statement.indexOf("i ") < statement.indexOf(" you")){
            response = getAccusationResponse(statement);
        }
        
        else if (statement.indexOf("you are ") >= 0){
            response = getFeelingResponse(statement);
        }
        
        else if (statement.indexOf("?") >= 0){
            response = getRandomAnswer();
        }
        
        else{
            response = getRandomResponse();
        }
        
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse(){
        final int NUMBER_OF_RESPONSES = 7;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        switch (whichResponse){
            case 0: response = "interesting, tell me more.";
            break;
            case 1: response = "why do you say that?";
            break;
            case 2: response = "do you really think so?";
            break;
            case 3: response = "who are you to say such things?";
            break;
            case 4: response = "why should i care?";
            break;
            case 5: response = "so what? it won't matter in the end anyway...";
            break;
            case 6: response = "that's a flawed sentiment, but its nice that you still believe in something.";
            break;
          }
        
        return response;
    }
    
    private String getRandomAnswer(){
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        switch (whichResponse){
            case 0: response = "you don't really want to know that...";
            break;
            case 1: response = "why would you ask that?";
            break;
            case 2: response = "you wouldn't believe me if I told you.";
            break;
            case 3: response = "i really shouldn't answer that.";
            break;
            case 4: response = "who are you to ask?";
            break;
          }
        
        return response;
    }
    
    private String getWantResponse(String statement){
        String want = statement.substring(statement.indexOf("i want")+7);
        if(want.substring(0,2).equals("to")){
            return "what do you plan to accomplish by wanting \"" + want + "\"";
        }
        else{
            return "would you really be happy if you got " + want;
        }
    }
    
    private String getFeelingResponse(String statement){
        return "why do you " + statement.substring(statement.indexOf("i ")+2,statement.indexOf(" you")) + " me?";
    }
    
    private String getAccusationResponse(String statement){
        return "why am i" + statement.substring(statement.indexOf("you are ")+8,statement.length()) + " ?";
    }
}
