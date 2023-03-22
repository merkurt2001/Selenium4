package RobotClassDemo;

import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Char2KeyCode {

    /**
     * Map with matching character and array of key codes
     */
    private static final Map<Character, int[]> FINAL_MAP;

    static {
        Map<Character, int[]> initMap = new HashMap<>();

        initMap.put('q', new int[] { KeyEvent.VK_Q });
        initMap.put('w', new int[] { KeyEvent.VK_W });
        initMap.put('e', new int[] { KeyEvent.VK_E });
        initMap.put('r', new int[] { KeyEvent.VK_R });
        initMap.put('t', new int[] { KeyEvent.VK_T });
        initMap.put('y', new int[] { KeyEvent.VK_Y });
        initMap.put('u', new int[] { KeyEvent.VK_U });
        initMap.put('i', new int[] { KeyEvent.VK_I });
        initMap.put('o', new int[] { KeyEvent.VK_O });
        initMap.put('p', new int[] { KeyEvent.VK_P });
        initMap.put('[', new int[] { KeyEvent.VK_OPEN_BRACKET });
        initMap.put(']', new int[] { KeyEvent.VK_CLOSE_BRACKET });
        initMap.put('\\', new int[] { KeyEvent.VK_BACK_SLASH });

        initMap.put('a', new int[] { KeyEvent.VK_A });
        initMap.put('s', new int[] { KeyEvent.VK_S });
        initMap.put('d', new int[] { KeyEvent.VK_D });
        initMap.put('f', new int[] { KeyEvent.VK_F });
        initMap.put('g', new int[] { KeyEvent.VK_G });
        initMap.put('h', new int[] { KeyEvent.VK_H });
        initMap.put('j', new int[] { KeyEvent.VK_J });
        initMap.put('k', new int[] { KeyEvent.VK_K });
        initMap.put('l', new int[] { KeyEvent.VK_L });
        initMap.put(';', new int[] { KeyEvent.VK_SEMICOLON });
        initMap.put('\'', new int[] { KeyEvent.VK_QUOTE });

        initMap.put('z', new int[] { KeyEvent.VK_Z });
        initMap.put('x', new int[] { KeyEvent.VK_X });
        initMap.put('c', new int[] { KeyEvent.VK_C });
        initMap.put('v', new int[] { KeyEvent.VK_V });
        initMap.put('b', new int[] { KeyEvent.VK_B });
        initMap.put('n', new int[] { KeyEvent.VK_N });
        initMap.put('m', new int[] { KeyEvent.VK_M });
        initMap.put(',', new int[] { KeyEvent.VK_COMMA });
        initMap.put('.', new int[] { KeyEvent.VK_PERIOD });
        initMap.put('/', new int[] { KeyEvent.VK_SLASH });

        initMap.put('Q', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_Q });
        initMap.put('W', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_W });
        initMap.put('E', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_E });
        initMap.put('R', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_R });
        initMap.put('T', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_T });
        initMap.put('Y', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_Y });
        initMap.put('U', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_U });
        initMap.put('I', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_I });
        initMap.put('O', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_O });
        initMap.put('P', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_P });
        initMap.put('{', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET });
        initMap.put('}', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET });
        initMap.put('|', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH });

        initMap.put('A', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_A });
        initMap.put('S', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_S });
        initMap.put('D', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_D });
        initMap.put('F', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_F });
        initMap.put('G', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_G });
        initMap.put('H', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_H });
        initMap.put('J', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_J });
        initMap.put('K', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_K });
        initMap.put('L', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_L });
        initMap.put(':', new int[] { KeyEvent.VK_COLON });
        initMap.put('"', new int[] { KeyEvent.VK_QUOTEDBL });

        initMap.put('Z', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_Z });
        initMap.put('X', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_X });
        initMap.put('C', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_C });
        initMap.put('V', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_V });
        initMap.put('B', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_B });
        initMap.put('N', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_N });
        initMap.put('M', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_M });
        initMap.put('<', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA });
        initMap.put('>', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD });
        initMap.put('?', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH });

        initMap.put('`', new int[] { KeyEvent.VK_BACK_QUOTE });
        initMap.put('1', new int[] { KeyEvent.VK_1 });
        initMap.put('2', new int[] { KeyEvent.VK_2 });
        initMap.put('3', new int[] { KeyEvent.VK_3 });
        initMap.put('4', new int[] { KeyEvent.VK_4 });
        initMap.put('5', new int[] { KeyEvent.VK_5 });
        initMap.put('6', new int[] { KeyEvent.VK_6 });
        initMap.put('7', new int[] { KeyEvent.VK_7 });
        initMap.put('8', new int[] { KeyEvent.VK_8 });
        initMap.put('9', new int[] { KeyEvent.VK_9 });
        initMap.put('0', new int[] { KeyEvent.VK_0 });
        initMap.put('-', new int[] { KeyEvent.VK_MINUS });
        initMap.put('=', new int[] { KeyEvent.VK_EQUALS });

        initMap.put('~', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE });
        initMap.put('!', new int[] { KeyEvent.VK_EXCLAMATION_MARK });
        initMap.put('@', new int[] { KeyEvent.VK_AT });
        initMap.put('#', new int[] { KeyEvent.VK_NUMBER_SIGN });
        initMap.put('$', new int[] { KeyEvent.VK_DOLLAR });
        initMap.put('%', new int[] { KeyEvent.VK_SHIFT, KeyEvent.VK_5 });
        initMap.put('^', new int[] { KeyEvent.VK_CIRCUMFLEX });
        initMap.put('&', new int[] { KeyEvent.VK_AMPERSAND });
        initMap.put('*', new int[] { KeyEvent.VK_ASTERISK });
        initMap.put('(', new int[] { KeyEvent.VK_LEFT_PARENTHESIS });
        initMap.put(')', new int[] { KeyEvent.VK_RIGHT_PARENTHESIS });
        initMap.put('_', new int[] { KeyEvent.VK_UNDERSCORE });
        initMap.put('+', new int[] { KeyEvent.VK_PLUS });

        initMap.put(' ', new int[] { KeyEvent.VK_SPACE });
        initMap.put('\t', new int[] { KeyEvent.VK_TAB });
        initMap.put('\n', new int[] { KeyEvent.VK_ENTER });

        FINAL_MAP = Collections.unmodifiableMap(initMap);
    }

    /**
     * There is no need to create a instance of Char2KeyCode.
     */
    private Char2KeyCode() {

    }

    /**
     * Converts a given {@code character} to array of key codes. It returns empty array if the character is not present
     * in {@code FINAL_MAP}
     *
     * @param character
     *            a given char
     * @return array of key codes from {@code FINAL_MAP} or empty array
     */
    public static int[] convert(final char character) {
        if (FINAL_MAP.containsKey(character)) {
            return new int[] {};
        }
        return FINAL_MAP.get(character);
    }
}
