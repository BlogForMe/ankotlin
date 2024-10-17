package com.kot.tool.shake

import com.kot.tool.shake.SensorShake.SampleQueue
import org.junit.Assert
import org.junit.Test

class ShakeDetectorTest {
    @Test
    fun testInitialShaking() {
        val q = SampleQueue()
        Assert.assertFalse(q.isShaking)
    }

    /**
     * Tests LG Ally sample rate.
     */
    @Test
    fun testShakingSampleCount3() {
        val q = SampleQueue()

        // These times approximate the data rate of the slowest device we've
        // found, the LG Ally.
        // on the LG Ally. The queue holds 500000000 ns (0.5ms) of samples or
        // 4 samples, whichever is greater.
        // 500000000
        q.add(1000000000L, false)
        q.add(1300000000L, false)
        q.add(1600000000L, false)
        q.add(1900000000L, false)
        assertContent(q, false, false, false, false)
        Assert.assertFalse(q.isShaking)

        // The oldest two entries will be removed.
        q.add(2200000000L, true)
        q.add(2500000000L, true)
        assertContent(q, false, false, true, true)
        Assert.assertFalse(q.isShaking)

        // Another entry should be removed, now 3 out of 4 are true.
        q.add(2800000000L, true)
        assertContent(q, false, true, true, true)
//        Assert.assertFalse(q.isShaking)
//        q.add(3100000000L, false)
//        assertContent(q, true, true, true, false)
//        assert(q.isShaking)
//        q.add(3400000000L, false)
//        assertContent(q, true, true, false, false)
//        Assert.assertFalse(q.isShaking)
    }

    private fun assertContent(q: SampleQueue, vararg expected: Boolean) {
        val samples = q.asList()
        val sb = StringBuilder()
        for (s in samples) {
            sb.append(String.format("[%b,%d] ", s.accelerating, s.timestamp))
        }

        //assertThat(samples).hasSize(expected.length);
        //for (int i = 0; i < expected.length; i++) {
        //    assertThat(samples.get(i).accelerating).isEqualTo(expected[i]);
        //}
    }

    @Test
    fun testClear() {
        val q = SampleQueue()
        q.add(1000000000L, true)
        q.add(1200000000L, true)
        q.add(1400000000L, true)
        assert(q.isShaking)
        q.clear()
        Assert.assertFalse(q.isShaking)


    }
}