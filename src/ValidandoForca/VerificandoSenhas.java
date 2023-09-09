package ValidandoForca;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VerificandoSenhas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Digite a senha para verificar a força: ");
        String senha = scanner.nextLine();
        //scanner.close();

        String resultado = verificarForcaSenha(senha);
        System.out.println(resultado);
    }

    public static String verificarForcaSenha(String senha) {
        int comprimentoMinimo = 8;

        // Verifica o comprimento mínimo da senha
        if (senha.length() < comprimentoMinimo) {
            return "Sua senha é muito curta. Recomenda-se no mínimo 8 caracteres.";
        }

        // Critérios de validação usando expressões regulares
        boolean temLetraMaiuscula = Pattern.compile("[A-Z]").matcher(senha).find();
        boolean temLetraMinuscula = Pattern.compile("[a-z]").matcher(senha).find();
        boolean temNumero = Pattern.compile("\\d").matcher(senha).find();
        boolean temCaractereEspecial = Pattern.compile("[!@#\\$%*]").matcher(senha).find();

        //Verificacao do comprimento mínimo e critérios de validação

        if (temLetraMaiuscula && temLetraMinuscula && temNumero && temCaractereEspecial) {
            return "Sua senha atende aos requisitos de segurança. Parabéns!";
        } else {
            return "Sua senha não atende aos requisitos de segurança.";
        }
    }
}
