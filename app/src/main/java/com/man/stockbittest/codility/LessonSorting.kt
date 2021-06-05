package com.man.stockbittest.codility


/**
 *
 * Created by Lukmanul Hakim on  05/06/2021
 * devs.lukman@gmail.com
 */
object LessonSorting {

    /**
     * Distinct
     * Test Result URL
     * https://app.codility.com/demo/results/trainingGQUN34-Y3H/
     *
     * */

    fun solution(A: IntArray): Int {

        val distinct = A.distinct()

        return distinct.size
    }


}