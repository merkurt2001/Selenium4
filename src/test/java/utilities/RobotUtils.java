package utilities;

import RobotClassDemo.Char2KeyCode;
import RobotClassDemo.Shortcuts;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

    /**
     * Instance of java.awt.Robot.
     */
    private static Robot robot;

    /**
     * Default value of Robot AutoDelay.
     */
    private static final int DEFAULT_AUTO_DELAY = 50; // milliseconds

    /**
     * Default value of Robot AutoWaitForIdle.
     */
    private static final boolean DEFAULT_AUTO_WAIT_FOR_IDLE = true;

    /**
     * There is no need to create a instance of RobotUtils.
     */
    private RobotUtils() {

    }

    /**
     * Sets a custom instance of java.awt.Robot with specified settings. {@code awtRobot} can be removed by
     * {@code clearCustomRobot()}.
     *
     * @param awtRobot instance of java.awt.Robot that will be used for sending keys, moving mouse, ...
     * @throws NullPointerException if {@code awtRobot} is {@code null}
     */
    public static void setCustomRobot(final Robot awtRobot) {
        if (awtRobot == null) {
            throw new NullPointerException("Custom AWT Robot was not provided");
        }

        robot = awtRobot;
    }

    /**
     * Clears a specified Robot. After that a default Robot will be used with default settings if a new custom Robot was
     * not set by {@code setCustomRobot(java.awt.Robot)}.
     */
    public static void clearCustomRobot() {
        robot = null;
        // init() will be done in a following method that client calls
    }

    /**
     * Sets the number of milliseconds default or custom Robot sleeps after generating an event. Default value is 50
     * milliseconds.
     *
     * @param delay time to sleep in milliseconds after generating an event.
     * @throws IllegalArgumentException if {@code delay} is not between 0 and 60,000 milliseconds inclusive
     */
    public static void setAutoDelay(final int delay) {
        init();
        robot.setAutoDelay(delay);
    }

    /**
     * Returns the number of milliseconds default or custom Robot sleeps after generating an event. Default value is 50
     * milliseconds.
     *
     * @return a current value of Robot autoDelay
     */
    public static int getAutoDelay() {
        init();
        return robot.getAutoDelay();
    }

    /**
     * Sets whether this Robot automatically invokes {@code waitForIdle} after generating an event.
     *
     * @param isOn Whether {@code waitForIdle} is automatically invoked
     */
    public static void setAutoWaitForIdle(final boolean isOn) {
        init();
        robot.setAutoWaitForIdle(isOn);
    }

    /**
     * Returns whether this Robot automatically invokes {@code waitForIdle} after generating an event.
     *
     * @return Whether {@code waitForIdle} is automatically called
     */
    public static boolean isAutoWaitForIdle() {
        init();
        return robot.isAutoWaitForIdle();
    }

    /**
     * Sleeps for the specified time. {@code Thread.sleep()} may be used instead.
     *
     * @param ms time to sleep in milliseconds
     * @throws IllegalArgumentException if {@code ms} is not between 0 and 60,000 milliseconds inclusive
     * @see java.lang.Thread#sleep
     */
    public static void delay(final int ms) {
        init();
        robot.delay(ms);
    }

    /**
     * Sends (Presses and Releases) a given key.
     *
     * @param keyCode Key to press (e.g. {@code KeyEvent.VK_A})
     * @throws IllegalArgumentException if {@code keyCode} is not a valid key
     * @see java.awt.event.KeyEvent
     */
    public static void sendKeys(final int keyCode) {
        init();
        sendKey(keyCode);
    }

    /**
     * Sends a given string.
     * <p>
     * Each character of {@code text} is sent one by one. Only letters [a-zA-Z], digits [0-9] and "standard" special
     * characters can be sent which are present on the keyboard. All other special characters are ignored.
     *
     * @param text a string, each character of {@code text} will be sent (e.g. {@code "Hello, my RobotUtils!"})
     */
    public static void sendKeys(final String text) {
        init();

        if (text != null) {
            for (char c : text.toCharArray()) {
                sendKey(c);
            }
        }
    }

    /**
     * Sends (Presses and Releases) a given key a specified number of times.
     *
     * @param keyCode     Key to press (e.g. {@code KeyEvent.VK_A})
     * @param numberTimes a specified number of times, a given key will sent.
     * @throws IllegalArgumentException if {@code keyCode} is not a valid key
     * @see java.awt.event.KeyEvent
     */
    public static void sendKeys(final int keyCode, final int numberTimes) {
        init();
        for (int i = 0; i < numberTimes; i++) {
            sendKey(keyCode);
        }
    }

    /**
     * Sends a given string a specified number of times.
     * <p>
     * Each character of {@code text} is sent one by one. Only letters [a-zA-Z], digits [0-9] and "standard" special
     * characters can be sent which are present on the keyboard. All other special characters are ignored.
     *
     * @param text        a string, each character of {@code text} will be sent (e.g. {@code "Hello, my RobotUtils!"})
     * @param numberTimes a specified number of times, a given {@code text} will sent.
     */
    public static void sendKeys(final String text, final int numberTimes) {
        init();
        for (int i = 0; i < numberTimes; i++) {
            for (char c : text.toCharArray()) {
                sendKey(c);
            }
        }
    }

    /**
     * Sends a {@code shortcut} from {@code com.testassistant.Shortcuts}. Shortcuts is independent of Windows, Mac and
     * Linux OS.
     *
     * @param shortcut int[] from {@code com.testassistant.Shortcuts} that represent a shortcut.
     * @see
     */
    public static void sendShortcutKeys(final Shortcuts shortcut) {
        init();

        // It's required for the event to be registered
        sendKey(shortcut.get()[0]);

        sendKeys(shortcut.get());
    }

    /**
     * Sends {@code keyCodes} as a shortcut. It's recommended to use if shortcut does not exist in
     * {@code com.testassistant.Shortcuts}
     *
     * @param keyCodes int[] that represent a shortcut.
     */
    public static void sendShortcutKeys(final int[] keyCodes) {
        init();

        if (keyCodes.length > 0) {

            // It's required for the event to be registered
            if (keyCodes[0] == KeyEvent.VK_SHIFT || keyCodes[0] == KeyEvent.VK_ALT
                    || keyCodes[0] == KeyEvent.VK_CONTROL) {
                sendKey(keyCodes[0]);
            }

            // Send keyCodes as a shortcut
            sendKeys(keyCodes);
        }
    }

    /**
     * Returns whether the given locking key on the keyboard is currently in its "on" state. Valid key codes are
     * {@link java.awt.event.KeyEvent#VK_CAPS_LOCK VK_CAPS_LOCK}, {@link java.awt.event.KeyEvent#VK_NUM_LOCK
     * VK_NUM_LOCK}, {@link java.awt.event.KeyEvent#VK_SCROLL_LOCK VK_SCROLL_LOCK}, and
     * {@link java.awt.event.KeyEvent#VK_KANA_LOCK VK_KANA_LOCK}.
     *
     * @param keyCode key code of KeyEvent, the valid values - {@code KeyEvent.VK_SCROLL_LOCK}, {@code KeyEvent.VK_NUM_LOCK}
     *                and {@code KeyEvent.VK_CAPS_LOCK}
     * @return current status of a given keyCode. {@code true} is turned on, {@code false} is turned off
     * @throws java.lang.IllegalArgumentException      if {@code keyCode} is not one of the valid key codes
     * @throws java.lang.UnsupportedOperationException if the host system doesn't allow getting the state of this key programmatically, or if the
     *                                                 keyboard doesn't have this key
     * @throws HeadlessException                       if GraphicsEnvironment.isHeadless() returns true
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public static boolean isKeyLocked(final int keyCode) {
        return Toolkit.getDefaultToolkit().getLockingKeyState(keyCode);
    }

    /**
     * Pasts a specified {@code text} from Clipboard. SystemClipboard of java.awt.Toolkit is used for it.
     *
     * @param text a string that will be copied to the System Clipboard and after that will be pasted from it.
     *             <p>
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     */
    public static void paste(final String text) {
        init();

        // Put text to clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, stringSelection);

        // Paste text from clipboard
        sendShortcutKeys(Shortcuts.PASTE_FROM_CLIPBOARD);
    }

    /**
     * Sends (Presses and Releases) a mouse button. For instance, {@code sendMouseKeys(InputEvent.BUTTON1_DOWN_MASK)} -
     * sends a click of Left mouse button.
     *
     * @param mouseButtonCode the Button mask; a combination of one or more mouse button masks.
     *                        <p>
     *                        It is allowed to use only a combination of valid values as a {@code buttons} parameter. A valid
     *                        combination consists of {@code InputEvent.BUTTON1_DOWN_MASK}, {@code InputEvent.BUTTON2_DOWN_MASK},
     *                        {@code InputEvent.BUTTON3_DOWN_MASK}
     * @throws IllegalArgumentException if the {@code mouseButtonCode} mask contains the mask for extra mouse button and support for
     *                                  extended mouse buttons is {@link Toolkit#areExtraMouseButtonsEnabled() disabled} by Java
     * @throws IllegalArgumentException if the {@code mouseButtonCode} mask contains the mask for extra mouse button that does not exist
     *                                  on the mouse and support for extended mouse buttons is
     *                                  {@link Toolkit#areExtraMouseButtonsEnabled() enabled} by Java
     */
    public static void sendMouseKeys(final int mouseButtonCode) {
        init();
        sendMouseKey(mouseButtonCode);
    }

    /**
     * Sends (Presses and Releases) a mouse button a specified number of times. For instance,
     * {@code sendMouseKeys(InputEvent.BUTTON3_DOWN_MASK, 2)} - sends a double click of Right mouse button.
     *
     * @param mouseButtonCode the Button mask; a combination of one or more mouse button masks.
     *                        <p>
     *                        It is allowed to use only a combination of valid values as a {@code buttons} parameter. A valid
     *                        combination consists of {@code InputEvent.BUTTON1_DOWN_MASK}, {@code InputEvent.BUTTON2_DOWN_MASK},
     *                        {@code InputEvent.BUTTON3_DOWN_MASK}
     * @param numberTimes     a specified number of times, the Button mask will sent.
     * @throws IllegalArgumentException if the {@code mouseButtonCode} mask contains the mask for extra mouse button and support for
     *                                  extended mouse buttons is {@link Toolkit#areExtraMouseButtonsEnabled() disabled} by Java
     * @throws IllegalArgumentException if the {@code mouseButtonCode} mask contains the mask for extra mouse button that does not exist
     *                                  on the mouse and support for extended mouse buttons is
     *                                  {@link Toolkit#areExtraMouseButtonsEnabled() enabled} by Java
     */
    public static void sendMouseKeys(final int mouseButtonCode, final int numberTimes) {
        init();
        for (int i = 0; i < numberTimes; i++) {
            sendMouseKey(mouseButtonCode);
        }
    }

    /**
     * Moves mouse pointer to given screen coordinates.
     *
     * @param x X position
     * @param y Y position
     */
    public static void moveMouse(final int x, final int y) {
        init();
        robot.mouseMove(x, y);
    }

    /**
     * Moves mouse pointer to given screen point.
     *
     * @param point position on the screen
     */
    public static void moveMouse(final Point point) {
        init();
        robot.mouseMove(point.x, point.y);
    }

    /**
     * Rotates the scroll wheel on wheel-equipped mice.
     *
     * @param wheelAmt number of "notches" to move the mouse wheel. Negative values indicate movement up/away from the user,
     *                 positive values indicate movement down/towards the user. OS can have the inverted scroll wheel.
     */
    public static void wheelMouse(final int wheelAmt) {
        init();
        robot.mouseWheel(wheelAmt);
    }

    /**
     * Initializes RobotUtils, creates a default instance of Robot and setups the default settings.
     */
    private static void init() {
        if (robot == null) {
            try {
                // Init new instance of AWT Robot class
                robot = new Robot();

                // Set a delay in milliseconds after each Robot's event
                robot.setAutoDelay(DEFAULT_AUTO_DELAY);

                // Set value if Robot will call waitForIdle after each Robot's event
                robot.setAutoWaitForIdle(DEFAULT_AUTO_WAIT_FOR_IDLE);
            } catch (AWTException awtEx) {
                awtEx.printStackTrace();
            }
        }
    }

    /**
     * Presses and Releases a given key.
     *
     * @param keyCode key code of KeyEvent
     */
    private static void sendKey(final int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    /**
     * Presses and Releases a given char.
     *
     * @param c character
     */
    private static void sendKey(final char c) {
        sendKeys(Char2KeyCode.convert(c));
    }

    /**
     * Presses and Releases the given keys.
     *
     * @param keyCodes key codes of KeyEvent
     */
    private static void sendKeys(final int[] keyCodes) {
        // Press the sequence of keyCodes
        for (int keyCode : keyCodes) {
            robot.keyPress(keyCode);
        }

        // Release the sequence of keyCodes
        for (int i = keyCodes.length - 1; i >= 0; i--) {
            robot.keyRelease(keyCodes[i]);
        }
    }

    /**
     * Presses and Releases a given mouse key.
     *
     * @param mouseKeyCode mouse mask, {@code InputEvent.BUTTON1_DOWN_MASK}, {@code InputEvent.BUTTON2_DOWN_MASK},
     *                     {@code InputEvent.BUTTON3_DOWN_MASK}
     */
    private static void sendMouseKey(final int mouseKeyCode) {
        robot.mousePress(mouseKeyCode);
        robot.mouseRelease(mouseKeyCode);
    }
}
