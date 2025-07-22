import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SqueakyClean {
    static String clean(String identifier) {
        String str = identifier.replace(" ", "_");
        StringBuilder result = new StringBuilder();
        boolean turn = false;
        // 4, 3, 0, 1 and 7 to a, e, o, l, and t
        Map<Character, Character> converts = new HashMap<>();
        converts.put('4', 'a');
        converts.put('3', 'e');
        converts.put('0', 'o');
        converts.put('1', 'l');
        converts.put('7', 't');

        for (char ch : str.toCharArray()) {
            if (ch == '-') {
                turn = true;
            } else {
                if (turn) {
                    result.append(Character.toUpperCase(ch));
                    turn = false;
                } else {
                    if (converts.containsKey(ch)) {
                        result.append(converts.get(ch));
                    } else if (Character.isLetter(ch) || ch  == '_' ) {
                        result.append(ch);
                    }
                }
            }

        }
        str = result.toString();
        return str;
    }
}
