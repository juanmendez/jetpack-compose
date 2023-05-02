package com.jetpack.compose.rally

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetpack.compose.rally.ui.accounts.AccountsScreen
import com.jetpack.compose.rally.ui.accounts.SingleAccountScreen
import com.jetpack.compose.rally.ui.bills.BillsScreen
import com.jetpack.compose.rally.ui.overview.OverviewScreen

@Composable
fun RallyNavHost(navController: NavHostController, innerPadding: PaddingValues = PaddingValues(all = 0.dp)) {
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        // builder parameter will be defined here as the graph

        composable(route = Overview.route) {
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Accounts.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Bills.route)
                },
                onAccountClick = { accountType ->
                    navController.navigateSingleTopTo(
                        SingleAccount.getRouteWithArgument(accountType)
                    )
                }
            )
        }

        composable(route = Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateSingleTopTo(
                        SingleAccount.getRouteWithArgument(accountType)
                    )
                }
            )
        }
        composable(route = Bills.route) {
            BillsScreen()
        }

        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks,
        ) { navBackStackEntry ->
            // Retrieve the passed argument
            val accountType = navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)

            SingleAccountScreen(accountType)
        }

    }
}

fun NavHostController.navigateSingleTopTo(route: String) {
    navigate(route) {
        popUpTo(
            graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}