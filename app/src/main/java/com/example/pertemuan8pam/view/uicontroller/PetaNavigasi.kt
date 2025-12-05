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
import com.example.pertemuan8pam.view.EditSiswaScreen
import com.example.pertemuan8pam.view.route.DestinasiDetailSiswa
import com.example.pertemuan8pam.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.pertemuan8pam.view.route.DestinasiEditSiswa


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
                navigateToDetail = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")
                },
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
                navigateToEditItem = {
                    navController.navigate("${DestinasiEditSiswa.route}/${it}")
                },
                navigateBack = {navController.navigateUp()}
            )
        }
        composable(route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) {
                    type = NavType.IntType})){
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}