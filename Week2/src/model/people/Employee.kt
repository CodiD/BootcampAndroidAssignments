package model.people
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Employee(
    firstName: String,
    lastName: String,
    email: String,
    phoneNumber: String,
    val salary: Double,
    val socialSecurityNumber: String,
    val hireDate: String
) : Person(firstName = firstName, lastName = lastName, email = email, phoneNumber = phoneNumber) {



    fun getEmployeeList():mutablelist {
        val raphael = Employee("Raphael", "Nadal", "r.nadal@yahoo.com", "612-412-234",
                2.300, "123-234-456", "02-03-2019")
        val meghan = Employee("Meghan", "Tommel", "m.tommel",
                "324-567-234",
                2.500, "123-234-456", "02-03-2019")
        val listEmployee: MutableList<Employee> = mutableListOf(raphael, meghan)
        return listEmployee
    }




   //returning data
    override fun toString(): String {
        return " ID: $id First Name: $firstName $lastName \nEmail: $email \nPhoneNumber: $phoneNumber" +
                "\nSalary: $salary \nSSN: $socialSecurityNumber \nHIre Date: $hireDate"


    }



    /**
     * Prints a time of clocking in, in a nice format.
     *
     * Hint: to get time, you can create a `Date` object. Use SimpleDateFormatter to format the time!
     * */
    fun clockIn():String {
        val clockIn = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = clockIn.format(formatter)

        return "Clock in Date and Time is: $formatted"
    }

    // TODO same as above, but times for clocking out!
    fun clockOut():String {
        val clockOut = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = clockOut.format(formatter)

        return "Clock Out Date and Time is: $formatted"

    }
}