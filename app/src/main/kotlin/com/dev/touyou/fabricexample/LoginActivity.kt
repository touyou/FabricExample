package com.dev.touyou.fabricexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.twitter.sdk.android.Twitter
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import io.fabric.sdk.android.Fabric

class LoginActivity : AppCompatActivity() {

    var loginButton: TwitterLoginButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authConfig = TwitterAuthConfig(MainActivity.TWITTER_KEY, MainActivity.TWITTER_SECRET)
        Fabric.with(this, Twitter(authConfig))
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.twitter_login_button) as TwitterLoginButton
        loginButton?.callback = object: Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>?) {
                val session = result?.data
                val msg = "@" + session?.userName + " logged in! (#" + session?.userId + ")"
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }

            override fun failure(exception: TwitterException?) {
                Log.d("TwitterKit", "Login with Twitter failure", exception)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        loginButton?.onActivityResult(requestCode, resultCode, data)
    }
}
