package com.udenyijoshua.thrifty.navigation

interface Destinations{
    val route: String
}

object Home:Destinations{
    override val route = "Home"
}
object Checkout:Destinations{
    override val route = "Checkout"
}
object CheckoutCompleted:Destinations{
    override val route = "CheckoutCompleted"
}