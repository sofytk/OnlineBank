package ru.sochasapps.onlinebank

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun HomePage() {
    Scaffold(bottomBar = {
        BottomNavigationBar()
    }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            WalletSection()

            CardSection()

            Spacer(modifier = Modifier.height(16.dp))

            FinanceSection()

            CurrenciesSection()
        }

    }
}