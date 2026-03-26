package com.example.catalogodestinos

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webview)

        val url = intent.getStringExtra("URL_DESTINO")

        webView.webViewClient = WebViewClient()

        webView.settings.javaScriptEnabled = true

        if (url != null) {
            webView.loadUrl(url)
        }
    }
}