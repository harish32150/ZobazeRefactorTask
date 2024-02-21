package com.zobaze.zobazerefractortask.domain


/**
 * Result defining outcome of task either [Success] or [Error] from domain layer
 * [Loading] is included to show intermediate loading state
 *
 * @param T defines type of result
 */
sealed interface KResult<out T> {
    @JvmInline
    value class Success<out T>(val value: T): KResult<T>

    data object Loading: KResult<Nothing>

    @JvmInline
    value class Error(val throwable: Throwable): KResult<Nothing>
}

/** HOF to encapsulate task result in [KResult], on exception [KResult.Error] is returned */
inline fun <T> runCatchingResult(block: () -> T): KResult<T> =
    try {
        KResult.Success(block())
    } catch (e: Exception) {
        KResult.Error(e)
    }

/** Simple transformation operator applicable on [KResult] */
inline fun <T, R> KResult<T>.map(transform: (value: T) -> R): KResult<R> =
    when (this) {
        is KResult.Success -> KResult.Success(transform(value))
        is KResult.Error -> KResult.Error(throwable)
        is KResult.Loading -> KResult.Loading
    }

/** Provides abstracted functionality to handle [KResult] gracefully */
inline fun <T> KResult<T>.handle(
    onSuccess: (T) -> Unit,
    onLoading: (Boolean) -> Unit = {},
    onError: (Throwable) -> Unit = {}
) {
    when(this) {
        is KResult.Success -> {
            onLoading(false)
            onSuccess(value)
        }
        is KResult.Loading -> onLoading(true)
        is KResult.Error -> onError(throwable)
    }
}