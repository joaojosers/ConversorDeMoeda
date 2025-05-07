package principal;
import io.github.cdimascio.dotenv.Dotenv;
import modelos.Menu;

public class Principal {

        public static void main (String[] args) {
            // Carrega variáveis do arquivo .env
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("API_KEY");
            System.setProperty("API_KEY", apiKey);
            System.out.println("API KEY: " + System.getenv("API_KEY")); // ou EXCHANGE_API_KEY

            Menu.exibirMenu();
        }
    }

