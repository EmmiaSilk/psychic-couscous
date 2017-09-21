package com.emmiasilk.urealms.core.util;

/**
 * A tool for keeping track of the time between events.
 *
 * <p>
 * All times are measured in nanoseconds, unless otherwise noted.
 *
 * @since 0.0.1
 */
public class StepTimer {

    /**
     * The length of one second as measured in nanoseconds.
     */
    public static final int NANOS_IN_SECOND = 1_000_000_000;

    /**
     * The length of one millisecond as measured in nanoseconds.
     */
    public static final int NANOS_IN_MILLISECOND = 1_000_000;

    /**
     * The time of the latest tick as measures in nanoseconds.
     */
    private long lastTickTime;

    /**
     * The length of the latest tick as measured in nanoseconds.
     */
    private long lastTickLength;

    /**
     * Creates a new <code>StepTimer</code>.
     *
     * <p>
     * The last tick defaults to the time the ticker is created
     * and the length of the last tick defaults to 0 nanoseconds.
     */
    public StepTimer() {
        set();
    }

    /**
     * Get the time between the latest two ticks.
     *
     * @return The amount of time between the latest tick and the one before it.
     */
    public long getLastTickLength() {
        return lastTickLength;
    }

    /**
     * Get the System time when the last tick occurred.
     *
     * @return The time the latest tick occurred.
     */
    public long getLastTickTime() {
        return lastTickTime;
    }

    /**
     * Updates the <code>lastTickTime</code> and <code>lastTickLength</code> based on the
     * current time and the time of the previous tick.
     *
     * <p>
     * The <code>lastTickLength</code> is made to equal the difference between the time
     * of the previous tick and the the current time, as measures in nanoseconds
     * when this method is called.
     *
     * <p>
     * The <code>lastTickTime</code> is made to equal current time as measured in
     * nanoseconds when this method is called.
     */
    public void tick() {
        long curTickTime = System.nanoTime();

        lastTickLength = curTickTime - lastTickTime;
        lastTickTime = curTickTime;
    }

    /**
     * Sets the <code>lastTickTime</code> to the current time in nanoseconds
     * and resets <code>lastTickLength</code> to 0.
     */
    public void set() {
        lastTickLength = 0;
        lastTickTime = System.nanoTime();
    }

}
