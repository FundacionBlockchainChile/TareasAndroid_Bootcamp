package com.example.saludo

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val webView: WebView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("URL")
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}