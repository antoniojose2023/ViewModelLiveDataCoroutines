package br.com.antoniojoseuchoa.viewmodellivedatacoroutines

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        urlViewModel.url.observe(viewLifecycleOwner){ state ->
            when(state){
                UrlViewModel.States.Loader -> {binding.progressCircular.visibility = View.VISIBLE}
                is UrlViewModel.States.Erro -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(), "erro ${state.mensage}", Toast.LENGTH_LONG).show()
                }
                is UrlViewModel.States.Sucess -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    binding.rvUrls.layoutManager = LinearLayoutManager(requireActivity())
                    val adapter = AdapterUrl()
                    adapter.submitList(state.list)
                    binding.rvUrls.adapter = adapter
                }

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}