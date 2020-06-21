package model.caffe

import model.animals.Cat
import model.people.Employee
import model.people.Person
import model.people.Patron

class Cafe {


    // cafe related stuff

    /**
     * To simplify it, let's imitate a week-long cafe turnaround.
     *
     * Make sure to add your receipts to each set, with your data.
     * */

    val list = Receipt()
    val employee = Employee()
    val patron = Patron()


    private val receiptsByDay = mutableMapOf(
        "Monday" to mutableSetOf<Receipt>(list.createReceipt()),
        "Tuesday" to mutableSetOf<Receipt>(list.createReceipt()),
        "Wednesday" to mutableSetOf<Receipt>(list.createReceipt()),
        "Thursday" to mutableSetOf<Receipt>(list.createReceipt()),
        "Friday" to mutableSetOf<Receipt>(list.createReceipt()),
        "Saturday" to mutableSetOf<Receipt>(list.createReceipt()),
        "Sunday" to mutableSetOf<Receipt>(list.createReceipt())
    )

    // maybe as employees check in, you can add them to the list of working employees!
    private val employees = mutableSetOf<Employee>(employee.getEmployeeList())
    private val customers = mutableSetOf<Patron>(patron.getPatronList())

    // make sure to add sponsorships and tie them to people!
    private val sponsorships = mutableSetOf<Sponsorship>()

    // calling the functions clocking in and out to save the dates/times
    fun checkInEmployee(employee: Employee) {
        for(employ in employees)
            employ.clockIn()
    }

    fun checkOutEmployee(employee: Employee) {
        for(employ in employees)
            employ.clockOut()
    }

    fun showNumberOfReceiptsForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted!

        println("On $day you made ${receiptsByDay.size} transactions!")
    }

    fun getReceipt(items: List<Product>, customerId: String): Receipt {
        // TODO return a receipt! Also make sure to check if customer is also an employee

        return Receipt()
    }

    fun addSponsorship(catId: String, personId: String) {
        // TODO add the sponsorship
    }

    fun getWorkingEmployees(): Set<Employee> = employees

    fun getAdoptedCats(): Set<Cat> {

    }

    fun getSponsoredCats(): Set<Cat> {

    }

    fun getMostPopularCats(): Set<Cat> {

    }

    fun getTopSellingItems(): Set<Product> {

    }

    fun getAdopters(): List<Person> {
        return (employees + customers).filter { it.cats.isNotEmpty() }
    }
}