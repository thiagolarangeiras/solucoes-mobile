class Produto(
	val id: Int,
    val nome: String,
    val preco: Double,
    val estoque: Int,
) {
    fun exibirDetalhes() {
        println(String.format("produto:%s codigo:%d preco:%.2f estoque:%d", nome, id, preco, estoque))
    }
}

class Cliente(
    val id: Int,
    val nome: String,
    var saldo: Double,
) {
    fun adicionarSaldo(valor: Double) {
		saldo += valor;
    } 
}

class CarrinhoDeCompras() {
    val produtos = mutableListOf<Produto>()
    fun adicionarProduto(produto: Produto, quantidade: Int) {
       for(q: Int in 0 .. quantidade){
       		produtos.add(produto)   
       }
    }
    
    fun remover(produto: Produto) {
       produtos.remove(produto)
    }
    
    fun exibirCarrinho() {
       for(produto in produtos){
           println(String.format("%s", produto.nome))
       }
    }
    
    fun calcularTotal(): Double {
       var total: Double = 0.0
        for(produto in produtos){
           total += produto.preco 
       }
       return total
    }
}

class Loja(val produtos: List<Produto>) {
    fun listarProduto() {
        println("Produtos Disponiveis: \n")
       	for(produto in produtos){
           produto.exibirDetalhes()
    	}
    }
   
   	fun finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras){
     	if (cliente.saldo < carrinho.calcularTotal()) {
            println("Saldo Invalido")
            return 
        }        
    }
}

fun main() {
    // Criando produtos
    val produto1 = Produto(1, "Notebook", 4500.0, 5)
    val produto2 = Produto(2, "Mouse Gamer", 250.0, 10)
    val produto3 = Produto(3, "Tecaldo Gamer", 300.0, 10)
    produto2.exibirDetalhes()
    println("")
    
    // Criando cliente
    val cliente = Cliente(1, "Ana", 5000.0)
    cliente.adicionarSaldo(5.0)
    println(cliente.saldo)
    println("")
    
    
    // Criando carrinho e loja
    val carrinho = CarrinhoDeCompras()
    val loja = Loja(listOf(produto1, produto2, produto3))
    
    // Adicionando produtos ao carrinho
    carrinho.adicionarProduto(produto1, 1)
    carrinho.adicionarProduto(produto2, 2)
    // Exibindo o carrinho
    carrinho.exibirCarrinho()
    
    // Tentando finalizar a compra
    loja.finalizarCompra(cliente, carrinho)
}