package model.people

class Patron(
    firstName: String,
    lastName: String,
    email: String,
    phoneNumber: String
) : Person(firstName = firstName, lastName = lastName, email = email, phoneNumber = phoneNumber) {



    fun getPatronList():mutablelist<Patron> {
        val hanna = Patron("Hanna", "Barton", "h.barton@gmail.com", "207-405-234")
        val robin = Patron("Robin", "Neil", "r.neill@yahoo.com", "123-567-345")
        val maria = Patron("Maria", "Macmaire", "m.macmeirre@gmail.com", "205-456-256")
        val james = Patron("James", "Richmond", "j.richmond", "123-456-567")

        val Walter = Patron("Walter", "Meier", "w.meier@yahoo.com", "404-345-567")
        val listPatron: MutableList<Employee> = mutableListOf(hanna,robin,maria,james,walter)
        return listPatron
    }
    //turning the Data into a String
    override fun toString(): String {
        return " ID:$id \n Name: $firstName $lastName \nEmail: $email \nPhoneNumber: $phoneNumber"
    }


}