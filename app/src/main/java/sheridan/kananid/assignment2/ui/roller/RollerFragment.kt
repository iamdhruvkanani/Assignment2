package sheridan.kananid.assignment2.ui.roller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_roller.*
import sheridan.kananid.assignment2.Die
import sheridan.kananid.assignment2.MainActivity
import sheridan.kananid.assignment2.R
import sheridan.kananid.assignment2.database.Envelope
import sheridan.kananid.assignment2.databinding.FragmentRollerBinding
import java.util.*


class RollerFragment : Fragment() {


    companion object{
        const val First_DIE_VALUE = "first_die_value"
        const val Second_DIE_VALUE = "second_die_value"
        const val Third_DIE_VALUE = "third_die_value"
        const val Current_Total_Value = "current_total_value"
    }

    private lateinit var binding : FragmentRollerBinding
    private lateinit var viewModel: RollerViewModel


    private val die =   Die() //object of type Die() Class

    private var totalValue = 0 //variable to save total value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    //overriding savedinstance state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(First_DIE_VALUE, die.value1)
        outState.putInt(Second_DIE_VALUE, die.value2)
        outState.putInt(Third_DIE_VALUE, die.value3)
        outState.putInt(Current_Total_Value,totalValue)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRollerBinding.inflate(inflater,container,false)


        //setting listeners for Buttons
        binding.rollButton.setOnClickListener { rollDice() }
        binding.resetButton.setOnClickListener{ resetValues()}

        //Getting saved instance
        if(savedInstanceState is Bundle){
            die.value1 = savedInstanceState.getInt(First_DIE_VALUE)
            die.value2 = savedInstanceState.getInt(Second_DIE_VALUE)
            die.value3 = savedInstanceState.getInt(Third_DIE_VALUE)
            totalValue = savedInstanceState.getInt(Current_Total_Value)
        }
        // Calling display function
        displayDice()




        return binding.root
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RollerViewModel::class.java)
        // TODO: Use the ViewModel
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_roller,menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return when(item.itemId){
            R.id.action_history -> {
                findNavController().navigate(R.id.action_global_to_history)
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    //function will called when roll button is clicked
    private fun rollDice() {
        Toast.makeText(getActivity(), getString(R.string.dice_rolled), Toast.LENGTH_SHORT).show()

        die.roll() //function called to generate random number
        calculateTotal() //calling function to calculate total
        displayDice() //displaying values


        // get urgent flag value
        val dieValue1 :String = die.value1.toString()
        val dieValue2 :String = die.value2.toString()
        val dieValue3 :String = die.value3.toString()
        val totalValue: String = totalValue.toString()


        viewModel.send(Envelope(0,dieValue1,dieValue2,dieValue3,totalValue, Date()))
    }
    //function to reset all values
    private fun resetValues() {
        Toast.makeText(getActivity(), getString(R.string.value_reset), Toast.LENGTH_SHORT).show()

        binding.resultOne.text = ""
        binding.resultTwo.text = ""
        binding.resultThree.text = ""
        binding.totalText.text = "0"
        totalValue = 0
        die.value1 = 0
        die.value2 = 0
        die.value3 = 0
    }
    //function to calculate total
    private fun calculateTotal(){
        totalValue = die.value1+die.value2+die.value3
        // totalValue += totalDieValue
    }

    //function to display all values
    private fun displayDice() {


        binding.resultOne.text =
            if (die.value1 > 0)
                die.value1.toString()
            else " "

        binding.resultTwo.text =
            if (die.value2 > 0)
                die.value2.toString()
            else " "

        binding.resultThree.text =
            if (die.value3 > 0)
                die.value3.toString()
            else " "

        binding.totalText.text =
            if (totalValue > 0)
                totalValue.toString()
            else "0"


    }




}