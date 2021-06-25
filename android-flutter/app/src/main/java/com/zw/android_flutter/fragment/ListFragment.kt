package com.zw.android_flutter.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.BaseAdapter
import android.view.LayoutInflater
import com.zw.android_flutter.DemoBaseFragment
import com.zw.android_flutter.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : DemoBaseFragment() {
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        @JvmStatic
        fun newInstance() = ListFragment()
    }

    private var param1: String? = null
    private var param2: String? = null

    private var listView: ListView? = null

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
        var view = inflater.inflate(R.layout.fragment_list, container, false)
        listView = view!!.findViewById(R.id.listview)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (i in 0..100) {
            data.add("$i")
        }
        listView?.adapter = MyAdpter()
    }

    private inner class MyAdpter : BaseAdapter() {
        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var v = convertView
            if (v == null) {
                v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
                var vh = VH(v)
                v?.tag = vh
            }

            var vh = v?.tag as VH
            vh?.setTextStr(data.get(position))

            return v!!
        }

        private inner class VH {
            private var tv: TextView? = null

            constructor(v: View) {
                tv = v.findViewById(R.id.tv)
            }

            fun setTextStr(s: String) {
                tv?.setText(s)
            }
        }
    }
}