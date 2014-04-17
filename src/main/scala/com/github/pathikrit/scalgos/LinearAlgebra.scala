package com.github.pathikrit.scalgos

/**
 * Algorithms related to linerar algebra
 */
object LinearAlgebra {

  /**
   * Implicit class to convert a 2d double array into a matrix with linear algebra ops
   */
  implicit class Matrix2D(a: Array[Array[Double]]) {

    /**
     * O(n^2) matrix multiplication
     *
     * @param b matrix to multiply with
     * @return this X b
     */
    def X(b: Matrix2D) = {
      val a = this
      require(a.cols == b.rows)
      Array.tabulate(a.rows, b.cols) {
        (i, j) => ((0 to cols) map {k => a(i, k) * b(k, j)}).sum
      }
    }

    /**
     * get matrix cell value
     *
     * @param i row
     * @param j col
     * @return valuw at ith row and jth column
     */
    def apply(i: Int, j: Int) = a(i)(j)

    /**
     * @return num rows in matrix
     */
    def rows = a.size

    /**
     * TODO: what if num rows == 0
     * @return num cols in matrix
     */
    def cols = a(0).size
  }
}