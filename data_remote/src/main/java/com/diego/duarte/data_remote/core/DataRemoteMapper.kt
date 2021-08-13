package com.diego.duarte.data_remote.core

interface  DataRemoteMapper<in R, out D> {

    fun toDomain(remote: R): D

    fun toDomain(remote: List<R>): List<D> {
        return remote.map { toDomain(it) }
    }
}