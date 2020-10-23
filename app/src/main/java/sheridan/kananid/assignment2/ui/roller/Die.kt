package sheridan.kananid.assignment2.ui.roller

import android.util.Log

class Die() {

    // zero means not rolled yet

    var value1: Int = 0
    var value2: Int = 0
    var value3: Int = 0
    set(n) { //setter function for value
        if (n in 0..6) {
            field = n
        } else {
            Log.e("Die", "Illegal die value $n")

        }
    }

    //functioned called when dice is rolled
    fun roll() {
        value1 = (1..6).random() //stores random number between 1 to 6 for die 1
        value2 = (1..6).random() //stores random number between 1 to 6 for die 2
        value3 = (1..6).random() //stores random number between 1 to 6 for die 3
    }
}