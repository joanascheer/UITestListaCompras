package br.com.zup.listacompras.produto

import br.com.zup.listacompras.model.Produto
import org.junit.Test

class ProdutoFragmentTest {

    @Test
    fun recuperarDadosCampoEdicao_OnlyNomeEmpty_returnNull() {
        val prodFragment = ProdutoFragment()

        val produto = prodFragment.recuperarDadosCampoEdicao(
            nomeProduto = "",
            descricaoProduto = "batata frita"
        )

        assert(produto == null)
    }

    @Test
    fun recuperarDadosCampoEdicao_OnlyDescricaoEmpty_returnNull() {
        val prodFragment = ProdutoFragment()

        val produto = prodFragment.recuperarDadosCampoEdicao(
            nomeProduto = "batata",
            descricaoProduto = ""
        )

        assert(produto == null)
    }

    @Test
    fun recuperarDadosCampoEdicao_bothFieldsEmpty_returnNull() {
        val prodFragment = ProdutoFragment()

        val produto = prodFragment.recuperarDadosCampoEdicao(
            nomeProduto = "",
            descricaoProduto = ""
        )

        assert(produto == null)
    }

    @Test
    fun recuperarDadosCampoEdicao_bothFieldsOk_returnProduto(): Produto? {
        val prodFragment = ProdutoFragment()

        return prodFragment.recuperarDadosCampoEdicao(
            nomeProduto = "batata",
            descricaoProduto = "batata frita"
        )

    }


}