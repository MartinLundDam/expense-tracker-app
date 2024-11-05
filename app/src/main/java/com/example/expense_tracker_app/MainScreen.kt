package com.example.expense_tracker_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.expense_tracker_app.pages.AddPage
import com.example.expense_tracker_app.pages.BudgetPage
import com.example.expense_tracker_app.pages.HomePage
import com.example.expense_tracker_app.pages.ProfilePage
import com.example.expense_tracker_app.pages.TransactionPage

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navbarItemList = listOf(
        NavbarItem("Home", painterResource(R.drawable.home_icon)), //new item with label "Home" and Icon "home_icon"
        NavbarItem("In & Out", painterResource(R.drawable.transactions_icon)),
        NavbarItem("Add", painterResource(R.drawable.add_icon)),
        NavbarItem("Budget", painterResource(R.drawable.budget_icon)),
        NavbarItem("Profile", painterResource(R.drawable.profile_icon))
    )

    var currentItemIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navbarItemList.forEachIndexed { index, navbarItem ->
                    NavigationBarItem(
                        selected = currentItemIndex == index, //true if they are equal
                        onClick = {
                            currentItemIndex = index
                        },
                        icon = {
                            Icon(
                                painter = navbarItem.icon,
                                contentDescription = "Icon",
                            )
                        },
                        label = {
                            Text(text = navbarItem.label)
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = modifier.padding(innerPadding),currentItemIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, currentItemIndex : Int) {
    when(currentItemIndex){
        0-> HomePage()
        1-> TransactionPage()
        2-> AddPage()
        3-> BudgetPage()
        4-> ProfilePage()
    }
}