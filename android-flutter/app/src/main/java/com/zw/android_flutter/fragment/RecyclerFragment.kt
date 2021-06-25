package com.zw.android_flutter.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zw.android_flutter.DemoBaseFragment
import com.zw.android_flutter.R
import com.zw.android_flutter.RecycleViewDivider

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RecyclerFragment : DemoBaseFragment() {
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecyclerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        @JvmStatic
        fun newInstance() = RecyclerFragment()
    }

    private var param1: String? = null
    private var param2: String? = null

    private var recyclerView: RecyclerView? = null

    private var data = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_recycler, container, false)
        recyclerView = v.findViewById(R.id.recyclerView)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (i in 10000..10100) {
            data.add("$i")
        }
        var m = LinearLayoutManager(context)
        m.orientation = LinearLayoutManager.VERTICAL
        recyclerView?.layoutManager = m
        recyclerView?.addItemDecoration(
            RecycleViewDivider(
                context,
                LinearLayoutManager.HORIZONTAL,
                10,
                Color.parseColor("#FF0000")
            )
        )
        recyclerView?.adapter = MyAdapter()
    }

    private inner class MyAdapter : RecyclerView.Adapter<VH>() {
        override fun getItemCount(): Int {
            return data.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            var v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
            var vh = VH(v)
            return vh
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.setTextStr(data.get(position))
        }
    }

    private inner class VH : RecyclerView.ViewHolder {
        private var tv: TextView? = null

        constructor(v: View) : super(v) {
            tv = v.findViewById(R.id.tv)
        }

        fun setTextStr(s: String) {
            tv?.setText(s)
        }
    }
}