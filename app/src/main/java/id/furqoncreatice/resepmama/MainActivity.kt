package id.furqoncreatice.resepmama

import android.app.SearchManager
import android.content.Context
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycleview()
        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_recipe, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView? = searchItem?.actionView as SearchView

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return super.onCreateOptionsMenu(menu)
    }

    fun setRecycleview() {
        adapter = RecipesAdapter(this)
        binding.rvRecipe.adapter = adapter
        binding.rvRecipe.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun setData() {
        val items = ArrayList<Recipe>()
        items.add(Recipe(1, "Test 1","https://www.dapurumami.com/uploads/recipe/WJYla/Ayam%20Goreng%20Lengkuas%20ala%20Sajiku-2.jpg","Test"))
        items.add(Recipe(2, "Test 2","https://www.dapurumami.com/uploads/recipe/WJYla/Ayam%20Goreng%20Lengkuas%20ala%20Sajiku-2.jpg","Test"))
        items.add(Recipe(3, "Test 3","https://www.dapurumami.com/uploads/recipe/WJYla/Ayam%20Goreng%20Lengkuas%20ala%20Sajiku-2.jpg","Test"))
        items.add(Recipe(4, "Test 4","https://www.dapurumami.com/uploads/recipe/WJYla/Ayam%20Goreng%20Lengkuas%20ala%20Sajiku-2.jpg","Test"))
        items.add(Recipe(5, "Test 5","https://www.dapurumami.com/uploads/recipe/WJYla/Ayam%20Goreng%20Lengkuas%20ala%20Sajiku-2.jpg","Test"))
        items.add(Recipe(6, "Test 6","https://www.dapurumami.com/uploads/recipe/WJYla/Ayam%20Goreng%20Lengkuas%20ala%20Sajiku-2.jpg","Test"))
        adapter.setItems(items)
    }

    override fun onClick(id: Int) {
        val intent = Intent(this, DetailRecipeActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
    }
}