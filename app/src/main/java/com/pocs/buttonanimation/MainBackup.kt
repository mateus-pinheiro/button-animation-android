package com.pocs.buttonanimation

import android.os.Bundle
import android.view.View
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainBackup : AppCompatActivity() {

    private lateinit var rocketAnimation: Animation
    private var isFabButton = true
    private val location = IntArray(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scale = ScaleAnimation(
            1.0.toFloat(),
            0.toFloat(),
            1.0.toFloat(),
            1.5.toFloat()
        )
        scale.fillAfter = true
        scale.duration = 500

        val animation = ScaleAnimation(
            0.0f,
            1.0f,
            1.0f,
            1.0f,
            Animation.RELATIVE_TO_PARENT,
            0.0f,
            Animation.RELATIVE_TO_PARENT,
            0.0f
        )

        animation.duration = 700

        animation.interpolator = AccelerateDecelerateInterpolator()

        animation.fillAfter = true

        animated.getLocationOnScreen(location)


        rocketAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_button)

        animate.setOnClickListener {
//            animated.startAnimation(animation)
//            isFabButton = !isFabButton


//
//            when (isFabButton) {
//                true -> increaseButton(animated)
//                false -> decreaseButton(animated)
//            }
//
//            isFabButton = !isFabButton
            increaseButton(animated)
//            increaseButton(animated)
//            animated.visibility = View.VISIBLE
        }
    }

    private fun increaseButton(view: View) {

//        val sizeAnimator = ValueAnimator.ofInt(view.measuredWidth, view.measuredWidth * 5)
//
//
//        sizeAnimator.addUpdateListener {
//            val value = it.animatedValue as Int
//            val layoutParams = view.layoutParams
//            layoutParams.width = value
//            view.layoutParams = layoutParams
//        }
//
        var layoutWidth: Int = (view.rootView as View).measuredWidth
//        layoutWidth -= view.measuredWidth
//
//        val positioningAnimator = ValueAnimator.ofFloat(layoutWidth.toFloat())
//
//        positioningAnimator.addUpdateListener {
//            val value = it.animatedValue as Float
//            view.translationX = value
//        }
//
//        if (isFabButton) {
//            sizeAnimator.start()
//        } else {
//            positioningAnimator.start()
//        }

//        isFabButton = !isFabButton

//        val animatorSet = AnimatorSet()
//
//        animatorSet.play(positioningAnimator).after(sizeAnimator)
//        animatorSet.duration = 500
//        animatorSet.start()

//        val valueAnimator = ValueAnimator.ofInt(view.measuredWidth, view.measuredWidth * 5)
//        valueAnimator.duration = 500L
//

        val parentView = view.parent as View
        val moveTo: Float = parentView.x + parentView.width / 2
        val translationX = moveTo - view.width /2 - view.x

        view.animate()
            .translationX(translationX)
            .setDuration(500)
            .setInterpolator(LinearInterpolator())
            .start()


//
//        valueAnimator.addUpdateListener {
//            val animatedValue = valueAnimator.animatedValue as Int
//            val layoutParams = view.layoutParams
//            layoutParams.width = animatedValue
//            view.layoutParams = layoutParams
//            view.translationX -= layoutWidth
//            it.interpolator = LinearInterpolator()
//
//        }
//        valueAnimator.start()
    }

    private fun decreaseButton(view: View) {
        var layoutWidth: Int = (view.parent as View).width
        layoutWidth = layoutWidth / 2 - view.width

        val testing = location[0].toFloat()

        view.animate()
            .translationX(0F)
            .setDuration(500)
            .setInterpolator(LinearInterpolator())
            .start()

//        val valueAnimator =
//            ValueAnimator.ofInt(view.layoutParams.width, view.layoutParams.width / 5)
//        valueAnimator.duration = 800L
//        valueAnimator.addUpdateListener {
//            val animatedValue = valueAnimator.animatedValue as Int
//            val layoutParams = view.layoutParams
//            layoutParams.width = animatedValue
//            view.layoutParams = layoutParams
//            view.translationX += 10
//        }
//        valueAnimator.start()
    }


}