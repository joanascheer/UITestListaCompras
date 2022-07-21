package br.com.zup.listacompras.produto

import android.view.View
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.zup.listacompras.DETALHE_PRODUTO_MENSAGEM_ERRO
import br.com.zup.listacompras.NOME_PRODUTO_MENSAGEM_ERRO
import br.com.zup.listacompras.R
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProdutoFragmentTest {
    @Rule
    val scenario = launchFragmentInContainer<ProdutoFragment>()

    @Test
    fun showError_whenBothFieldsAreEmpty(){
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etNomeProduto))
            .check(matches(hasErrorText(NOME_PRODUTO_MENSAGEM_ERRO)))
        onView(withId(R.id.etDetalheProduto))
            .check(matches(hasErrorText(
            DETALHE_PRODUTO_MENSAGEM_ERRO)))

    }

    @Test
    fun showError_whenProductNameIsEmpty() {
        onView(withId(R.id.etDetalheProduto)).perform(typeText("batata"))
            .check(matches(hasNoErrorText()))
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etNomeProduto))
            .check(matches(hasErrorText(NOME_PRODUTO_MENSAGEM_ERRO)))
    }

    @Test
    fun showError_whenProductDetailIsEmpty() {
        onView(withId(R.id.etNomeProduto)).perform(typeText("batata"))
            .check(matches(hasNoErrorText()))
        closeSoftKeyboard()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etDetalheProduto))
            .check(matches(hasErrorText(
                DETALHE_PRODUTO_MENSAGEM_ERRO)))
    }


    fun hasNoErrorText(): BoundedMatcher<View?, EditText> {
        return object : BoundedMatcher<View?, EditText>(EditText::class.java) {

            override fun matchesSafely(view: EditText): Boolean {
                return view.error == null
            }

            override fun describeTo(description: org.hamcrest.Description?) {
                description?.appendText("has no error text: ");
            }
        }
    }





}