public class Part1
{
    int findStopCodon(String DNA, int startIndex, String stopCodon)
    {
        int endIndex = startIndex;
        while(endIndex != -1)
        {
            endIndex = DNA.indexOf(stopCodon, endIndex + 1);
            //System.out.print(endIndex + " ");
            if((endIndex - startIndex) % 3 == 0)
                return endIndex;
        }
        return DNA.length();
    }
    
    void testFindStopCodon()
    {
        String DNA = "ATACGATATTATACCCGAGAT";
        int endIndex = DNA.length();
        int startIndex = DNA.indexOf("ATG");
        if(startIndex != -1)
        {
            endIndex = findStopCodon(DNA, startIndex, "TAA");
        }
        System.out.println("DNA: " + DNA);
        if(startIndex == -1 || endIndex == DNA.length())
            System.out.println("No gene sequence presnt");
        else 
            System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        //NO ATG
        DNA = "ATACGATATTATAACCCGAGAT";
        endIndex = DNA.length();
        startIndex = DNA.indexOf("ATG");
        if(startIndex != -1)
        {
            endIndex = findStopCodon(DNA, startIndex, "TAA");
        }
        System.out.println("DNA: " + DNA);
        if(startIndex == -1 || endIndex == DNA.length())
            System.out.println("No gene sequence presnt");
        else 
            System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        
        //NO TAA
        DNA = "ATGACGATATTATACCCGAGAT";
        endIndex = DNA.length();
        startIndex = DNA.indexOf("ATG");
        if(startIndex != -1)
        {
            endIndex = findStopCodon(DNA, startIndex, "TAA");
        }
        System.out.println("DNA: " + DNA);
        if(startIndex == -1 || endIndex == DNA.length())
            System.out.println("No gene sequence presnt");
        else 
            System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        
        
        //Multiple of 3
        DNA = "ATGACGATATAATATAACCCGAGAT";
        startIndex = DNA.indexOf("ATG");
        endIndex = DNA.length();
        if(startIndex != -1)
        {
            endIndex = findStopCodon(DNA, startIndex, "TAA");
        }
        System.out.println("DNA: " + DNA);
        if(startIndex == -1 || endIndex == DNA.length())
            System.out.println("No gene sequence presnt");
        else 
            System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
        
        //multiple taa
        DNA = "ATGACGATAGTAATATAACCCGAGAT";
        endIndex = DNA.length();
        startIndex = DNA.indexOf("ATG");
        if(startIndex != -1)
        {
            endIndex = findStopCodon(DNA, startIndex, "TAA");
        }
        System.out.println("DNA: " + DNA);
        if(startIndex == -1 || endIndex == DNA.length())
            System.out.println("No gene sequence presnt");
        else 
            System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
            
        //multiple tag    
        DNA = "ATGACGATAGTAATAAGTCCCTAGGAGAT";
        startIndex = DNA.indexOf("ATG");
        endIndex = DNA.length();
        if(startIndex != -1)
        {
            endIndex = findStopCodon(DNA, startIndex, "TAG");
        }
        System.out.println("DNA: " + DNA);
        if(startIndex == -1 || endIndex == DNA.length())
            System.out.println("No gene sequence presnt");
        else 
            System.out.println("Gene: " + DNA.substring(startIndex, endIndex+3));
    }
}


