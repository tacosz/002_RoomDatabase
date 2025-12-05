package com.example.pertemuan8pam.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pertemuan8pam.view.EntrySiswaScreen
import com.example.pertemuan8pam.view.HomeScreen
import com.example.pertemuan8pam.view.route.DestinasiEntry
import com.example.pertemuan8pam.view.route.DestinasiHome
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan8pam.view.DetailSiswaScreen
import com.example.pertemuan8pam.view.route.DestinasiDetailSiswa
import com.example.pertemuan8pam.view.route.DestinasiDetailSiswa.itemIdArg


@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToDetail = {navController.navigate(DestinasiDetailSiswa.route)}
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable (DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(name = itemIdArg)
            {
              type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateBack = {navController.navigateUp()}
            )
        }
    }
}