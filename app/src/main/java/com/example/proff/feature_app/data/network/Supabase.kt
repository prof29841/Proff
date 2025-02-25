package com.example.proff.feature_app.data.network

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.googleNativeLogin
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Supabase {
    val client = createSupabaseClient(
        supabaseUrl = "https://nnctezenkkdwflrmazcg.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5uY3RlemVua2tkd2Zscm1hemNnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDAzODA1NzYsImV4cCI6MjA1NTk1NjU3Nn0.Q9nz2agku7BgW5Or1XoPyOBvkqfokgq4QExGmHfJ_Ss"
    ){
        install(Postgrest)
        install(Auth)
        install(Storage)
        install(ComposeAuth){
            this.googleNativeLogin(
                "547771656285-9ri8610e0ffmjqpn0keornasjep26q81.apps.googleusercontent.com"
            )
        }
    }
}