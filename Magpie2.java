/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *             Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

public class Magpie2
{
    /**
     * Get a default greeting     
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        statement = statement.toLowerCase();
        String response = "";
        if (statement.contains("no"))
        {
            response = "Why so negative?";
        }
        else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother"))
        {
            response = "Tell me more about your family.";
        }
        else if (statement.contains("dog")
                || statement.contains("cat")
                || statement.contains("pet"))
        {
            response = "Tell me more about your pets";
        }
        else if (statement.contains("joe") || statement.contains("polacco")){
            response = "He sounds like a great teacher!";
        }
        else if (statement.contains("weather") || statement.contains("sun") || statement.contains("rain") || statement.contains("wind")){
            response = "I wonder how the weather is today!";
        }
        else if (statement.contains("science") || statement.contains("physics") || statement.contains("chem") || statement.contains("bio")){
            response = "It was my favorite subject in school";
        }
        else if (statement.contains("?") || statement.contains("what") || statement.contains("why")){
            response = "We may never know.";
        }
        else if(statement.trim().length() < 1){
            response = "Enter something please:";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        switch (whichResponse) {
            case 0: response = "Interesting, tell me more.";
            break;
            case 1: response = "Hmmm.";
            break;
            case 2: response = "Do you really think so?";
            break;
            case 3: response = "You don't say.";
            break;
            case 4: response = "Hmmm, interesting";
            break;
            case 5: response = "I see";
            break;
        }

        return response;
    }
}