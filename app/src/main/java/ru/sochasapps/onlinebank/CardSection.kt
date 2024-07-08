package ru.sochasapps.onlinebank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sochasapps.onlinebank.ui.theme.BlueEnd
import ru.sochasapps.onlinebank.ui.theme.BlueStart
import ru.sochasapps.onlinebank.ui.theme.OrangeEnd
import ru.sochasapps.onlinebank.ui.theme.OrangeStart
import ru.sochasapps.onlinebank.ui.theme.PurpleEnd
import ru.sochasapps.onlinebank.ui.theme.PurpleGrey40
import ru.sochasapps.onlinebank.ui.theme.PurpleGrey80
import ru.sochasapps.onlinebank.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardName = "Business",
        cardNumber = "3636 326 7326 626",
        cardBalance = 46.89,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardType = "MASTERCARD",
        cardName = "Business",
        cardNumber = "3656 326 7969 0000",
        cardBalance = 10_345.90,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardType = "VISA",
        cardName = "Personal",
        cardNumber = "3636 909000 00 0988 ",
        cardBalance = 1050.50,
        color = getGradient(BlueStart, BlueEnd),
    ),

    )


fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPadding = 0.dp
    if (index == cards.size - 1) {
        lastItemPadding = 16.dp
    }

    var logo = painterResource(id = R.drawable.ic_visa)
    if (card.cardType.equals("MASTERCARD")) {
        logo = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPadding)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .width(230.dp)
                .height(160.dp)
                .clickable { }
                .background(card.color)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = logo,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "$${card.cardBalance}",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardName,
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )


        }
    }
}