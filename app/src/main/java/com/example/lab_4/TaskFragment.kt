import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.first_app_1.R

class TaskFragment : Fragment() {

    companion object {
        private const val ARG_DATE = "date"
        private const val ARG_DESCRIPTION = "description"

        // Метод для создания экземпляра фрагмента с данными задачи
        fun newInstance(date: String, description: String) = TaskFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_DATE, date)
                putString(ARG_DESCRIPTION, description)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Раздуваем разметку фрагмента
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем аргументы и устанавливаем их в текстовые поля
        val taskDate = view.findViewById<TextView>(R.id.taskDate)
        val taskDescription = view.findViewById<TextView>(R.id.taskDescription)

        val date = arguments?.getString(ARG_DATE)
        val description = arguments?.getString(ARG_DESCRIPTION)

        taskDate.text = date
        taskDescription.text = description
    }
}