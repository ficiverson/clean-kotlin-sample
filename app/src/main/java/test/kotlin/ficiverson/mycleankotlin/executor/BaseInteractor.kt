package test.kotlin.ficiverson.mycleankotlin.executor

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
interface InteractorExecutor {
    fun execute(runnable: Runnable)
}

enum class DataPolicy {
    NETWORK, LOCAL, NETWORK_AND_LOCAL
}

enum class Status {
    SUCCESS, ERROR, IOERROR, NO_INTERNET_ERROR
}

data class Result<out T>(
        val data: T? = null,
        val error: Exception? = null
)

typealias Callback<T> = (T) -> Unit


abstract class BaseInteractor<in U, T>(private val executor: InteractorExecutor) {
    val handler = Handler(Looper.getMainLooper())

    abstract fun execute(params: U? = null, callback: Callback<T>)

    protected fun runOnExecutor(function: () -> Unit) {
        executor.execute(Runnable {
            function()
        })
    }

    protected fun notifyResult(data: T, callback: Callback<T>) {
        handler.post { callback(data) }
    }

    object ThreadPoolExecutor : InteractorExecutor {
        /**
         * Time to keep an idle thread if the size has expired.
         */
        private val KEEP_ALIVE_TIME = 1L

        /**
         * The number unit in seconds to wait.
         */
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS

        /**
         * The number of cores available.
         */
        private val NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()

        /**
         * The number of cores.
         */
        private val CORE_POOL_SIZE = NUMBER_OF_CORES + 1

        /**
         * The maximum number of processes running in the pool.
         */
        private val MAXIMUM_POOL_SIZE = NUMBER_OF_CORES * 2 + 1

        /**
         * The pool threadPolicy.
         */
        private val poolQueue: ExecutorService = ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, LinkedBlockingQueue())

        override fun execute(runnable: Runnable) {
            poolQueue.submit(runnable)
        }
    }
}