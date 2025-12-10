package com.example.budgie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.example.budgie.theme.Theme
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BudgetPagerScreen()
        }
    }
}

@Composable
fun BudgetPagerScreen() {
    val pagerCount = 3
    val pagerState = rememberPagerState(initialPage = 0) { pagerCount }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Budgie!",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Your budget made simple",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .height(4.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
        )

        BudgetTabs(
            pagerState = pagerState,
            titles = listOf("Income", "Bills", "Savings")
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> IncomePage()
                1 -> BillsPage()
                2 -> SavingsPage()
            }
        }
    }
}

@Composable
fun BudgetTabs(
    pagerState: androidx.compose.foundation.pager.PagerState,
    titles: List<String>
) {
    val scope = rememberCoroutineScope()

    SecondaryTabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(title) }
            )
        }
    }
}


@Composable
fun IncomePage() {
    var income by remember { mutableStateOf("") }

    BudgetPageLayout(title = "Income") {
        OutlinedTextField(
            value = income,
            onValueChange = { income = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Monthly income") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun BillsPage() {
    var billName by remember { mutableStateOf("") }
    var billAmount by remember { mutableStateOf("") }

    BudgetPageLayout(title = "Bills") {
        OutlinedTextField(
            value = billName,
            onValueChange = { billName = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Bill name") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Bill amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun SavingsPage() {
    var goal by remember { mutableStateOf("") }
    var saved by remember { mutableStateOf("") }

    BudgetPageLayout(title = "Savings") {
        OutlinedTextField(
            value = goal,
            onValueChange = { goal = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Savings goal") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = saved,
            onValueChange = { saved = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Amount currently saved") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun BudgetPageLayout(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        content()
    }
}
