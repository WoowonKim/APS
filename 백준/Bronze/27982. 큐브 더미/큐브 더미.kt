import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val M = sc.nextInt()
    val visited = Array(N + 1) { Array(N + 1) { BooleanArray(N + 1) } }
    val arr = Array(M) { IntArray(3) }
    for (l in 0 until M) {
        val i = sc.nextInt()
        val j = sc.nextInt()
        val k = sc.nextInt()
        arr[l] = intArrayOf(i, j, k)
        visited[i][j][k] = true
    }
    var ans = 0
    for (l in 0 until M) {
        val curr = arr[l]
        val i = curr[0]
        val j = curr[1]
        val k = curr[2]
        try {
            if (visited[i + 1][j][k] && visited[i - 1][j][k] && visited[i][j - 1][k] && visited[i][j + 1][k] && visited[i][j][k - 1] && visited[i][j][k + 1]) {
                ans++
            }
        } catch (ignored: Exception) {
        }
    }
    println(ans)
}
