package com.man.stockbittest.codility


/**
 *
 * Created by Lukmanul Hakim on  05/06/2021
 * devs.lukman@gmail.com
 */
object LessonCountingElements {

    /**
     * PermCheck
     * Test Result URL
     * https://app.codility.com/demo/results/trainingT9Y6CC-CY5/
     *
     * */

    fun solution(A: IntArray): Int {

        for (element in A) {
            if (element > A.size) return 0
        }

        return 1

    }
}