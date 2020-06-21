package model.animals

import model.caffe.Sponsorship
import model.people.Patron
import model.people.Employee
import model.people.Person
import java.util.*

data class Cat(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val gender: String,
    val shelterId: String,
    val sponsorships: MutableSet<Sponsorship> = mutableSetOf()
)

fun adoptCat( id: Person) {

}

fun sponsorCat( id: Person) {

}