package com.example.recyclerviewnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclerviewnew.adapters.RvAdapter
import com.example.recyclerviewnew.databinding.ActivityMainBinding
import com.example.recyclerviewnew.models.User

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<User>
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadData()
        rvAdapter = RvAdapter(list, object :RvAdapter.RvClick{
            override fun itemClick(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
            }
        })
        binding.rv.adapter = rvAdapter
    }

    private fun loadData() {
        list = ArrayList()

        for (i in 0..20) {
            list.add(User("https://hips.hearstapps.com/hmg-prod/images/red-fresh-apple-isolated-on-white-background-royalty-free-image-1627314996.jpg?crop=1.00xw:0.923xh;0,0.0486xh&resize=980:*", "Apple"))
            list.add(User("https://familytreefarms.com/wp-content/uploads/2021/03/PeachYellow.jpg","Peach"))
            list.add(User("https://th-thumbnailer.cdn-si-edu.com/6RD8JDrASGTSjdbsJkg-37OY9mQ=/1072x720/filters:no_upscale()/https://tf-cmsv2-smithsonianmag-media.s3.amazonaws.com/filer/d5/24/d5243019-e0fc-4b3c-8cdb-48e22f38bff2/istock-183380744.jpg", "Banana"))
            list.add(User("https://i5.walmartimages.com/seo/Fresh-Mangoes-Each-Sweet_cc54242f-cb87-4a25-9baa-fccaa20f5443.64fa79325ad44a7352dcd3c2a8b477be.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF", "Mango"))
        }
    }
}