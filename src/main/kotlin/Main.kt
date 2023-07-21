import java.util.Scanner

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    menuInicial(scanner)
}
fun menuInicial (scanner:Scanner) {
    println("Bem-vindo ao Fast Food Estrelas!")
    println("1. Lanche")
    println("2. Bebida")
    var escolhaDoCliente: Int

    try {
        escolhaDoCliente = scanner.nextLine().trim().toInt()

    } catch (e:Exception) {
        throw IllegalArgumentException("Formato inválido, para escolher o item, você deve informar o número dele")

    }
    when (escolhaDoCliente) {
       1 -> lanchesMenu(scanner)
        2 -> bebidasMenu(scanner)
        else -> tratarOpçaoInvalidaDoCliente(scanner)

    }
}

fun bebidasMenu(scanner: Scanner) {

}

fun bebidasMenuMenu (scanner:Scanner) {
    println("\nBEBIDAS DISPONÍVEIS:")
    println("1. Refrigerantes - R$8,00")
    println("2. Sucos - R$6,00")
    var escolhaDoCliente: Int
    try {
        escolhaDoCliente = scanner.nextLine().trim().toInt()

    } catch (e:Exception) {
        throw IllegalArgumentException("Formato inválido, para escolher o item, você deve informar o número dele")

    }

    when (escolhaDoCliente) {
        1 -> println("1. Refrigerantes - R$8,00")
        2 -> println("2. 2. Sucos - R$6,00")
        else ->  tratarOpçaoInvalidaDoLanche(scanner)

    }
}


fun tratarOpçaoInvalidaDoCliente (scanner: Scanner) {
    println("Opção invalida, por favor tente novamente")
    menuInicial(scanner )
}
fun lanchesMenu (scanner:Scanner) {
    println("\nLANCHES DISPONÍVEIS:")
    println("1. X-burger - R$ 10,00")
    println("2. X-salada - R$ 12,00")

    val escolhaDoCliente: Int

    try {
        escolhaDoCliente = scanner.nextLine().trim().toInt()

    } catch (e:Exception) {
        throw IllegalArgumentException("Formato inválido, para escolher o item, você deve informar o número dele")

    }

     when (escolhaDoCliente) {
        1 -> println("1. X-burger - R$ 10,00")
        2 -> println("2. X-salada - R$ 12,00")
        else ->  tratarOpçaoInvalidaDoLanche(scanner)

    }
}


fun tratarCarrinho (scanner: Scanner) {
    println("Quantas quantidades deseja?")

    val quantidadeLanches = scanner.nextLine().trim().toInt()
    val itenDoCarrinho= ItenDoCarrinho(codigo = (0..100).random(), quantidade= quantidadeLanches, nome = "X-burguer", preco = 10.00)
    val carrinho = Carrinho(listaDeItens = mutableListOf<ItenDoCarrinho>())
    var totalDoCarrinho= 0.0
    for ( iten in carrinho.listaDeItens ) {
        totalDoCarrinho= iten.preco * iten.quantidade + totalDoCarrinho
    }
    }

fun tratarOpçaoInvalidaDoLanche (scanner: Scanner) {
    println("Opção invalida, por favor tente novamente")
    lanchesMenu(scanner )
}
