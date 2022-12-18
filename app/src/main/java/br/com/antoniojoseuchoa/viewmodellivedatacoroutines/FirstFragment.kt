package br.com.antoniojoseuchoa.viewmodellivedatacoroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.databinding.FragmentFirstBinding
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.viewmodel.AdapterUrl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.viewmodel.UrlViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private val urlViewModel by viewModels<UrlViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        urlViewModel.url.observe(viewLifecycleOwner){
                binding.rvUrls.layoutManager = LinearLayoutManager(requireActivity())
                val adapter = AdapterUrl()
                adapter.submitList(it)
                binding.rvUrls.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}