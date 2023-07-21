class Registro {
    fun processarPedido(itens: List<Item>, carrinho: MutableList<Item>) {
        println("Escolha o item:")
        itens.forEach { println("${it.code}. ${it.name}") }

        val itemInput = readLine()
        val itemCode = itemInput?.toIntOrNull()

        if (itemCode == null || itemCode !in 1..itens.size) {
            println("Opção inválida, tente novamente")
            return
        }

        println("Digite a quantidade:")
        val quantidadeInput = readLine()
        val quantidade = quantidadeInput?.toIntOrNull()

        if (quantidade == null || quantidade <= 0) {
            println("Quantidade inválida, tente novamente")
            return
        }

        val itemSelecionado = itens[itemCode - 1]
        val subtotal = itemSelecionado.price * quantidade
        carrinho.add(Item(itemSelecionado.code, itemSelecionado.name, subtotal))

        val total = carrinho.sumByDouble { it.price }
        println("Valor total do pedido: R$ $total")
        exibirOpcoes(carrinho)
    }

    fun exibirOpcoes(carrinho: MutableList<Item>) {
        println("Escolha uma opção:")
        println("1. Comprar mais itens")
        println("2. Editar um item")
        println("3. Remover um item")
        println("4. Finalizar pedido")

        val input = readLine()

        when (input) {
            "1" -> return
            "2" -> editarItem(carrinho)
            "3" -> removerItem(carrinho)
            "4" -> finalizarPedido(carrinho)
            else -> {
                println("Opção inválida, tente novamente")
                exibirOpcoes(carrinho)
            }
        }
    }

    fun editarItem(carrinho: MutableList<Item>) {
        println("Digite o código do item que deseja editar:")
        val itemCode = readLine()?.toIntOrNull()

        val itemIndex = carrinho.indexOfFirst { it.code == itemCode }

        if (itemIndex == -1) {
            println("Item não encontrado no carrinho.")
            exibirOpcoes(carrinho)
            return
        }

        println("Digite a nova quantidade:")
        val quantidadeInput = readLine()
        val quantidade = quantidadeInput?.toIntOrNull()

        if (quantidade == null || quantidade <= 0) {
            println("Quantidade inválida, tente novamente")
            exibirOpcoes(carrinho)
            return
        }

        val itemAtualizado = carrinho[itemIndex].copy(price = carrinho[itemIndex].price / carrinho[itemIndex].price * quantidade)
        carrinho[itemIndex] = itemAtualizado

        val total = carrinho.sumByDouble { it.price }
        println("Valor total do pedido: R$ $total")

        exibirOpcoes(carrinho)
    }

    fun removerItem(carrinho: MutableList<Item>) {
        println("Digite o código do item que deseja remover:")
        val itemCode = readLine()?.toIntOrNull()

        val itemIndex = carrinho.indexOfFirst { it.code == itemCode }

        if (itemIndex == -1) {
            println("Item não encontrado no carrinho.")
            exibirOpcoes(carrinho)
            return
        }

        carrinho.removeAt(itemIndex)

        val total = carrinho.sumByDouble { it.price }
        println("Valor total do pedido: R$ $total")

        exibirOpcoes(carrinho)
    }
    fun finalizarPedido(carrinho: MutableList<Item>) {
        if (carrinho.isEmpty()) {
            println("Carrinho vazio. Pedido não pode ser finalizado.")
            return
        }

        println("Pedido finalizado! Itens selecionados:")
        carrinho.forEach {
            println("${it.code}. ${it.name} - R$ ${it.price}")
        }

        println("Valor total do pedido: R$ ${carrinho.sumByDouble { it.price }}")

        println("Selecione a forma de pagamento:")
        println("1. Cartão de crédito")
        println("2. Cartão de débito")
        println("3. Vale refeição")
        println("4. Dinheiro")

        val input = readLine()

        when (input) {
            "1", "2", "3" -> {
                carrinho.clear()
                println("Compra finalizada com sucesso! Boa refeição.")
            }
            "4" -> pagarComDinheiro(carrinho)
            else -> println("Opção inválida, tente novamente")
        }
    }

    fun pagarComDinheiro(carrinho: MutableList<Item>) {
        val total = carrinho.sumByDouble { it.price }

        println("Digite o valor em dinheiro:")
        val dinheiroInput = readLine()
        val valorEmDinheiro = dinheiroInput?.toDoubleOrNull()

        if (valorEmDinheiro == null || valorEmDinheiro < total) {
            println("Valor inválido. O pagamento em dinheiro deve ser igual ou maior que o valor total.")
        } else {
            val troco = valorEmDinheiro - total
            println("Troco: R$ $troco")
            carrinho.clear()
            println("Compra finalizada com sucesso! Boa refeição.")
        }
    }
}