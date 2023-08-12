package com.kot.arch.recyclerview.multitype.kuriovt.third

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Article
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Canvas
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Episode
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.PRIMARY
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.TERTIARY
import com.john.kot.databinding.ContentRecycleVisitBinding

class RecycleVisitThirdActivity : AppCompatActivity() {

    private lateinit var binding: ContentRecycleVisitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentRecycleVisitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = layoutManager
        val visitRecyclerAdapter = FeedAdapter()
        val arrayListOf = arrayListOf<FeedItem>()
        arrayListOf.add(FeedItem("1111", Article("Article", "0000 name", "url")))
        for (i in 0..20) {
            arrayListOf.add(FeedItem("2222", Episode("$i Episode", PRIMARY, "imageurl")))
        }
        arrayListOf.add(FeedItem("3333", Canvas("Canvas  name", TERTIARY)))
        visitRecyclerAdapter.setList(arrayListOf)
        binding.recycleView.adapter = visitRecyclerAdapter

    }

}