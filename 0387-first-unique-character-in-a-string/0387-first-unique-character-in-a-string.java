import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int firstUniqChar(String s) {

        Map<Character, Integer> asd = new HashMap<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);

            if (!asd.containsKey(character)) {
                asd.put(character, i);
                continue;
            }
            asd.replace(character, -1);
        }
        Set<Integer> sad = new HashSet<>(asd.values());
        sad.remove(-1);

        if (sad.isEmpty()) {
            return -1;
        }

        return Collections.min(sad);
    }
}
