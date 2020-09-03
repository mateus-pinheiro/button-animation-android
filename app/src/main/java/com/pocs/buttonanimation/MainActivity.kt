package com.pocs.buttonanimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var isFabButton = true
    private var initialPosition = 0.0F

    companion object {
        const val SIZE_BUTTON_MULTIPLICATION = 4
        const val DURATION_ANIMATION = 400L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        animate.setOnClickListener {

            when (isFabButton) {
                true -> increaseButton(animated)
                false -> decreaseButton(animated)
            }

            isFabButton = !isFabButton

        }
    }

    private fun increaseButton(view: View) {

        initialPosition = animated.x

        val parentView = view.parent as View
        val moveTo: Float = parentView.x + parentView.width / 2
        val futureXPosition = initialPosition - view.width * 2
        val futureWidth = view.width * 3
        val translationX = moveTo - futureWidth / 2 - futureXPosition


        val sizeAnimator = ValueAnimator.ofInt(view.measuredWidth, view.measuredWidth * 3)
        sizeAnimator.addUpdateListener {
            val value = it.animatedValue as Int
            val layoutParams = view.layoutParams
            layoutParams.width = value
            view.layoutParams = layoutParams
        }

        val positioningAnimator = ValueAnimator.ofFloat(translationX)
        positioningAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            view.translationX = value
        }

        val animatorSet = AnimatorSet()
        animatorSet.play(sizeAnimator).with(positioningAnimator)
        animatorSet.duration = DURATION_ANIMATION
        animatorSet.start()
    }

    private fun decreaseButton(view: View) {

        val sizeAnimator = ValueAnimator.ofInt(view.measuredWidth, view.measuredWidth / 3)
        sizeAnimator.addUpdateListener {
            val value = it.animatedValue as Int
            val layoutParams = view.layoutParams
            layoutParams.width = value
            view.layoutParams = layoutParams
        }

        val parent = view.parent as View
        val translationX = parent.width - view.width / 3

        val positioningAnimator = ObjectAnimator.ofFloat(view, "x", translationX.toFloat())
        positioningAnimator.interpolator = LinearInterpolator()
        positioningAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            view.translationX = value
        }

        val animatorSet = AnimatorSet()
        animatorSet.play(sizeAnimator).with(positioningAnimator)
        animatorSet.duration = DURATION_ANIMATION
        animatorSet.start()
    }

//    private fun View.increaseButton() {
//        val parentView = this.parent as View
//        val moveTo: Float = parentView.x + parentView.width / 2
//        val futureXPosition = x - width * 2
//        val futureWidth = width * 3
//        val translationX = moveTo - futureWidth / 2 - futureXPosition
//
//
//        val sizeAnimator = ValueAnimator.ofInt(measuredWidth, measuredWidth * 3)
//        sizeAnimator.addUpdateListener {
//            val value = it.animatedValue as Int
//            val layoutParams = this.layoutParams
//            layoutParams.width = value
//            this.layoutParams = layoutParams
//        }
//
//        val positioningAnimator = ValueAnimator.ofFloat(translationX)
//        positioningAnimator.addUpdateListener {
//            val value = it.animatedValue as Float
//            this.translationX = value
//        }
//
//        val animatorSet = AnimatorSet()
//        animatorSet.play(sizeAnimator).with(positioningAnimator)
//        animatorSet.duration = 300
//        animatorSet.start()
//    }
//
//    private fun View.decreaseButton(initialPosition: Float) {
//        val sizeAnimator = ValueAnimator.ofInt(measuredWidth, measuredWidth / 3)
//        sizeAnimator.addUpdateListener {
//            val value = it.animatedValue as Int
//            val layoutParams = this.layoutParams
//            layoutParams.width = value
//            this.layoutParams = layoutParams
//        }
//
//        val bias = initialPosition - 3
//        val positioningAnimator = ObjectAnimator.ofFloat(this, "x", bias)
//        positioningAnimator.interpolator = LinearInterpolator()
//        positioningAnimator.addUpdateListener {
//            val value = it.animatedValue as Float
//            translationX = value
//        }
//
//        val animatorSet = AnimatorSet()
//        animatorSet.play(sizeAnimator).with(positioningAnimator)
//        animatorSet.duration = 300
//        animatorSet.start()
//    }
}

