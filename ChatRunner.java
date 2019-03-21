import java.util.Scanner;
import java.io.IOException;
/**
 * Runs the Chatbots
 * @author Laurie White
 * @version April 2012
 */
public class ChatRunner{
    /**
     * Create a Salamander, give it user input, and print its replies.
     */
    public static void main(String[] args){
        Salamander sal = new Salamander();
        
        System.out.println (sal.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        statement = statement.toLowerCase();
        statement = statement.trim();
        
        while (!statement.equals("Bye") && !statement.equals("bye")){
            String resp = sal.getResponse(statement);
            System.out.println (resp);
            try {
                Runtime.getRuntime().exec("say -v Alex " + resp);
                Thread.sleep(statement.length()*60);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            statement = in.nextLine();
        }
    }
    
    public static void talkToEachother(){
        Salamander sal = new Salamander();
        Salamander mander = new Salamander();
        //Magpie2 mander = new Magpie2();
        String resp = sal.getGreeting();
        System.out.println("Person 1: " + resp);
        //Scanner in = new Scanner (System.in);
        //String statement = in.nextLine();
        
        while (true)
        {
            resp = mander.getResponse(resp);
            System.out.println("Mander: " + resp);
            try {
                Runtime.getRuntime().exec("say -v Victoria " + resp);
                Thread.sleep(resp.length()*60);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            resp = sal.getResponse(resp);
            System.out.println("Sal: " + resp);

            try {
                Runtime.getRuntime().exec("say -v Alex " + resp);
                Thread.sleep(resp.length()*60);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            //statement = in.nextLine();
        }
    }
}
