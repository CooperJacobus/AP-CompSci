import java.util.*;
import java.io.*;

public class KMerChallenge
{
    public static void main(String[] args)
    {
        String dna = readFile("chromosome4.txt"); // reads only 100,000 characters
        dna = removeStreaks(dna);  // removes streaks of A's and T's
        
        long startTime = System.nanoTime(); // start the clock
   
        for (int k=3; k<=10; k++)
           mostCommonKmer(dna,k); 
        
        
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Execution time: " + (double)estimatedTime/1000000000 + " seconds");
        
        
        
    }
    
    
    
    public static void mostCommonKmer(String dna, int k){
        int[] frequency = new int[(int)Math.pow(4,k)];
        for(int i = 0; i < dna.length() -k +1; i++){
            frequency[KmerIndex(dna.substring(i,i+k),k)]++;
        }
        
        int max = 0;
        //List<Integer> KmerIndexes = new ArrayList<Integer>();
        
        for(int i = 0; i < frequency.length; i++){
             max = Math.max(max, frequency[i]);
        }
        //System.out.println(" "); //Vanity
        //System.out.println("------------"); //Vanity
        //System.out.println("INPUT: k = " + k + " | Sequence: " + dna); //Vanity
        System.out.print("Most Frequent " + k + "-mer = "); //Vanity
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] == max){
                //KmerIndexes.add(i);
                System.out.print(IndexKmer(k,i) + " "); //Vanity
            }
        }
        System.out.println("frequency = " + max); //Vanity
    }
    
    public static int KmerIndex(String kmer, int k){
        int index = 0;
        for(int i = 0; i < k; i++){
            int val = 0;
            if(kmer.substring(i,i+1).equals("C")) val = 1;
            if(kmer.substring(i,i+1).equals("G")) val = 2;
            if(kmer.substring(i,i+1).equals("T")) val = 3;
            index += Math.pow(4,k-i-1) * val;
        }
        return index;
    }
    
    public static String IndexKmer(int k, int index){
        String kmer = "";
        for(int i = 0; i < k; i++){
            int val = index/((int)Math.pow(4,k-i-1));
            if(val == 0) kmer = kmer + "A";
            if(val == 1) kmer = kmer + "C";
            if(val == 2) kmer = kmer + "G";
            if(val == 3) kmer = kmer + "T";
            index = (int)index%((int)Math.pow(4,k-i-1));
        }
        return kmer;
    }
        
        
        
    
    public static String readFile(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        String text = "";
        int lines = 0;
 
        try 
        {
 
            Scanner scanner = new Scanner(file);
            
            // 60 characters per line * 1667 lines = 100,020 characters of text
            // or approximately 100,000 nucleotides
            while (scanner.hasNextLine() && lines < 1667) 
            {
                
                text += scanner.nextLine();
                lines++;
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return text;
    }
        
    
    
    private static String removeStreaks(String dna)
    {
        dna = dna.replaceAll("AAA","");
        dna = dna.replaceAll("AAAA","");
        dna = dna.replaceAll("AAAAA","");
        dna = dna.replaceAll("AAAAAAA","");
        dna = dna.replaceAll("TTT","");
        dna = dna.replaceAll("TTTT","");
        dna = dna.replaceAll("TTTTT","");
        dna = dna.replaceAll("TTTTTTT","");
        
        return dna;
    }
     

}
        