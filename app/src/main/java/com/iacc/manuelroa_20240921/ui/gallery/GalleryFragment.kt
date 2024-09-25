package com.iacc.manuelroa_20240921.ui.gallery

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.iacc.manuelroa_20240921.R
import com.iacc.manuelroa_20240921.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvPuntos
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Lista de conductores
        val conductores = listOf(
            ConductorGrafico("Juan Pérez", 34),
            ConductorGrafico("María Gómez", 45),
            ConductorGrafico("Carlos Sánchez", 27),
            ConductorGrafico("Laura Morales", 50),
            ConductorGrafico("Pedro Fernández", 12),
            ConductorGrafico("Ana Rodríguez", 40)
        )


        val entries = ArrayList<BarEntry>()
        for ((index, conductor) in conductores.withIndex()) {
            entries.add(BarEntry(index.toFloat(), conductor.nViajes.toFloat()))
        }


        val barDataSet = BarDataSet(entries, "Número de viajes")
        barDataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()

        // Configurar los datos del gráfico
        val barData = BarData(barDataSet)
        binding.barraGrafica.data = barData
        binding.barraGrafica.description.isEnabled = false
        binding.barraGrafica.description.text = "Gráfico Cantidad de Viajes"
        binding.barraGrafica.description.textSize = 16f
        binding.barraGrafica.description.typeface = Typeface.DEFAULT_BOLD // Negrita
        binding.barraGrafica.description.setPosition(800f, 50f)

        binding.barraGrafica.description.isEnabled = true

        binding.barraGrafica.animateY(1000)


        val xAxis: XAxis = binding.barraGrafica.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(conductores.map { it.nombre })
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(false)
        xAxis.labelRotationAngle = 45f
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
