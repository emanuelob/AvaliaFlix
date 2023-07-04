package classes;

public class Principal {
    
    public static void main(String[] args) {
        //Criação dos objetos de filmes
        Filme filme1 = new Filme("O Senhor dos Anéis", "Fantasia", "2021-06-01", true, "Ótimo filme!", 4.5, 180);
        Filme filme2 = new Filme("Vingadores: Ultimato", "Ação", "2021-07-15", true, "Adorei!", 4.8, 210);

        //Criação dos objetos de séries
        Serie serie1 = new Serie("Stranger Things", "Suspense", "2021-09-10", true, "Muito bom!", 4.7, 3, 25);
        Serie serie2 = new Serie("Breaking Bad", "Drama", "2021-08-20", true, "Incrível!", 4.9, 5, 62);
        
        // Escrevendo nos arquivos TXT
        filme1.adicionarMidia();
        filme2.adicionarMidia();
        serie1.adicionarMidia();
        serie2.adicionarMidia();
        
        //Testando cálculo da duração dos filmes
        //Necessário refatorar código para pegar a informação da duração diretamente do arquivo.
        System.out.println(filme1.duracaoDoFilme());
        System.out.println(filme2.duracaoDoFilme());
        
        //Métodos que leem dos arquivos TXT
        filme1.buscarMidia("O Senhor dos Anéis");
        filme2.buscarMidia("Vingadores: Ultimato");
        serie1.buscarMidia("Stranger Things");
        serie2.buscarMidia("Breaking Bad");
        
        filme1.editarMidia("O Senhor dos Anéis", "O Senhor dos Anéis 3", "Fantasia", "2021-06-01", true, "Ótimo filme!", 4.5, 180, 0, 0);
        serie1.editarMidia("Stranger Things", "Stranger Things 4", "Suspense", "2022-09-10", true, "turn around, look what you seeeeeee", 5.0, 0, 1, 2);
    
        filme1.toTexto();
        serie1.toTexto();
        
<<<<<<< HEAD
        Estatisticas estat = new Estatisticas(); 
        
        estat.calcularClassificacoesPorNota();
=======
        //Verificando cadastro de usuário
        Usuario user = new Usuario("Debora", "debs@gmail.com", "123", "Debra");
        Usuario user1 = new Usuario("Debora", "debs_gmail.com", "123", "Debra");
        
        user.adicionarUsuario();
        user1.adicionarUsuario();
>>>>>>> d08f4259dfd30c221a1b355e21403831fe955a3c
    }
}
