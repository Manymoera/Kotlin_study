import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.first_app_1.R

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        // Находим кнопки "Добавить страницу" и "Убрать страницу"
        val addPageButton: Button = view.findViewById(R.id.addPageButton)
        val removePageButton: Button = view.findViewById(R.id.removePageButton)

        // Установка действия для кнопки "Добавить страницу"
        addPageButton.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()

            val secondFragment = SecondFragment()

            // Скрываем первый объект, добавляем второй фрагмент и сохраняем первый в стеке
            transaction.hide(this)
            transaction.add(R.id.fragment_container, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // Установка действия для кнопки "Убрать страницу"
        removePageButton.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack() // Убираем последний фрагмент из стека
        }

        return view
    }
}