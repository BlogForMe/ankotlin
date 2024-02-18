package com.kot.tool.shake;

import java.util.List;

import com.kot.tool.shake.ShakeDetector.Sample;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShakeDetectorTest {
    @Test
    public void testInitialShaking() {
        ShakeDetector.SampleQueue q = new ShakeDetector.SampleQueue();
        assertFalse(q.isShaking());
    }

    /**
     * Tests LG Ally sample rate.
     */
    @Test
    public void testShakingSampleCount3() {
        ShakeDetector.SampleQueue q = new ShakeDetector.SampleQueue();

        // These times approximate the data rate of the slowest device we've
        // found, the LG Ally.
        // on the LG Ally. The queue holds 500000000 ns (0.5ms) of samples or
        // 4 samples, whichever is greater.
        // 500000000
        q.add(1000000000L, false);
        q.add(1300000000L, false);
        q.add(1600000000L, false);
        q.add(1900000000L, false);
        assertContent(q, false, false, false, false);
        assertFalse(q.isShaking());

        // The oldest two entries will be removed.
        q.add(2200000000L, true);
        q.add(2500000000L, true);
        assertContent(q, false, false, true, true);
        assertFalse(q.isShaking());

        // Another entry should be removed, now 3 out of 4 are true.
        q.add(2800000000L, true);
        assertContent(q, false, true, true, true);
        assertFalse(q.isShaking());

        q.add(3100000000L, false);
        assertContent(q, true, true, true, false);
        assert (q.isShaking());

        q.add(3400000000L, false);
        assertContent(q, true, true, false, false);
        assertFalse(q.isShaking());
    }

    private void assertContent(ShakeDetector.SampleQueue q, boolean... expected) {
        List<Sample> samples = q.asList();

        StringBuilder sb = new StringBuilder();
        for (ShakeDetector.Sample s : samples) {
            sb.append(String.format("[%b,%d] ", s.accelerating, s.timestamp));
        }

        //assertThat(samples).hasSize(expected.length);
        //for (int i = 0; i < expected.length; i++) {
        //    assertThat(samples.get(i).accelerating).isEqualTo(expected[i]);
        //}
    }

    @Test
    public void testClear() {
        ShakeDetector.SampleQueue q = new ShakeDetector.SampleQueue();
        q.add(1000000000L, true);
        q.add(1200000000L, true);
        q.add(1400000000L, true);
        assert (q.isShaking());
        q.clear();
        assertFalse(q.isShaking());
    }
}