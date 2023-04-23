import com.br.buscarcep.modelo.Cep;
import com.br.buscarcep.modelo.CepRecord;
import com.br.buscarcep.requisicoes.RequisicaoHttp;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o cep: ");
        String cep = leitor.nextLine();

        RequisicaoHttp requisicao = new RequisicaoHttp();
        CepRecord cepRecord = requisicao.requisicao(cep);

        Cep meuCep = new Cep(cepRecord);

        System.out.println(meuCep + "\n");
        //System.out.println(requisicao.requisicaoJson(cep));
        leitor.close();
    }
}