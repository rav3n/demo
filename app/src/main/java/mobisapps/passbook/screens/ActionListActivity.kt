package mobisapps.passbook.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import mobisapps.passbook.R
import mobisapps.passbook.screens.controllers.ActionListController

class ActionListActivity : AppCompatActivity() {

    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_list)

        router = Conductor.attachRouter(this, findViewById(R.id.activity_action_list_handler_layout) as ViewGroup, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(ActionListController.routerTransaction())
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ActionListActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}