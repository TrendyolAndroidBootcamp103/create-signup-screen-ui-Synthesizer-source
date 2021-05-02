package school.cactus.succulentshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = resources.getString(R.string.log_in)

        binding.apply {
            buttonCreateAnAccount.setOnClickListener {
                navigateToSignUp()
            }

            buttonLogin.setOnClickListener {
                textInputLayoutIdentifier.validate(IdentityValidator())
                textInputLayoutLoginPassword.validate(PasswordValidator())
            }
        }
    }

    private fun navigateToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}
