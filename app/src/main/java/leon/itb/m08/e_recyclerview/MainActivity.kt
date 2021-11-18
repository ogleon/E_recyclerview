package leon.itb.m08.e_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import leon.itb.m08.e_recyclerview.databinding.ActivityMainBinding
import leon.itb.m08.e_recyclerview.ui.add.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, SecondFragment()).commit()
        }
    }
}