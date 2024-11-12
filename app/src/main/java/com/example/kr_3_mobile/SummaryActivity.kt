import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kr_3_mobile.TicketViewModel
import com.example.kr_3_mobile.databinding.ActivitySummaryBinding


class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    private val viewModel: TicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.tickets.observe(this) { tickets ->
            binding.totalCostText.text = "Общая стоимость: ${viewModel.getTotalCost()} ₽"
            binding.adultTicketCountText.text = "Взрослых билетов: ${viewModel.getAdultTicketCount()}"
            binding.childTicketCountText.text = "Детских билетов: ${viewModel.getChildTicketCount()}"
            binding.ticketRecyclerView.adapter = TicketAdapter(tickets)
        }
    }
}
