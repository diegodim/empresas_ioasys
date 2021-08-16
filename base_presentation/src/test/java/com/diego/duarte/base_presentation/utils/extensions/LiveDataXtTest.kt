package com.diego.duarte.base_presentation.utils.extensions

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.diego.duarte.base_presentation.core.ViewState
import com.diego.duarte.base_presentation.utils.EventLiveData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class LiveDataXtTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `postNeutral() MUST set status to NEUTRAL WHEN it called`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postNeutral()
        assertEquals(mutableLiveData.value?.status, ViewState.Status.NEUTRAL)
        assertEquals(mutableLiveData.value?.data, null)
        assertEquals(mutableLiveData.value?.error, null)
    }

    @Test
    fun `setSuccess() MUST set status to SUCCESS and set data WHEN it called`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postSuccess(true)
        assertEquals(mutableLiveData.value?.status, ViewState.Status.SUCCESS)
        assertEquals(mutableLiveData.value?.data, true)
        assertEquals(mutableLiveData.value?.error, null)

        mutableLiveData.postSuccess(false)
        assertEquals(mutableLiveData.value?.status, ViewState.Status.SUCCESS)
        assertEquals(mutableLiveData.value?.data, false)
        assertEquals(mutableLiveData.value?.error, null)
    }

    @Test
    fun `postSuccess() MUST set status to SUCCESS and set data to received data WHEN it called`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postSuccess(true)
        assertEquals(mutableLiveData.value?.status, ViewState.Status.SUCCESS)
        assertEquals(mutableLiveData.value?.data, true)
        assertEquals(mutableLiveData.value?.error, null)

        mutableLiveData.postSuccess(false)
        assertEquals(mutableLiveData.value?.status, ViewState.Status.SUCCESS)
        assertEquals(mutableLiveData.value?.data, false)
        assertEquals(mutableLiveData.value?.error, null)
    }

    @Test
    fun `setError() MUST set status to ERROR and set data to null WHEN receives a throwable`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postError(Throwable("Error!"))
        assertEquals(mutableLiveData.value?.status, ViewState.Status.ERROR)
        assertEquals(mutableLiveData.value?.data, null)
        assertEquals(mutableLiveData.value?.error?.message, "Error!")
        assertTrue(mutableLiveData.value?.error is Throwable)
    }

    @Test
    fun `setError() MUST set status to ERROR and set data to null WHEN receives a message`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postError("Error!")
        assertEquals(mutableLiveData.value?.status, ViewState.Status.ERROR)
        assertEquals(mutableLiveData.value?.data, null)
        assertEquals(mutableLiveData.value?.error?.message, "Error!")
        assertTrue(mutableLiveData.value?.error is RuntimeException)
    }

    @Test
    fun `postError() MUST set status to ERROR and set data null WHEN it called`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postError(Throwable("Error!"))
        assertEquals(mutableLiveData.value?.status, ViewState.Status.ERROR)
        assertEquals(mutableLiveData.value?.data, null)
        assertTrue(mutableLiveData.value?.error is Throwable)
    }

    @Test
    fun `postError() MUST set status to ERROR and set data to null WHEN receives a message`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postError("Error!")
        assertEquals(mutableLiveData.value?.status, ViewState.Status.ERROR)
        assertEquals(mutableLiveData.value?.data, null)
        assertEquals(mutableLiveData.value?.error?.message, "Error!")
        assertTrue(mutableLiveData.value?.error is RuntimeException)
    }

    @Test
    fun `postLoading() MUST set status to LOADING and set data to null WHEN receives a message`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postLoading()
        assertEquals(mutableLiveData.value?.status, ViewState.Status.LOADING)
        assertEquals(mutableLiveData.value?.data, null)
        assertEquals(mutableLiveData.value?.error, null)
    }

    @Test
    fun `setLoading() MUST set status to LOADING and set data to null WHEN receives a message`() {
        val mutableLiveData = EventLiveData<ViewState<Boolean>>()
        mutableLiveData.postLoading()
        assertEquals(mutableLiveData.value?.status, ViewState.Status.LOADING)
        assertEquals(mutableLiveData.value?.data, null)
        assertEquals(mutableLiveData.value?.error, null)
    }

    @Test
    fun `ensure that asLiveData() returns an equivalent value`() {
        val a: EventLiveData<Boolean> = EventLiveData()
        a.value = true
        assertTrue(a.asLiveData().value == true)
    }

}