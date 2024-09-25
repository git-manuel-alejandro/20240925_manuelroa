package com.iacc.manuelroa_20240921.ui.animacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.iacc.manuelroa_20240921.R

class AnimacionFragment : Fragment(R.layout.animacion_layout) {

    private val animacionViewModel: AnimacionViewModel by viewModels()

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val lottieAnimationView = view.findViewById<LottieAnimationView>(R.id.animationView)

        lottieAnimationView.setAnimation(R.raw.taxi)


        lottieAnimationView.playAnimation()
    }
}
