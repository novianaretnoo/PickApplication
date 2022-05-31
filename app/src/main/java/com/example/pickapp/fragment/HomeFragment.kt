package com.example.pickapp.fragment
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickapp.DataActivity
import com.example.pickapp.DataActivity2
import com.example.pickapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentHomeBinding.inflate(layoutInflater)
        bind.btnFirst.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), DataActivity::class.java)
            startActivity(intent)
        }
        bind.btnMiddle.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), DataActivity2::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return bind.root
    }
}