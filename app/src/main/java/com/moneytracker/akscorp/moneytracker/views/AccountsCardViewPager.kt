package com.moneytracker.akscorp.moneytracker.views

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View
import com.moneytracker.akscorp.moneytracker.adapters.AccountViewPagerAdapter
import com.moneytracker.akscorp.moneytracker.models.Account
import com.moneytracker.akscorp.moneytracker.R
import org.jetbrains.anko.dimen


interface IAccountCard
{
    fun initCards(accounts: List<Account>)
}

class AccountsCardViewPager : ViewPager
{

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context) : super(context)

    init
    {
        clipToPadding = false
        setPadding(dimen(R.dimen.currencies_padding),
            dimen(R.dimen.currencies_padding),
            dimen(R.dimen.currencies_padding),
            dimen(R.dimen.currencies_padding))
        pageMargin = dimen(R.dimen.currencies_padding)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int)
    {
        var heightMeasureSpec = heightMeasureSpec
        try
        {

            val child = getChildAt(currentItem)
            if (child != null)
            {
                child.measure(widthMeasureSpec,
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
                val h = child.measuredHeight + paddingTop + paddingBottom

                heightMeasureSpec =
                        View.MeasureSpec.makeMeasureSpec(h, View.MeasureSpec.EXACTLY)
            }
        } catch (e: Exception)
        {
            e.printStackTrace()
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}