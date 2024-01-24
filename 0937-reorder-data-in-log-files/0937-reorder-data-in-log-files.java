import java.util.ArrayList;
import java.util.List;

class Solution {

       public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
                continue;
            }
            letters.add(log);
        }

        letters.sort((log1, log2) -> {

            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            int compared = split1[1].compareTo(split2[1]);

            if (compared == 0) {
                return split1[0].compareTo(split2[0]);
            }
            return compared;
        });

        letters.addAll(digits);

        return letters.toArray(new String[0]);
    }

}
