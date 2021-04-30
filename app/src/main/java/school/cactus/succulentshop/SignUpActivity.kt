package school.cactus.succulentshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = resources.getString(R.string.sign_up)

        binding.apply {
            buttonAlreadyHaveAccount.setOnClickListener {
                navigateToLogin()
            }

            buttonSignUp.setOnClickListener {
                textInputLayoutEmail.validate(EmailValidator())
                textInputLayoutUsername.validate(UsernameValidator())
                textInputLayoutSignUpPassword.validate(PasswordValidator())
            }
        }


    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}