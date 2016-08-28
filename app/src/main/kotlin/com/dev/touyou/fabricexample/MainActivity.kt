package com.dev.touyou.fabricexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.twitter.sdk.android.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import io.fabric.sdk.android.Fabric

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authConfig = TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET)
        Fabric.with(this, Twitter(authConfig))
        setContentView(R.layout.activity_main)
    }

    companion object {

        // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
        internal val TWITTER_KEY = "wGllei6uqhuK4xZ9uuJhBNZcw"
        internal val TWITTER_SECRET = "yaIDX27cEdbxdWslq4EHCxcitFL0dOgFNPN4tUDUaviBOnQbpp"
    }

    fun toLoginView(v: View) {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}
