package com.example.lesson6task5kotlin.Model

class User(private  var firstName: String, private  var lastName: String, var available: Boolean = false) {

    fun User(firstName: String?, lastName: String?, available: Boolean) {
        this.firstName = firstName!!
        this.lastName = lastName!!
        this.available = available
    }
    fun isAvailable(): Boolean {
        return available
    }
     fun getFirstName(): String{
        return firstName
    }
    fun getLastName(): String{
        return lastName
    }
}