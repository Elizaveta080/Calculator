import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> RKM = new TreeMap<>();
    TreeMap<Integer, String> AKM = new TreeMap<>();

    public Converter(){
        RKM.put('I', 1);
        RKM.put('V', 5);
        RKM.put('X', 10);
        RKM.put('L', 50);
        RKM.put('C', 100);
        RKM.put('D', 500);
        RKM.put('M',1000);

        AKM.put(1000, "M");
        AKM.put(900, "CM");
        AKM.put(500, "D");
        AKM.put(400, "CD");
        AKM.put(100, "C");
        AKM.put(90, "XC");
        AKM.put(10, "X");
        AKM.put(9, "IX");
        AKM.put(5, "V");
        AKM.put(4, "IV");
        AKM.put(1, "I");
    }

    public boolean isRoman(String number){
        return RKM.containsKey(number.charAt(0));
    }

    public String intToRoman (int number) {
        String roman = "";
        int aKey;

        do {
            aKey = AKM.floorKey(number);
            roman += AKM.get(aKey);
            number -= aKey;
        }
        while (number != 0);
        return roman;
    }



    public int romanToInt(String s) {
        int end = s.length() - 1;
        char [] arr = s.toCharArray();
        int arabian;
        int result = RKM.get(arr[end]);
        for (int i = end -1; i >= 0; i--) {
            arabian = RKM.get(arr[i]);

            if (arabian < RKM.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}