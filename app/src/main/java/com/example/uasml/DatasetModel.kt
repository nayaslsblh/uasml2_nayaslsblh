package com.example.uasml

data class DatasetModel(
    val density: Double,
    val age: Int,
    val weight: Double,
    val height: Double,
    val neck: Double,
    val chest: Double,
    val abdomen: Double,
    val hip: Double,
    val thigh: Double,
    val knee: Double,
    val ankle: Double,
    val biceps: Double,
    val forearm: Double,
    val wrist: Double,
    val bodyFat: Double? = null // optional target, nullable
)
