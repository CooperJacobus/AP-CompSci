import java.util.*;
public class KMerProblem{
    public static void main(String[] args){
        String dna1 = "AAGCTTAAGAAGCCTTCAACAGAAAGCAGGTGGGCATTTAAGGCAATCATGACGGGAGAG";
        String dna2 = "GGGTTTGGCATGTCCTTGACCAGATGTGGTGATCTGATAAACTTCAAGTTTCACGATACT";
        String dna3 = "ATCTTGGAGGCCTGATGGTTGGTGAATTAGGCTATTCTTGCATTGCTATAAAAACATACC";
        String dna4 = "CAAGACTGGGTAGTTTAATAAGAAAAAATGTTTTATTGCCTCAGAGTTGTGCAGGCTGCA";
        String dna5 = dna1 + dna2 + dna3 + dna4;
        
        mostCommonKmer(dna1,3);
        mostCommonKmer(dna2,3);
        mostCommonKmer(dna3,4);
        mostCommonKmer(dna4,4);
        mostCommonKmer(dna5,5);
        
    }
     
    public static void mostCommonKmer(String dna, int k){
        int[] frequency = new int[(int)Math.pow(4,k)];
        for(int i = 0; i < dna.length() -k +1; i++){
            frequency[KmerIndex(dna.substring(i,i+k),k)]++;
        }
        
        int max = 0;
        List<Integer> KmerIndexes = new ArrayList<Integer>();
        
        for(int i = 0; i < frequency.length; i++){
             max = Math.max(max, frequency[i]);
        }
        System.out.println(" ");
        System.out.println("------------");
        System.out.println("INPUT: k = " + k + " | Sequence: " + dna);
        System.out.print("Most Common " + k + "-mer(s): ");
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] == max){
                KmerIndexes.add(i);
                System.out.print(IndexKmer(k,i) + " ");
            }
        }
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
}
        