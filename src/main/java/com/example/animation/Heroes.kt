package com.example.animation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.animation.Model.Hero

@Composable

fun HeroCard(hero: Hero, modifier: Modifier = Modifier){
    Card (modifier = Modifier.fillMaxWidth()){
        Row (modifier = Modifier.padding(16.dp)){

            Column() {
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
                    modifier = Modifier.size(72.dp),


                )
            }

        }
    }
}