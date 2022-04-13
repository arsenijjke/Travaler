package com.example.travaler.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.data.database.User
import com.example.data.network.Api
import com.example.travaler.databinding.FragmentRegistrationBinding
import com.example.data.repository.AuthRepository
import com.example.travaler.model.viewmodels.AuthViewModel
import com.example.travaler.model.viewmodels.UserViewModel
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
class RegistrationFragment : BaseFragment<AuthViewModel, FragmentRegistrationBinding, AuthRepository>() {

    private lateinit var userViewModel: UserViewModel

    override fun getViewModel(): Class<AuthViewModel> = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegistrationBinding.inflate(inflater,container,false)

    override fun getRepository() = AuthRepository(retrofit.buildApi(api = Api::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setImage()
        toHome()
    }

    private fun setImage() {
        val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.set1.setImageURI(it)
        }
        val selectImage1 = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.set2.setImageURI(it)
        }
        val selectImage2 = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.set3.setImageURI(it)
        }
        with(binding) {
            set1.setOnClickListener { selectImage.launch("image/*") }
            set2.setOnClickListener { selectImage1.launch("image/*") }
            set3.setOnClickListener { selectImage2.launch("image/*") }
        }
    }

    private fun toHome() {
        binding.btnContinue.setOnClickListener {
            insertDataToDatabase()
            findNavController().navigate(
                RegistrationFragmentDirections.registrationToHome()
            )
        }
    }

    private fun insertDataToDatabase() {
        val nickname = binding.login.text.toString()
        val password = binding.password.text.toString()
        val photo = getBitmap()
        if(inputCheck(nickname,password,photo)) {
            val user = User(0,nickname, password, photo)
            userViewModel.addUser(user)
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(context,"Failure",Toast.LENGTH_SHORT).show()
        }
    }

    /** Converting image to bitmap */
    private fun getBitmap(): Bitmap {
        val profilePhoto = binding.set1.drawable
        return (profilePhoto as BitmapDrawable).bitmap
    }

    private fun inputCheck(name: String, password: String, photo: Bitmap): Boolean {
        var isEmpty = true
        when {
            TextUtils.isEmpty(name) -> {
                binding.loginInput.error = "Please enter your name!"
                isEmpty = false
            }
            TextUtils.isEmpty(password) -> {
                binding.passwordInput.error = "Please enter your paswword!"
                isEmpty = false
            }
            photo == null -> {
                Toast.makeText(context, "Select at least 1 photo", Toast.LENGTH_LONG).show()
                isEmpty = false
            }
        }
        return isEmpty
    }

}
