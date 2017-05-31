package mobisapps.passbook.screens.controllers

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.OnClick
import com.bluelinelabs.conductor.RouterTransaction
import com.butlerhero.app.kotlin.core.RxController
import mobisapps.passbook.R
import mobisapps.passbook.entities.CategoryEntity
import mobisapps.passbook.widgets.SlidingTabLayout
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import mobisapps.passbook.screens.presenters.ActionListPresenter
import mobisapps.passbook.screens.views.ActionListView

class ActionListController : RxController<ActionListView, ActionListPresenter>, ActionListView {

    constructor() : super ()
    constructor(args: Bundle) : super(args)

    @BindView(R.id.controller_action_list_sliding)
    lateinit var sliding: SlidingTabLayout

    @BindView(R.id.controller_action_list_view_pager)
    lateinit var pager: ViewPager

    override fun inflate(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_action_list, container, false)
    }

    override fun createPresenter(): ActionListPresenter {
        return ActionListPresenter()
    }

    companion object {
        fun routerTransaction() : RouterTransaction {
            return RouterTransaction.with(ActionListController())
        }
    }

    override fun showCategory(category: List<CategoryEntity>) {
        val pagerAdapter = object : RouterPagerAdapter(this) {
            override fun configureRouter(router: Router, position: Int) {
                if (!router.hasRootController()) {
                    router.setRoot(PlaceListController.routerTransaction(category[position].id))
                }
            }

            override fun getCount(): Int {
                return category.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return category[position].name
            }
        }

        pager.adapter = pagerAdapter
        sliding.setViewPager(pager)

    }

    @OnClick(R.id.controller_action_list_map_button)
    fun onMapButtonClicked() {
        router.pushController(MapController.routerTransaction())
    }
}
