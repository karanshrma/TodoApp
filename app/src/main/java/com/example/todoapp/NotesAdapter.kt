import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.ItemListener
import com.example.todoapp.Note
import com.example.todoapp.R

class NotesAdapter(private var tasksArray: MutableList<Note>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

        private lateinit var itemListener: ItemListener


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textview)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = tasksArray[position]
        holder.textView.text = note.title // Set text to the title of the Note
        holder.itemView.setOnClickListener {
            itemListener.onItemClicked(note)
        }

    }

    override fun getItemCount() = tasksArray.size

    fun setItems(newTasksArray: MutableList<Note>) {
        tasksArray = newTasksArray
        notifyDataSetChanged()
    }

    fun addTask(note: Note) {
        tasksArray.add(note)
        notifyItemInserted(tasksArray.size - 1)
    }
}
