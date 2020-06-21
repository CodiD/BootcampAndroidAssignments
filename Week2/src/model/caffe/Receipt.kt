package model.caffe

import model.people.Patron
import model.people.Employee
import model.people.Person

// TODO add data, such as ID, list of products, and maybe an optional set of cats adopted/sponsored!
class Receipt {

    // I think this is not the proper way to access Person(), but I feel that I need to create an object of Person type
    // and need to add parameter values in order to do that
    val hanna = Patron("Hanna", "Barton", "h.barton@gmail.com", "207-405-234")
    val robin = Patron("Robin", "Neil", "r.neill@yahoo.com", "123-567-345")
    val maria = Patron("Maria", "Macmaire", "m.macmeirre@gmail.com", "205-456-256")
    val james = Patron("James", "Richmond", "j.richmond", "123-456-567")

    val Walter = Patron("Walter", "Meier", "w.meier@yahoo.com", "404-345-567")


    val raphael = Employee("Raphael", "Nadal", "r.nadal@yahoo.com", "612-412-234",
            2.300, "123-234-456", "02-03-2019")
    val meghan = Employee("Meghan", "Tommel", "m.tommel", "324-567-234",
            2.500, "123-234-456", "02-03-2019")

    val listofCustomers = arrayOf(hanna, robin, maria, james, Walter, raphael, meghan)


    var listOfItems = ""
    val greenTea = Product("1", "Hamburger", 12.0)
    val hotChocolate = Product("2", "Hot Chocolate", 4.0)
    val latteMachiato = Product("3", "Latte Machiato", 4.0)
    val coke = Product("4", "Coke", 3.0)
    val tunaSandwich = Product("5", "Tuna Sandwich", 6.0)
    val hamburger = Product("6", "Hamburger", 12.0)

    val foodItems = arrayOf(greenTea, hotChocolate, latteMachiato, coke, tunaSandwich, hamburger)

    // this function creates one receipt that lists all items and the total price
    fun createReceipt(): String {
        var sum: Double = 0.0
        for (customer in listofCustomers) {
            listOfItems += "Customer: ${customer.toString()}"
            for (item in foodItems) {
                listOfItems += "ItemID: ${item.id} \nItem: ${item.productName} \nPrice: ${item.price}"
                sum += item.price
                listOfItems += "\n The total price is $sum."
            }
         listOfItems = ""   // after each receipt we start a new one with a new customer
        }
    }


}