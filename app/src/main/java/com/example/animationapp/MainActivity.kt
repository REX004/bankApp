package com.example.animationapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.animationapp.databinding.LoginPasswordBinding
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseInternal
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var binding: LoginPasswordBinding
    private lateinit var supabase: SupabaseClient


    @OptIn(SupabaseInternal::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val supabaseUrl = "https://taiveobdxmijvagwftuv.supabase.co"
        val supabaseKey =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRhaXZlb2JkeG1panZhZ3dmdHV2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDY2OTEzOTMsImV4cCI6MjAyMjI2NzM5M30.CtF3QuD7OMEX1VgbBq4pqXbOMkrUt2jIxz6yOQ-6yt0"

        // todo создание supabase клиента
        supabase = createSupabaseClient(supabaseUrl = supabaseUrl, supabaseKey = supabaseKey) {
            install(Auth)
            install(Realtime)
            install(Storage)
            install(Postgrest)
            httpConfig {
                Logging { this.level = LogLevel.BODY }
            }
        }
        binding.signUpBT.setOnClickListener {
            val emaill = binding.loginET.text.toString()
            checkEmailFormat(emaill)
            binding.view.visibility = View.GONE
            binding.googleSignUpBT.visibility = View.GONE

            lifecycleScope.launch {
                val login = binding.loginET.text.toString()
                val passwordTXT = binding.passwordET.text.toString()
                val user = supabase.auth.signUpWith(Email) {
                    email = login
                    password = passwordTXT
                }
            }
        }
        binding.googleSignUpBT.setOnClickListener {
            val emaill = binding.loginET.text.toString()
            checkEmailFormat(emaill)


            }
        }



    private fun checkEmailFormat(emaill: String) {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(emaill)

        if (!matcher.matches()) {
            Toast.makeText(this, "Неверный формат адреса электронной почты", Toast.LENGTH_SHORT)
                .show()
        }

    }
}
