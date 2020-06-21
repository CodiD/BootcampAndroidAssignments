package model.shelter

import java.util.*

// This class contains all properties related to the Shelter
data class Shelter(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val address: String,
    val phoneNumber:String
)