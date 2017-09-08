public class Part2
{
    int howMany(String stringa, String stringb)
    {
        int count = 0;
        int index = -1;
        do
        {
            index = stringb.indexOf(stringa, index + stringa.length());
            if(index != -1)
                ++count;
        }while(index != -1);
        return count;
    }
    
    void testHowMany()
    {
        String stringb = "AAAAA", stringa = "AAA";
        System.out.println(howMany(stringa, stringb));
        
        stringb = "ATGAACGAATTGAATC";
        stringa = "GAA";
        System.out.println(howMany(stringa, stringb));
    }
}