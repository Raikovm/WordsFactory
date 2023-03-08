package com.example.wordsfactory.onboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.wordsfactory.R
import com.example.wordsfactory.R.drawable.*
import com.example.wordsfactory.SignupActivity
import com.google.android.material.button.MaterialButton

class OnboardActivity : AppCompatActivity() {
    private lateinit var onboardItemsAdapter: OnboardItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        setItems()
        setupIndicators()
        setCurrentIndicator(0)
        supportActionBar?.hide()
    }

    private fun setItems() {
        onboardItemsAdapter = OnboardItemsAdapter(
            listOf(
                OnboardItem(
                    image = onboard_image_1,
                    title = getString(R.string.onboard_title_1),
                    description = getString(R.string.onboard_description)
                ),
                OnboardItem(
                    image = onboard_image_2,
                    title = getString(R.string.onboard_title_2),
                    description = getString(R.string.onboard_description)
                ),
                OnboardItem(
                    image = onboard_image_3,
                    title = getString(R.string.onboard_title_3),
                    description = getString(R.string.onboard_description)
                ),
            )
        )

        val onboardViewPager = findViewById<ViewPager2>(R.id.onboardViewPager)
        onboardViewPager.adapter = onboardItemsAdapter
        onboardViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        findViewById<MaterialButton>(R.id.buttonNext).setOnClickListener {
            if (onboardViewPager.currentItem + 1 < onboardItemsAdapter.itemCount) {
                onboardViewPager.currentItem += 1
            } else {
                startActivity(Intent(applicationContext, SignupActivity::class.java))
                finish()
            }
        }
        findViewById<TextView>(R.id.textSkip).setOnClickListener {
            startActivity(Intent(applicationContext, SignupActivity::class.java))
            finish()
        }
    }

    private fun setupIndicators() {
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onboardItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        indicators.indices.forEach { i ->
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let { it ->
                it.setImageDrawable(ContextCompat.getDrawable(applicationContext, inactive_indicator))
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = indicatorsContainer.childCount
        (0 until childCount).forEach { i ->
            val imageView = indicatorsContainer.getChildAt(i) as ImageView

            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, active_indicator))
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, inactive_indicator))
            }
        }
    }
}