import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab_4.Task

class TaskPagerAdapter(fragmentActivity: FragmentActivity, private val tasks: List<Task>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = tasks.size

    override fun createFragment(position: Int): Fragment {
        val task = tasks[position]
        return TaskFragment.newInstance(task.date, task.description)
    }
}