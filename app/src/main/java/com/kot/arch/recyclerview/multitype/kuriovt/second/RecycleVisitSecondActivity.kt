package com.kot.arch.recyclerview.multitype.kuriovt.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.PRIMARY
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.TERTIARY
import com.john.kot.databinding.ContentRecycleVisitBinding

class RecycleVisitSecondActivity : AppCompatActivity() {

    private lateinit var binding: ContentRecycleVisitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentRecycleVisitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = layoutManager
        val visitRecyclerAdapter = FeedAdapter()
        val arrayListOf = arrayListOf<FeedItem>()
        arrayListOf.add(FeedItem("layout", Article("Article", "0000 name", "url")))
        for (i in 0..20) {
            arrayListOf.add(FeedItem("layout", Episode("$i Episode", PRIMARY, "imageurl")))
        }
        arrayListOf.add(FeedItem("layout", Canvas("Canvas  name", TERTIARY)))
        visitRecyclerAdapter.setList(arrayListOf)
        binding.recycleView.adapter = visitRecyclerAdapter

    }

}