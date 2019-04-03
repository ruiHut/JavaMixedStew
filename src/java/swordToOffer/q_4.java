package swordToOffer;


public class q_4{
    public static void main(String[] args) {
        String s = "hello  world!";
        String res = replaceBlank(s);
        System.out.println(res);
    }

    private static String replaceBlank(String s) {
        if (s.length() == 0)
            throw new IllegalArgumentException("");

        int blankNumber = 0;
        int orignalLength = s.length();
        int newLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
               blankNumber++;
            }
        }
        if(blankNumber == 0) 
            return s;
        
        newLength = orignalLength + ( 1<<blankNumber);

        int oringnalIndex = orignalLength - 1;
        int newIndex = newLength - 1;
        char[] reChars = new char[newLength];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i)== ' ') {
                newIndex =  replaceBlank(reChars, newIndex);
                orignalLength = orignalLength - 2 ;
            } else{
                reChars[newIndex--] = s.charAt(i);
            }
            oringnalIndex--;
            
        }
        return String.valueOf(reChars);
    }

    private static int replaceBlank(char[] reChars, int index) {
        reChars[index--] = '0';
        reChars[index--] = '2';
        reChars[index--] = '%';
        return index;
    }
}