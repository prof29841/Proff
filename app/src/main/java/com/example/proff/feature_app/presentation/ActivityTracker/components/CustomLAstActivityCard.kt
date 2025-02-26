package com.example.proff.feature_app.presentation.ActivityTracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._B6B4C2
import com.example.proff.feature_app.presentation.ui.theme._C4C4C4
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_1D1617
import com.example.proff.feature_app.presentation.ui.theme.poppins40012_B6B4C2

@Composable
fun CustomLAstActivityCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(15.dp)
            .shadow(10.dp, RoundedCornerShape(16.dp), spotColor = _1D161712),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.size(50.dp).clip(CircleShape).background(_C4C4C4, CircleShape), contentAlignment = Alignment.Center){
                AsyncImage(
                    model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/avatars//default_avatar.png",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(35.dp, 50.dp)
                )
            }
            Spacer(Modifier.width(10.dp))
            Column {
                Text(
                    text = title,
                    style = montserrat50012_1D1617
                )
                Text(
                    text = description,
                    style = poppins40012_B6B4C2
                )
            }
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = _B6B4C2,
                modifier = Modifier
                    .align(Alignment.Top)
            )
        }
    }
}