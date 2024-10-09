import android.content.Context
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_app_1.R
import com.example.lab_4.Activity_lab3_2
import com.example.lab_4.Task

class TaskAdapter(
    private val taskList: List<Task>,
    private val context: Context
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder для хранения ссылок на элементы разметки
    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {
        val taskDate: TextView = view.findViewById(R.id.taskDate)
        val taskDescription: TextView = view.findViewById(R.id.taskDescription)

        init {
            // Регистрация контекстного меню для каждого элемента списка
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            // Заполнение контекстного меню из ресурса
            val inflater: MenuInflater = (context as Activity_lab3_2).menuInflater
            inflater.inflate(R.menu.context_menu, menu)

            // Устанавливаем обработчик нажатий на элементы меню
            menu.findItem(R.id.menu_edit).setOnMenuItemClickListener {
                showMenuAction(adapterPosition, "Edit")
                true
            }

            menu.findItem(R.id.menu_delete).setOnMenuItemClickListener {
                showMenuAction(adapterPosition, "Delete")
                true
            }
        }

        // Выводим в консоль выбранное действие и индекс элемента
        private fun showMenuAction(position: Int, action: String) {
            Log.d("picked: ", "Action: $action, Item index: $position")
        }
    }

    // Создание нового ViewHolder для элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    // Привязка данных к ViewHolder
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskDate.text = task.date
        holder.taskDescription.text = task.description
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}