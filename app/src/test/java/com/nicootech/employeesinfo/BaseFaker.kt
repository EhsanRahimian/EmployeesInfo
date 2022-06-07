package com.nicootech.employeesinfo

import com.github.javafaker.Faker

abstract class BaseFaker {
    companion object {
        fun <T> list(minCount: Int = 0, basic: () -> T): List<T> {
            val list = mutableListOf<T>()
            for (i in 0..minCount + (2..10).random()) list.add(basic())
            return list
        }

        object Fake {
            var fake: Faker = Faker()
        }
    }
}