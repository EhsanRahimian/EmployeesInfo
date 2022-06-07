package com.nicootech.employeesinfo.util

interface EntityMapper<R> {
    fun mapFromEntity(): R
}

fun <R, T : EntityMapper<R>> Iterable<T>.mapFromEntities(): List<R> {
    return this.map { it.mapFromEntity() }
}