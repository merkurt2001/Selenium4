package RobotClassDemo;

import java.awt.event.KeyEvent;

public enum Shortcuts {
    COPY_TO_CLIPBOARD, CUT_TO_CLIPBOARD, MOVE_TO_END_OF_LINE, MOVE_TO_BEGINNING_OF_LINE, PASTE_FROM_CLIPBOARD, SELECT_ALL;

    static {
        if (OS.IS_WINDOWS) {
            COPY_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_C }); // Ctrl+C
            CUT_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_X }); // Ctrl+X
            MOVE_TO_END_OF_LINE.set(new int[] { KeyEvent.VK_END }); // Home
            MOVE_TO_BEGINNING_OF_LINE.set(new int[] { KeyEvent.VK_HOME }); // End
            PASTE_FROM_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_V }); // Ctrl+V
            SELECT_ALL.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_A }); // Ctrl+A
        } else if (OS.IS_MAC) {
            COPY_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_C }); // Meta+C
            CUT_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_X }); // Meta+X
            MOVE_TO_END_OF_LINE.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_RIGHT }); // Meta+Right Arrow
            MOVE_TO_BEGINNING_OF_LINE.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_LEFT }); // Meta+Left Arrow
            PASTE_FROM_CLIPBOARD.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_V }); // Meta+V
            SELECT_ALL.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_A }); // Meta+A
        } else if (OS.IS_LINUX) {
            COPY_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_C }); // Ctrl+C
            CUT_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_X }); // Ctrl+X
            MOVE_TO_END_OF_LINE.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_E }); // Ctrl+E
            MOVE_TO_BEGINNING_OF_LINE.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_A }); // Ctrl+A
            PASTE_FROM_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_V }); // Ctrl+V
            SELECT_ALL.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_A }); // Ctrl+A
        } else {
            COPY_TO_CLIPBOARD.set(new int[] {});
            CUT_TO_CLIPBOARD.set(new int[] {});
            MOVE_TO_END_OF_LINE.set(new int[] {});
            MOVE_TO_BEGINNING_OF_LINE.set(new int[] {});
            PASTE_FROM_CLIPBOARD.set(new int[] {});
            SELECT_ALL.set(new int[] {});
        }
    }

    private int[] shortcut;

    private void set(int[] shortcut) {
        this.shortcut = shortcut;
    }

    public int[] get() {
        return shortcut;
    }
}
