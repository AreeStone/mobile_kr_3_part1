import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kr_3_mobile.Ticket
import com.example.kr_3_mobile.databinding.TicketItemBinding

class TicketAdapter(private val tickets: List<Ticket>) : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    class TicketViewHolder(val binding: TicketItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = TicketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = tickets[position]
        holder.binding.firstNameText.text = "Имя: ${ticket.firstName}"
        holder.binding.lastNameText.text = "Фамилия: ${ticket.lastName}"
        holder.binding.flightText.text = "Рейс: ${ticket.flight}"
        holder.binding.totalCostText.text = "Стоимость: ${ticket.totalCost()} ₽"
    }

    override fun getItemCount() = tickets.size
}
