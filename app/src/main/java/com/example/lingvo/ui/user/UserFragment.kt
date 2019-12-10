package com.example.lingvo.ui.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.lingvo.R
import com.example.lingvo.ui.tests.TestsFragment
import kotlinx.android.synthetic.main.fragment_user.view.*

class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userViewModel =
            ViewModelProviders.of(this).get(UserViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_user, container, false)

        root.button_login.setOnClickListener {
            val user = root.edit_username.text.toString()
            val pass = root.edit_password.text.toString()
            userViewModel.logIn(user, pass)

            if (userViewModel.isLogged) {
                Toast.makeText(activity, "Success", Toast.LENGTH_LONG).show()
                activity.let { it as UserFragmentContainer }
                    .saveCredentials(user, pass)
            } else {
                Toast.makeText(activity, "Failed", Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    interface UserFragmentContainer {
        fun saveCredentials(user: String, password: String)
    }
}
