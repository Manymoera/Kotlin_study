import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_app_1.R
import com.example.lab_4.Task

// Адаптер для отображения списка задач
class TaskAdapter(private val taskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder, содержащий ссылки на элементы разметки
    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskDate: TextView = view.findViewById(R.id.taskDate)
        val taskDescription: TextView = view.findViewById(R.id.taskDescription)
    }

    // Создание нового ViewHolder для элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    // Привязка данных к элементу списка (ViewHolder)
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskDate.text = task.date
        holder.taskDescription.text = task.description
    }

    // Возвращает количество элементов в списке
    override fun getItemCount(): Int {
        return taskList.size
    }
}