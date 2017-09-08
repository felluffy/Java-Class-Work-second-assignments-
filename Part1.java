public class Part1
{
    int findStopCodon(String DNA, int startIndex, String stopCodon)
    {
        int endIndex = startIndex;
        while(endIndex != -1)
        {
            endIndex = DNA.indexOf(stopCodon, endIndex + 1);
            //System.out.print(endIndex + " ");
            if(endIndex != -1 && (endIndex - startIndex) % 3 == 0)
            {
            //    System.out.println("returning " + endIndex);
                return endIndex;
            }
        }
        //System.out.println("returing length " + DNA.length());
        return DNA.length();
    }
    
    String findGene(String DNA)
    {
        int startIndex = DNA.indexOf("ATG");
        if(startIndex == -1)
            return "";
        int index = findStopCodon(DNA, startIndex, "TAA");
        if(index == DNA.length())
        {
            index = findStopCodon(DNA, startIndex, "TAG");
        }
        if(index == DNA.length())
            return "";
        else
            return DNA.substring(startIndex, index + 3);
    }
    
    void findAllGenes(String DNA)
    {
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        do
        {
            startIndex = DNA.indexOf("ATG", index + 1);
            //System.out.println("line 44 executed");
            if(startIndex == -1)
                break;
            //ystem.out.println("ATG: " + startIndex);
            index = findStopCodon(DNA, startIndex, "TAA");
            //System.out.println("line 44 executed");
            //System.out.println("TAA: " + index);
            if(index == DNA.length())
            {
                //System.out.println("in line 52 if");
                index = findStopCodon(DNA, startIndex, "TAG");
                //System.out.println("TAG: " + index);
            }
            if(index == DNA.length())
                break;
            gene = DNA.substring(startIndex, index + 3);
            //System.out.println("line 60 executed");
            System.out.println("Gene" + ": " + gene);
        }while(gene != "");
    }
    
    void testFindAllGene()
    {
        String DNA = "ATAATAAAATAATAAATAAATAGATTAGAATGTAG";
        findAllGenes(DNA);
        DNA = "GATCGATAGACTGATAGGGGATGCAGTATATCCCTGGATACAATAGACGCACAGGTTGGAATCCTAAGTGAAGTCGCGCGTCCGAACCCAGCTCTATTTTAGAGGTCATGGGTTCTGGTGCCCGCGAGCCGCGGAACCGATTAGGGGCATGTACAACAATATTTATTAGTCATCTTTCAGACACAATCTCCCAGCTCACTGGTATATAGTTCCTGCTATAATTAGCCTCCCTCATAAGTTGCACTACTTCAGCGTCCCAAATGCACCCTTACCACGAAGACAGGATTGTCCGATCCCATATTACGACCTTGGCAGGGGGTTCGCAAGTCCCACCCCAAACGATGCTGAAGGCTCAGGTTTCACAGGGACAAAAGCTTTAAACGCGAGTTCCCGCTCATAACCTGGACCGAATGCAGAATCATGCATCGTTCCACTGTGTTCGTGTCATCTAGGACGGGCGCAAAGGATATATAATTCAATTTTGAATACCTTATATTATTGTACACCTACCGGTCACCAGCCAACAATGTGCGGATGGCGTTACAACTTTCTGGGCCTAATCTGACCGTTCTAGATACCGCACTCTGGGCAATACGAGGTAAAGCCAGTCACCCAGTGTCGATCAACACCTAACCTAACGGTAAGAGGCTCACATAATGGCACTGTCGGCGTCCCCAGGGTATTTTACGTTAGCATCAGGTGGACTAACATGAATCTTTACTCCCAAGCGAAAACGGGTGCGTGGACTAGCGAGGAGCAAACGAAAATTCTTGGCCTGCTTGGTGTCTCGTATTCCTCTTAGAGATCGACGAAATGTTTCACGACCAAGGGAAAGGTCGCCCTACAAAATAGATTTGCGTTACTCTCTCCATAAGGAGTCCGGTGTAGCGAAGGATCAAGGCGACCCTAGGTAGCAACCGCCGGCTTCGGCGGTAAGGTATCACTCAAGAAGCAGACACAGTAAGACACGGTCTAGCTGACTGTCTATCGGCTAGGTCAA";
        //DNA = "ATGATAAAATAATAAATAAATAGATTAGAATGTAG";
        findAllGenes(DNA);
        
    }
    
    void testFindStopCodon()
    {
        String DNA = "ATACGATATTATACCCGAGAT";
        //int endIndex = DNA.length();
        //int startIndex = DNA.indexOf("ATG");
        //if(startIndex != -1)
        //{
        //    endIndex = findStopCodon(DNA, startIndex, "TAA");
        //}
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        //if(startIndex == -1 || endIndex == DNA.length())
        //    System.out.println("No gene sequence presnt");
        //else 
        //    System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        //NO ATG
        DNA = "ATACGATATTATAACCCGAGAT";
        //endIndex = DNA.length();
        //startIndex = DNA.indexOf("ATG");
        //if(startIndex != -1)
        //{
        //    endIndex = findStopCodon(DNA, startIndex, "TAA");
        //}
        System.out.println("DNA: " + DNA);
        //if(startIndex == -1 || endIndex == DNA.length())
        //    System.out.println("No gene sequence presnt");
        //else 
        //    System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        System.out.println("Gene: " + findGene(DNA));
        
        //NO TAA
        DNA = "ATGACGATATTATACCCGAGAT";
        //endIndex = DNA.length();
        //startIndex = DNA.indexOf("ATG");
        //if(startIndex != -1)
        //{
        //    endIndex = findStopCodon(DNA, startIndex, "TAA");
        //}
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        //if(startIndex == -1 || endIndex == DNA.length())
        //    System.out.println("No gene sequence presnt");
        //else 
        //    System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        
        
        //Multiple of 3
        DNA = "ATGACGATATAATATAACCCGAGAT";
        //startIndex = DNA.indexOf("ATG");
        //endIndex = DNA.length();
        //if(startIndex != -1)
        //{
        //    endIndex = findStopCodon(DNA, startIndex, "TAA");
        //}
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        //if(startIndex == -1 || endIndex == DNA.length())
        //   System.out.println("No gene sequence presnt");
        //else 
        //    System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        //
        //multiple taa
        DNA = "ATGACGATAGTAATATAACCCGAGAT";
        //endIndex = DNA.length();
        //startIndex = DNA.indexOf("ATG");
        //if(startIndex != -1)
        //{
        //    endIndex = findStopCodon(DNA, startIndex, "TAA");
        //}
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        //if(startIndex == -1 || endIndex == DNA.length())
        //    System.out.println("No gene sequence presnt");
        //else 
        //    System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
            
        //multiple tag    
        DNA = "ATGACGATAGTAATAAGTCCCTAGGAGAT";
        //startIndex = DNA.indexOf("ATG");
        //endIndex = DNA.length();
        //if(startIndex != -1)
        //{
        //    endIndex = findStopCodon(DNA, startIndex, "TAG");
        //}
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        //if(startIndex == -1 || endIndex == DNA.length())
        //    System.out.println("No gene sequence presnt");
        //else 
        //    System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));

    }
}


