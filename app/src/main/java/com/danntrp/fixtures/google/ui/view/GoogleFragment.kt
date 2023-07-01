package com.danntrp.fixtures.google.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.danntrp.fixtures.ONESIGNAL_APP_ID
import com.danntrp.fixtures.R
import com.danntrp.fixtures.databinding.FragmentGoogleBinding
import com.danntrp.fixtures.google.data.model.NotificationPayload
import com.danntrp.fixtures.google.data.remote.OneSignalService
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class GoogleFragment : Fragment(R.layout.fragment_google) {

    private var _binding: FragmentGoogleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoogleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl("https://www.google.com/")
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://onesignal.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val oneSignalApi = retrofit.create(OneSignalService::class.java)

        val payload = NotificationPayload(
            app_id = ONESIGNAL_APP_ID,
            contents = mapOf("en" to "I'm push notification"),
            included_segments = listOf("All")
        )

        val call = oneSignalApi.postNotification(payload)
        call.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {}
            override fun onFailure(call: Call<Any>, t: Throwable) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}