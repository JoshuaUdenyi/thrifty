package com.udenyijoshua.thrifty.model

import com.udenyijoshua.thrifty.R

object CheckoutDataSource {

    val checkOutList = mutableListOf<Product>()

    fun loadProduct(): List<Product> {
        return checkOutList.toList()
    }

    fun addProduct(product: Product) {
        checkOutList.add(product)
    }
}