package com.diego.duarte.base_presentation.utils

import java.text.NumberFormat

fun Number.asCurrency(): String = NumberFormat.getCurrencyInstance().format(this.toDouble())