import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kr_3_mobile.Ticket
import com.example.kr_3_mobile.TicketViewModel
import com.example.kr_3_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val ticket = Ticket(
                firstName = binding.firstNameInput.text.toString(),
                lastName = binding.lastNameInput.text.toString(),
                flight = binding.flightInput.text.toString(),
                adultTicketCount = binding.adultCountInput.text.toString().toInt(),
                childTicketCount = binding.childCountInput.text.toString().toInt(),
                ticketPrice = binding.priceInput.text.toString().toDouble()
            )
            viewModel.addTicket(ticket)
            startActivity(Intent(this, SummaryActivity::class.java))
        }
    }
}
