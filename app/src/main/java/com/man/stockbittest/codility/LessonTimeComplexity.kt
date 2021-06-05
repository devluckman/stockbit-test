package com.man.stockbittest.codility


/**
 *
 * Created by Lukmanul Hakim on  05/06/2021
 * devs.lukman@gmail.com
 */
object LessonTimeComplexity {

    /**
     * FrogJump
     * Test Result URL
     * https://app.codility.com/demo/results/trainingD57TET-2UG/
     *
     * */

    fun solution(X: Int, Y: Int, D: Int): Int {
        val remainingDistance = Y - X

        if(remainingDistance == 0) return 0

        val jump = remainingDistance / D

        return if (remainingDistance % D == 0) jump else jump.plus(1)
    }

}