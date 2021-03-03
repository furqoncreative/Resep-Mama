package id.furqoncreatice.resepmama

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import id.furqoncreatice.resepmama.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), RecipesAdapter.onItemClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecipesAdapter
    lateinit var items: ArrayList<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycleview()
        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView: SearchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filter(query)
//                    Toast.makeText(this@MainActivity, "No Match found", Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun filter(text: String) {
        val newList = ArrayList<Recipe>()
        for (item in items) {
            if (item.title.toLowerCase().contains(text)) {
                newList.add(item)
            }
        }
        adapter.setFilter(newList)
    }

    fun setRecycleview() {
        adapter = RecipesAdapter(this)
        binding.rvRecipe.adapter = adapter
        binding.rvRecipe.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun setData() {
        items = ArrayList()

        items.add(
            Recipe(
                "Ayam Pop AJI‑NO‑MOTO®",
                R.drawable.img_ayam_pop,
                resources.getString(
                    R.string.recipe_4
                ),
                "https://www.dapurumami.com/resep/ayam-pop-aji-no-moto-6zBuB"
            )
        )

        items.add(
            Recipe(
                "Ayam Taliwang AJI‑NO‑MOTO®",
                R.drawable.img_ayam_taliwang,
                resources.getString(
                    R.string.recipe_2
                ),
                "https://www.dapurumami.com/resep/ayam-taliwang-aji-no-moto-jMfYZ"
            )
        )

        items.add(
            Recipe(
                "Ayam Tuturuga Manado",
                R.drawable.img_ayam_tuturaga,
                resources.getString(
                    R.string.recipe_10
                ),
                "https://www.dapurumami.com/resep/ayam-tuturuga-manado-PZHf1"
            )
        )

        items.add(
            Recipe(
                "Bandeng Pallumara AJI‑NO‑MOTO®",
                R.drawable.img_bandeng,
                resources.getString(
                    R.string.recipe_9
                ),
                "https://www.dapurumami.com/resep/bandeng-pallumara-aji-no-moto-6glSh"
            )
        )

        items.add(
            Recipe(
                "Coto Makassar AJI‑NO‑MOTO®",
                R.drawable.img_coto,
                resources.getString(
                    R.string.recipe_5
                ),
                "https://www.dapurumami.com/resep/coto-makassar-aji-no-moto-qrjkJ"
            )
        )

        items.add(
            Recipe(
                "Daging Asam Padeh Sajiku®",
                R.drawable.img_daging,
                resources.getString(
                    R.string.recipe_3
                ),
                "https://www.dapurumami.com/resep/daging-asam-padeh-sajiku-LfnTn"
            )
        )

        items.add(
            Recipe(
                "Garang Asem Daging Sajiku®",
                R.drawable.img_garang,
                resources.getString(
                    R.string.recipe_6
                ),
                "https://www.dapurumami.com/resep/garang-asem-daging-sajiku-KmQXn"
            )
        )

        items.add(
            Recipe(
                "Oseng Tempe Kacang Panjang",
                R.drawable.img_orek_tempe,
                resources.getString(
                    R.string.recipe_1
                ),
                "https://www.dapurumami.com/resep/oseng-tempe-kacang-panjang-5XjRp"
            )
        )

        items.add(
            Recipe(
                "Sate Maranggi Saus Teriyaki",
                R.drawable.img_sate,
                resources.getString(
                    R.string.recipe_7
                ),
                "https://www.dapurumami.com/resep/sate-maranggi-saus-teriyaki-IDOK5"
            )
        )
        items.add(
            Recipe(
                "Soto Banjar AJI‑NO‑MOTO®",
                R.drawable.img_soto_banjar,
                resources.getString(
                    R.string.recipe_8
                ),
                "https://www.dapurumami.com/resep/soto-banjar-aji-no-moto-TnrWE"
            )
        )
        adapter.setItems(items)
    }

    override fun onClick(item: Recipe) {
        val intent = Intent(this, DetailRecipeActivity::class.java)
        intent.putExtra("ITEM", item)
        startActivity(intent)
    }
}

