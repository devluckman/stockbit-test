package com.man.stockbittest.codility


/**
 *
 * Created by Lukmanul Hakim on  05/06/2021
 * devs.lukman@gmail.com
 */
object LessonArrays {

    /**
     * CyclicRotation
     * Test Result URL
     * https://app.codility.com/demo/results/training5WRXZ8-AJB/
     *
     * */

    fun solutionFirst(A: IntArray, K: Int): IntArray {
        val size = A.size
        if (size == 0 || K == 0 || size == K) return A

        val temp = A.clone()

        for (x in 0 until size) {
            temp[(x + K) % size] = A[x]
        }

        return temp
    }

    fun solutionSecond(A: IntArray, K: Int): IntArray {

        val size = A.size
        if (size == 0 || K == 0 || size == K) return A

        val result = A.clone().toMutableList()

        for (i in 0 until K) {
            val move = result[size - 1]
            val getExpectLast = result.take(size - 1)
            result.clear()
            result.addAll(getExpectLast)
            result.add(0, move)
        }

        return result.toIntArray()
    }


    /**
     * OddOccurrencesInArray
     * Test Result URL
     * https://app.codility.com/demo/results/trainingJ7Q3Q4-44E/
     *
     * */


    fun solution(A: IntArray): Int {
        var elem = 0
        for (i in A) {
            elem = elem xor i
        }
        return elem
    }

}