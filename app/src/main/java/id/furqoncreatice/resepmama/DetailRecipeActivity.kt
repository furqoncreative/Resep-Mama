package id.furqoncreatice.resepmama

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import id.furqoncreatice.resepmama.databinding.ActivityDetailRecipeBinding


class DetailRecipeActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setData()

    }

    fun setData() {
        val item = intent.getParcelableExtra<Recipe>("ITEM")
        if (item != null) {
            findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = item.title
            Glide.with(binding.root).load(item.image).into(binding.thumbnail)
//            binding.content.textContent.text = item.content
            binding.content.webview.settings.javaScriptEnabled = true
            binding.content.webview.loadData(item.content, "text/html; charset=utf-8", "UTF-8")
        } else {
            Toast.makeText(this, "DATA NULL", Toast.LENGTH_SHORT).show()
        }

        findViewById<FloatingActionButton>(R.id.ic_web).setOnClickListener { view ->
//            val url = item.source
//            val i = Intent(Intent.ACTION_VIEW)
//            i.data = Uri.parse(url)
//            startActivity(i)

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Resep : ${item.title} \n ${item.source}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}