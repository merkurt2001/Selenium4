package RobotClassDemo;

public class OS {

    private static final String OS_NAME = System.getProperty("os.name");

    /**
     * Is OS Linux?
     */
    static final boolean IS_LINUX = getOSMatches("Linux") || getOSMatches("LINUX");
    /**
     * Is OS Mac?
     */
    static final boolean IS_MAC = getOSMatches("Mac");
    /**
     * Is OS Windows?
     */
    static final boolean IS_WINDOWS = getOSMatches("Windows");

    /**
     * Private OS.
     */
    private OS() {

    }

    /**
     * Matches OS Name and OS name prefix.
     *
     * @param osNamePrefix
     *            OS name prefix
     * @return true/false
     */
    private static boolean getOSMatches(final String osNamePrefix) {
        return OS_NAME != null && OS_NAME.startsWith(osNamePrefix);
    }
}
