package com.newczl.composeproject.page

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.newczl.composeproject.R
import com.newczl.composeproject.ui.theme.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomePage() {
    Box(
        modifier = Modifier
            .background(pink100)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.light_welcome_bg),
            contentDescription = stringResource(id = R.string.tips),
            modifier = Modifier.fillMaxSize()
        )
        WelcomeContent()
    }
}

@Composable
fun WelcomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.light_welcome_illos),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(48.dp))
        WelcomeTitle()
        Spacer(modifier = Modifier.height(48.dp))
        WelcomeButton()
    }
}

@Composable
fun WelcomeTitle() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.light_logo),
            contentDescription = null,
            Modifier
                .height(33.dp)
                .wrapContentWidth()
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(32.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "哈哈哈哈", textAlign = TextAlign.Center, color = gary)
        }
    }
}

@Composable
fun WelcomeButton() {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val pressState = interactionSource.collectIsPressedAsState()
    val color = if (pressState.value) Color.Gray else pink900

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                Log.i("cccc", "click点击创建账号!!!!")
            },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(Shapes.medium),
            colors = ButtonDefaults.buttonColors(backgroundColor = pink900)
        ) {
            Text(text = "点击创建账号", color = white)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.clickable(
                indication = null, interactionSource = interactionSource
            ) {
                Log.i("cccc", "click登录!!!!")
            }, text = "登录", color = color
        )
    }

}