package id.furqoncreatice.resepmama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.furqoncreatice.resepmama.databinding.ActivityAboutBinding
import id.furqoncreatice.resepmama.databinding.ActivityDetailRecipeBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        Glide.with(this).load(R.drawable.image_dp).circleCrop().into(binding.imageView)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}