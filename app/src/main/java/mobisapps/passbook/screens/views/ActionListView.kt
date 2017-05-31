package mobisapps.passbook.screens.views

import com.hannesdorfmann.mosby3.mvp.MvpView
import mobisapps.passbook.entities.CategoryEntity

interface ActionListView : MvpView {
    fun showCategory(category: List<CategoryEntity>)
}
