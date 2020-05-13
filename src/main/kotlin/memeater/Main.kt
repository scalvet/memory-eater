package memeater

fun main(args: Array<String>) {
    val v = mutableListOf<ByteArray>()
    while (true) {
        val b = ByteArray(1048576)
        v.add(b)
        val rt = Runtime.getRuntime()
        val freeMemory = rt.freeMemory() / (1024.0 * 1024.0)
        val totalMemory = rt.totalMemory() / (1024.0 * 1024.0)
        val maxMemory = rt.maxMemory() / (1024.0 * 1024.0)
        println("[freeMemory: ${freeMemory}MiB, totalMemory: ${totalMemory}MiB, maxMemory: ${maxMemory}MiB]")
    }
}