package com.example.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.animation.Model.Hero
import androidx.compose.foundation.lazy.itemsIndexed
@Composable

fun HeroCard(hero: Hero, modifier: Modifier = Modifier){
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp,8.dp)
        ){
        Row (modifier = Modifier.padding(16.dp)){

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = LocalContext.current.getString(hero.nameRes),

                    style = MaterialTheme.typography.displaySmall

                )

                    Text(
                        text = LocalContext.current.getString(hero.descriptionRes),

                        style = MaterialTheme.typography.bodyLarge
                    )

            }
            Spacer(modifier = Modifier.width(32.dp))
            Box(){
                Image(
                    painter = painterResource(id = hero.imageRes ),
                    contentDescription = stringResource(id = hero.descriptionRes),
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp)),


                )
            }

        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeroList(list: List<Hero>,modifier: Modifier = Modifier, contentPadding: PaddingValues = PaddingValues(0.dp)) {
    LazyColumn(
        modifier = modifier,

        contentPadding = contentPadding
    ){
        items(list){hero ->
            HeroCard(hero = hero, modifier = modifier)

        }
    }
}