import java.util.concurrent.TimeUnit
data class Item(val code: Int, val name: String, val price: Double)
fun main() {
    val lanches = listOf(
        Item(1, "X-burger", 10.0),
        Item(2, "X-salada", 12.0)
    )
    val bebidas = listOf(
        Item(1, "Refrigerante", 8.0),
        Item(2, "Suco", 6.0)
    )
    val carrinho = mutableListOf<Item>()

    val entrada = false

    while (!entrada) {
        try {
            println()
            println("=== Bem-vindo ao FastFood Estrelas ===")
            println("1. Lanche | 2. Bebida")
            val opcao = readlnOrNull()?.toIntOrNull() ?: 0

            when (opcao) {
                1 -> Registro().processarPedido(lanches, carrinho)
                2 -> Registro().processarPedido(bebidas, carrinho)
                3 -> Registro().finalizarPedido(carrinho)
                else -> println("Opção inválida, tente novamente")
            }
        } catch (exception: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele!")
        }
    }
}