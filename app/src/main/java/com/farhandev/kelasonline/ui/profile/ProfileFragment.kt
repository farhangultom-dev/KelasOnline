package com.farhandev.kelasonline.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.farhandev.kelasonline.R
import com.farhandev.kelasonline.databinding.FragmentProfileBinding
import com.farhandev.kelasonline.network.response.login.Data
import com.farhandev.kelasonline.preference.PrefManager
import com.farhandev.kelasonline.ui.login.LoginActivity

class ProfileFragment : Fragment(), ProfileView {
    private lateinit var fragmentProfileBinding: FragmentProfileBinding
    private lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater,container,false)
        presenter = ProfilePresenter(this, PrefManager(requireContext()))
        return fragmentProfileBinding.root
    }

    override fun setUpListener() {
        fragmentProfileBinding.btnLgout.setOnClickListener {
            presenter.logout()
        }
    }

    override fun user(user: Data) {
        fragmentProfileBinding.tvNama.text = user.name
        fragmentProfileBinding.tvEmail.text = user.email
    }

    override fun logout() {
        Toast.makeText(requireContext(),"Keluar", Toast.LENGTH_SHORT).show()
        startActivity(Intent(requireActivity(), LoginActivity::class.java))
        requireActivity().finish()
    }

}