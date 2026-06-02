package com.pandus.leetcode.solutions.quest

import com.pandus.leetcode.solutions.daily.EarliestFinishTimeForLandAndWaterRidesI
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestFinishTimeForLandAndWaterRidesITest {
    private val solution = EarliestFinishTimeForLandAndWaterRidesI()

    @Test
    fun `should finish both rides with no waiting`() {
        // Land ride ends at 1+2=3, water starts at 3, finishes at 3+2=5
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(1),
            landDuration = intArrayOf(2),
            waterStartTime = intArrayOf(3),
            waterDuration = intArrayOf(2)
        )
        assertEquals(5, result)
    }

    @Test
    fun `should handle water first being optimal`() {
        // Water ends at 1+1=2, land starts at 2, finishes at 2+1=3
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(2),
            landDuration = intArrayOf(1),
            waterStartTime = intArrayOf(1),
            waterDuration = intArrayOf(1)
        )
        assertEquals(3, result)
    }

    @Test
    fun `should pick optimal rides from multiple options`() {
        // Land rides end at: 1+5=6, 2+1=3
        // Water rides end at: 1+3=4, 3+1=4
        // Option1 (land first): minLandEnd=3, best water: max(3,1)+3=6, max(3,3)+1=4 -> 4
        // Option2 (water first): minWaterEnd=4, best land: max(4,1)+5=9, max(4,2)+1=5 -> 5
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(1, 2),
            landDuration = intArrayOf(5, 1),
            waterStartTime = intArrayOf(1, 3),
            waterDuration = intArrayOf(3, 1)
        )
        assertEquals(4, result)
    }

    @Test
    fun `should handle waiting between rides`() {
        // Land ride ends at 1+1=2, water starts at 5, finishes at 5+1=6
        // Water ride ends at 5+1=6, land starts at max(6,1)=6, finishes at 6+1=7
        // Best is land first: 6
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(1),
            landDuration = intArrayOf(1),
            waterStartTime = intArrayOf(5),
            waterDuration = intArrayOf(1)
        )
        assertEquals(6, result)
    }

    @Test
    fun `should handle simultaneous start times`() {
        // Both start at 0
        // Land first: land ends at 3, water starts at max(3,0)=3, ends at 3+2=5
        // Water first: water ends at 2, land starts at max(2,0)=2, ends at 2+3=5
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(0),
            landDuration = intArrayOf(3),
            waterStartTime = intArrayOf(0),
            waterDuration = intArrayOf(2)
        )
        assertEquals(5, result)
    }

    @Test
    fun `should choose best combination among many rides`() {
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(1, 10, 3),
            landDuration = intArrayOf(2, 1, 1),
            waterStartTime = intArrayOf(2, 5, 8),
            waterDuration = intArrayOf(1, 2, 1)
        )
        // Land ends: 3, 11, 4. minLandEnd=3
        // Water ends: 3, 7, 9. minWaterEnd=3
        // Option1: max(3,2)+1=4, max(3,5)+2=7, max(3,8)+1=9 -> 4
        // Option2: max(3,1)+2=5, max(3,10)+1=11, max(3,3)+1=4 -> 4
        assertEquals(4, result)
    }
}
