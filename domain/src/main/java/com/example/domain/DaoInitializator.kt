package com.example.domain

interface DaoInitializator {
    fun create(type: DatabaseType) : Database
}