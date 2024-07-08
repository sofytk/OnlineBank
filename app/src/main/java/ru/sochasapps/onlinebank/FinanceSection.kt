package ru.sochasapps.onlinebank

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sochasapps.onlinebank.ui.theme.BlueEnd
import ru.sochasapps.onlinebank.ui.theme.GreenEnd
import ru.sochasapps.onlinebank.ui.theme.OrangeStart
import ru.sochasapps.onlinebank.ui.theme.PurpleGrey80


val financeList = listOf(
    Finance(
        icon = Icons.Rounded.Star, backgroundIcon = OrangeStart, name = "My\nbusiness"
    ), Finance(
        icon = Icons.Rounded.Money, backgroundIcon = GreenEnd, name = "My\ntransaction"
    ), Finance(
        icon = Icons.Rounded.Analytics, backgroundIcon = PurpleGrey80, name = "My\nanalytics"
    ), Finance(
        icon = Icons.Rounded.Wallet, backgroundIcon = BlueEnd, name = "My\nwallet"
    )

)


@Composable
@Preview
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(financeList.size) {
                FinanceItem(it)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(8.dp)) {

        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .size(120.dp)
            .clickable { }
            .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.backgroundIcon)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}