package com.aayush.fragementlist

import android.app.Dialog
import android.os.Bundle
import android.text.style.UpdateLayout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import com.aayush.fragementlist.databinding.ActivityMainBinding.inflate
import com.aayush.fragementlist.databinding.FragmentArrayListBinding
import com.aayush.fragementlist.databinding.NewAddLayoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArrayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArrayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var arrayList :ArrayList<String> = ArrayList()
    lateinit var binding: FragmentArrayListBinding
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
        // Inflate the layout for this fragment
        binding=FragmentArrayListBinding.inflate(layoutInflater)
        var adapter=ArrayAdapter(requireContext(),R.layout.simple_list_item_1, arrayList)
        var dialog= Dialog(requireContext())
        arrayList.add("aayush")
        arrayList.add("raj")
        arrayList.add("rahul")
        binding.list.adapter=adapter

        binding.fabAdd.setOnClickListener{
            var dialogBinding= NewAddLayoutBinding.inflate(layoutInflater)
            var dialog=Dialog(requireContext())
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialogBinding.btnAddItem.setOnClickListener {
                if (dialogBinding.etAmount.text.toString().isNullOrEmpty()) {
                    dialogBinding.etAmount.setError("Enter new item")
                } else {
                    arrayList.add(dialogBinding.etAmount.text.toString())
                    dialog.dismiss()
                }
            }
                dialog.show()
            }
            binding.list.setOnItemClickListener {    adapterView, view, i, l ->
                var dialogBinding = UpdateLayoutBinding.inflate(layoutInflater)
                var dialog = Dialog(requireContext())
                dialog.setContentView(dialogBinding.root)
                dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
                dialogBinding.etUpdate.setText(arrayList[i])
                dialogBinding.btnUpdateItem.setOnClickListener {
                    if (dialogBinding.etUpdate.text.toString().isNullOrEmpty()) {
                        dialogBinding.etUpdate.setError("Enter Update Item")
                    } else {
                        arrayList.set(i, dialogBinding.etUpdate.text.toString())
                        dialog.dismiss()
                    }
                }
                dialog.show()
            }

            return binding.root
        }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArrayFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArrayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}