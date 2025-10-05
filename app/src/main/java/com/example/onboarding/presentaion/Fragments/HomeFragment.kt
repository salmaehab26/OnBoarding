import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.onboarding.R
import com.example.onboarding.databinding.FragmentHomeBinding
import com.example.onboarding.presentaion.Adapters.BoxesAdapter
import com.example.onboarding.presentaion.Adapters.CardAdapter
import com.example.onboarding.presentaion.Data.CardData
import com.example.onboarding.presentaion.Adapters.ImagesViewPagerAdapter
import com.example.onboarding.presentaion.Adapters.MostUsedCardAdapter
import com.example.onboarding.presentaion.Adapters.NewsCardAdapter
import com.example.onboarding.presentaion.Data.NewsCardData
import com.example.onboarding.presentaion.Adapters.OffersCardAdapter
import com.example.onboarding.presentaion.Data.BoxesCardData
import com.example.onboarding.presentaion.Data.OffersCardData
import com.example.onboarding.presentaion.Data.MostUsedCardData
import com.example.onboarding.presentaion.Data.SharedPrefrence
import com.example.onboarding.presentaion.activity.LogInActivity
import com.example.onboarding.presentaion.activity.NotificationActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    val images = listOf(
        R.drawable.banner,
        R.drawable.banner3,
        R.drawable.banner1
    )

    private lateinit var dotsContainer: LinearLayout

    private val dots = mutableListOf<ImageView>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dotsContainer = binding.includeView3.dotsContainer

        notification()
        createDots()
        signOutButton()
        viewPager()
        NewsCardAdapter()
        boxesAdapter()
        surveysTabs()
        assessment()
        OffersCardAdapter()
        mostUsedCardAdapter()


    }

    fun boxesAdapter() {
        val adapter = BoxesAdapter(BoxesCardData.BoxesCardsList)
        binding.includeView3.viewPagerBoxes.adapter = adapter
        binding.includeView3.viewPagerBoxes.offscreenPageLimit = 3

        binding.includeView3.viewPagerBoxes.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentDot(position)
            }
        })
    }

    private fun setCurrentDot(index: Int) {
        for (i in dots.indices) {
            val res = if (i == index) R.drawable.dot_selected
            else R.drawable.dot_unselected
            dots[i].setImageResource(res)
        }
    }

    fun notification() {
        binding.includeView.ivbell.setOnClickListener {

            startActivity(Intent(requireContext(), NotificationActivity::class.java))
        }
    }

    fun assessment() {
        val adaptercard = CardAdapter(CardData.cardsList)
        binding.includeView4.recycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adaptercard
        }

    }

    fun viewPager() {
        val adapter = ImagesViewPagerAdapter(images)
        binding.includeView2.viewPagerImages.adapter = adapter
        binding.includeView2.viewPagerImages.offscreenPageLimit = 3

        val marginTransformer = ViewPager2.PageTransformer { page, position ->
            page.scaleY = 0.85f + (1 - Math.abs(position)) * 0.15f
            page.translationX = -50 * position
        }
        binding.includeView2.viewPagerImages.setPageTransformer(marginTransformer)
        binding.includeView2.viewPagerImages.setCurrentItem(1)



    }

    fun surveysTabs() {
        val cards = listOf(
            binding.includeView4.card1,
            binding.includeView4.card2,
            binding.includeView4.card3
        )
        val titles = listOf(
            binding.includeView4.tvTitle1,
            binding.includeView4.tvTitle2,
            binding.includeView4.tvTitle3
        )
        val numbers = listOf(
            binding.includeView4.tvNumber1,
            binding.includeView4.tvNumber2,
            binding.includeView4.tvNumber3
        )

        cards.forEachIndexed { index, card ->
            card.setOnClickListener {
                cards.forEachIndexed { i, c ->
                    val selected = (i == index)
                    c.isSelected = selected
                    titles[i].isSelected = selected
                    numbers[i].isSelected = selected
                }

            }
        }
    }

    fun NewsCardAdapter() {
        val adapterNewsrCard = NewsCardAdapter(NewsCardData.cardsList)
        binding.includeView4.recyclerNews.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapterNewsrCard

        }
    }

    fun OffersCardAdapter() {
        val adapterOffersrCard = OffersCardAdapter(OffersCardData.cardsList)
        binding.includeView5.recyclerOffers.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapterOffersrCard


        }
    }

    fun mostUsedCardAdapter() {

        val adapterMostUsedCard = MostUsedCardAdapter(MostUsedCardData.cardsList)
        binding.includeView5.recyclerMostUsed.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapterMostUsedCard

        }
    }

    override fun onResume() {
        super.onResume()
        val dot = binding.includeView.notificationDot

        if (SharedPrefrence.isNotificationsRead(requireContext())) {
            dot.visibility = View.GONE
        } else {
            dot.visibility = View.VISIBLE
        }
    }

    fun signOutButton() {
        binding.includeView.bnSignout.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences(
                "sharedPreference",
                android.content.Context.MODE_PRIVATE
            )

            sharedPref.edit()
                .putBoolean("isLoggedIn", false)
                .apply()

            val intent = Intent(requireContext(), LogInActivity::class.java)
            startActivity(intent)

            requireActivity().finish()
        }
    }

    private fun createDots() {
        dots.clear()
        dotsContainer.removeAllViews()
        for (i in 0 until 3) {
            val dot = ImageView(requireContext()).apply {
                val size = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                size.setMargins(8, 0, 8, 0)
                layoutParams = size
                setImageResource(R.drawable.dot_unselected)
            }
            dots.add(dot)
            dotsContainer.addView(dot)
        }
    }

}
