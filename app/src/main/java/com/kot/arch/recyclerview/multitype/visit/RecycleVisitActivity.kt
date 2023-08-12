package com.kot.arch.recyclerview.multitype.visit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kot.arch.recyclerview.multitype.visit.Item.Companion.PRIMARY
import com.kot.arch.recyclerview.multitype.visit.Item.Companion.SECONDARY
import com.kot.arch.recyclerview.multitype.visit.Item.Companion.TERTIARY
import com.kot.databinding.ContentRecycleVisitBinding

class RecycleVisitActivity : AppCompatActivity() {

    private lateinit var binding: ContentRecycleVisitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentRecycleVisitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = layoutManager
        val visitRecyclerAdapter = VisitRecyclerAdapter()
        val arrayListOf = arrayListOf<Item>()

        arrayListOf.add(Item("0000 name", SECONDARY))
        for (i in 0..20) {
            arrayListOf.add(Item("$i name", PRIMARY))
        }
        arrayListOf.add(Item("Nnnnnn  name", TERTIARY))

        visitRecyclerAdapter.setList(arrayListOf)
        binding.recycleView.adapter = visitRecyclerAdapter

    }

}