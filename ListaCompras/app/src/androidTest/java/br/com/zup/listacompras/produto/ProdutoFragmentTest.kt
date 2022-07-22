package br.com.zup.listacompras.produto

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.zup.listacompras.DETALHE_PRODUTO_MENSAGEM_ERRO
import br.com.zup.listacompras.NOME_PRODUTO_MENSAGEM_ERRO
import br.com.zup.listacompras.R
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class ProdutoFragmentTest {

    @Test
    fun showError_whenBothFieldsAreEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etNomeProduto))
            .check(matches(hasErrorText(NOME_PRODUTO_MENSAGEM_ERRO)))
        onView(withId(R.id.etDetalheProduto))
            .check(
                matches(
                    hasErrorText(
                        DETALHE_PRODUTO_MENSAGEM_ERRO
                    )
                )
            )
    }

    @Test
    fun showError_whenProductNameIsEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etDetalheProduto)).perform(typeText("batata"))
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etNomeProduto))
            .check(matches(hasErrorText(NOME_PRODUTO_MENSAGEM_ERRO)))
    }

    @Test
    fun showError_whenProductDetailIsEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etNomeProduto))
            .perform(typeText("batata"))
        //.check(matches(hasNoErrorText()))
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etDetalheProduto))
            .check(
                matches(
                    hasErrorText(
                        DETALHE_PRODUTO_MENSAGEM_ERRO
                    )
                )
            )
    }

    @Test
    fun checkProductOnList_whenBothFieldsAreValid() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etNomeProduto))
            .perform(typeText("batata"))
        onView(withId(R.id.etDetalheProduto))
            .perform(typeText("batata frita deliciosa"))
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.imageView2))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvNomeProduto))
            .check(matches(isDisplayed()))

    }


}