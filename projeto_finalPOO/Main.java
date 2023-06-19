import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void printCoffe() {
        System.out.println("    ( (");
        System.out.println("     ) )");
        System.out.println("  ........");
        System.out.println("  |      |]");
        System.out.println("  \\      /");
        System.out.println("   `'--'");
    }
    /*Function to print some messages*/
    public static void printFinalMessages(String input, String color){

        Scanner scanner = new Scanner(System.in);
        String message = String.format("|  %s  ", input);
        String colorAdvise = null;

        if(Objects.equals(color, "red")){
            colorAdvise="\u001B[31m";
        } else {
            colorAdvise="\u001B[32m";
        }
        System.out.println(colorAdvise + "\n|-----------------------------------------------");
        System.out.println(message);
        System.out.println("|-----------------------------------------------\n" + ANSI_RESET);

        scanner.nextLine();
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    
    public static final boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UserDAO userDao = new UserDAO();
        CoffeeDAO CoffeeDao = new CoffeeDAO();

        boolean switchOn = true;

        while (switchOn) {
            System.out.println("\n|-----------------------------------------------|");
            System.out.println("|          MENU INICIAL - [Coffee SHOP]           |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  01   |    Cadastrar User                       |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  02   |    Login                                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  0    |    Sair do programa                     |");
            System.out.println("|-------------------------------------------------|\n");
            System.out.print("Digite a opção: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do User -> ");
                    String name = scan.nextLine();
                    while (!isString(name)) {
                        System.out.println("Nome invalido!");
                        name = scan.next();
                    }

                    System.out.print("Informe a idade do User -> ");
                    int age;
                    do {
                        while (!scan.hasNextInt()) {
                            System.out.println("idade invalida");
                        }
                        age = scan.nextInt();
                    } while (age <= 0);
                    scan.nextLine();

                    int functionOpt;
                    System.out.println("\n|-----------------------------------------------|");
                    System.out.println("|          ATENCAO! -[INFORME O CARGO DO User]    |");
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|  01   |     ADMINISTRADOR-(ACESSO TOTAL)        |");
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|  02   |     VENDENDOR-[ACESSO PARCIAL]          |");
                    System.out.println("|-------------------------------------------------|\n");
                    functionOpt = scan.nextInt();
                    String function = null;

                    switch (functionOpt) {
                        case 1:
                            function = "Admin";
                            break;
                        case 2:
                            function = "Vendendor";
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }

                    System.out.print("Informe sua senha -> ");
                    String password = scan.next();
                    while (!isString(password)) {
                        System.out.println("Senha invalida!");
                        password = scan.next();
                    }

                    User User = new User(name, age, function, password);
                    userDao.insere_User(User);

                case 2:

                    do {
                        System.out.println("\n|-------------------------------------------------|");
                        System.out.println("|          MENU PRINCIPAL - [CoffeeS]            |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  03   |    Comprar Coffee                      |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  04   |    Gerenciar Coffee                    |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  05   |    Gerenciar Usuario                    |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  99    |    Sair do Progama                     |");
                        System.out.println("|-------------------------------------------------|\n");
                        System.out.print("Digite a opção: ");
                        opcao = scan.nextInt();
                        scan.nextLine();

                        switch (opcao) {
                            case 3:

                                List<Coffee> CoffeesBuy = new ArrayList<>();
                                CoffeesBuy = CoffeeDao.getCoffee();

                                for (Coffee s : CoffeesBuy) {
                                    System.out.println("ID: " + s.getId() + " Nome: " + s.getName_Coffee() + " Valor: "
                                            + s.getPrice());
                                    System.out.println("");
                                }
                                System.out.print("Informe o ID do Coffee que deseja Comprar: ");
                                int buyCoffeeId = scan.nextInt();
                                scan.nextLine();
                                Coffee CoffeeToBuy = CoffeeDao.getCoffeeById(buyCoffeeId);
                                if (CoffeeToBuy == null) {
                                    System.out.println("Nenhum tênis encontrado com o ID informado.");
                                } else {

                                    System.out.println("Digite a quantidade desejada: ");
                                    int quantidade = scan.nextInt();

                                    System.out.println("\nDetalhes da compra:");
                                    System.out.println("Tênis: " + CoffeeToBuy.getName_Coffee());
                                    System.out.println("Descrição: " + CoffeeToBuy.getDescription());
                                    System.out.println("Criador: " + CoffeeToBuy.getCreator());
                                    System.out.println("Quantidade: " + quantidade);
                                    System.out.println("Total: R$" + CoffeeToBuy.getPrice() * quantidade);

                                    System.out.print("Deseja confirmar a compra?(S/N): ");
                                    String confirm = scan.next();

                                    if (confirm.equalsIgnoreCase("S")) {
                                        CoffeeDao.excluir_Coffee(CoffeeToBuy);
                                        System.out.println("Compra realizada com sucesso!");
                                    } else {
                                        System.out.println("Compra cancelada.");
                                    }

                                }
                                break;
                            case 4:

                                do {
                                    System.out.println("\n|-------------------------------------------------|");
                                    System.out.println("|          MENU Coffee - [Coffee1]              |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  06   |    Cadastrar Coffee                    |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  07   |    Editar Coffee                       |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  08   |    Listar Coffee                       |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  09   |    Excluir Coffee                      |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  0    |    Sair do Progama                      |");
                                    System.out.println("|-------------------------------------------------|\n");
                                    System.out.print("Digite a opção: ");
                                    opcao = scan.nextInt();
                                    scan.nextLine();

                                    switch (opcao) {
                                        case 6:
                                            System.out.print("Informe o nome do Coffee -> ");
                                            String Coffeename = scan.nextLine();

                                            System.out.print("Informe a descrição do Coffee -> ");
                                            String desc = scan.nextLine();

                                            System.out.print("Informe o valor do Coffee -> ");
                                            double price;
                                            do {
                                                while (!scan.hasNextDouble()) {
                                                    System.out.println("Valor invalido");
                                                }
                                                price = scan.nextDouble();
                                            } while (price <= 0);
                                            scan.nextLine();

                                            System.out.print("Informe o nome do Criador -> ");
                                            String creator = scan.nextLine();
                                            while (!isString(creator)) {
                                                System.out.println("Nome invalido!");
                                                creator = scan.next();
                                            }

                                            Coffee Coffee = new Coffee(Coffeename, desc, price, creator);
                                            CoffeeDao.adicionar_Coffee(Coffee);
                                            break;
                                        case 7:

                                            boolean isValidEdit = false;
                                            System.out.print("Informe o ID do Coffee que deseja editar: ");
                                            int editCoffeeId = scan.nextInt();
                                            scan.nextLine();
                                            Coffee coffeeToEdit = CoffeeDao.getCoffeeById(editCoffeeId);
                                            if (coffeeToEdit == null) {
                                                System.out.println("Coffee não encontrado!");

                                            } else {
                                                System.out.print("Informe o novo nome do Coffee -> ");

                                                String newCoffeeName;
                                                for (newCoffeeName = scan
                                                        .nextLine(); !isString(newCoffeeName); newCoffeeName = scan
                                                                .nextLine()) {
                                                    System.out.println("Nome inválido!");
                                                }

                                                System.out.print("Informe a nova descrição do Coffee -> ");

                                                String newDesc;
                                                newDesc = scan.nextLine();

                                                System.out.print("Informe o novo valor do Coffee -> ");

                                                while (true) {
                                                    while (scan.hasNextDouble()) {
                                                        double newPrice = scan.nextDouble();
                                                        if (!(newPrice <= 0.0)) {
                                                            scan.nextLine();
                                                            System.out.print("Informe o novo nome do Criador -> ");
                                                            String newCreator;
                                                            for (newCreator = scan.nextLine(); !isString(
                                                                    newCreator); newCreator = scan
                                                                            .nextLine()) {
                                                                System.out.println("Nome inválido!");
                                                            }

                                                            coffeeToEdit.setName_Coffee(newCoffeeName);
                                                            coffeeToEdit.setDescription(newDesc);
                                                            coffeeToEdit.setPrice(newPrice);
                                                            coffeeToEdit.setCreator(newCreator);
                                                            CoffeeDao.editar_Coffee(coffeeToEdit);
                                                            System.out.println("Coffee editado com sucesso!");
                                                            isValidEdit = true;
                                                            break;
                                                        }
                                                    }

                                                    if (isValidEdit) {
                                                        break;
                                                    }

                                                    System.out.println("Valor inválido");
                                                    scan.nextLine();

                                                }

                                            }
                                            break;
                                        case 8:
                                            List<Coffee> Coffees = new ArrayList<>();
                                            Coffees = CoffeeDao.getCoffee();

                                            for (Coffee s : Coffees) {
                                                System.out.println("ID: " + s.getId());
                                                System.out.println("Nome: " + s.getName_Coffee());
                                                System.out.println("Valor: " + s.getPrice());
                                                System.out.println("Descrição: " + s.getDescription());
                                                System.out.println("Criador: " + s.getCreator());
                                                System.out.println("");
                                            }
                                            break;

                                        case 9:
                                            System.out.print("Informe o ID do Coffee que deseja excluir: ");
                                            int deleteCoffeeId = scan.nextInt();
                                            scan.nextLine();
                                            Coffee CoffeeToDelete = CoffeeDao.getCoffeeById(deleteCoffeeId);
                                            if (CoffeeToDelete != null) {
                                                CoffeeDao.excluir_Coffee(CoffeeToDelete);
                                                System.out.println("Coffee excluído com sucesso!");
                                            } else {
                                                System.out.println("Coffee não encontrado!");
                                            }
                                            break;
                                        default:
                                            break;
                                    }

                                } while (opcao != 0);

                                break;

                            case 5:

                                do {
                                    System.out.println("\n|-------------------------------------------------|");
                                    System.out.println("|          MENU User - [CoffeeS]              |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  10   |    Editar User                       |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  11   |    Listar Users                      |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  12   |    Excluir User                      |");
                                    System.out.println("|-------------------------------------------------|");
                                    System.out.println("|  0    |    Sair do Progama                      |");
                                    System.out.println("|-------------------------------------------------|\n");
                                    System.out.print("Digite a opção: ");
                                    opcao = scan.nextInt();
                                    scan.nextLine();

                                    switch (opcao) {
                                        case 10:
                                            boolean isValidEdit = false;
                                            System.out.print("Informe o ID do usuário que deseja editar: ");
                                            int editUserId = scan.nextInt();
                                            scan.nextLine();
                                            User userToEdit = userDao.getUserById(editUserId);
                                            if (userToEdit != null) {
                                                System.out.print("Informe o novo nome do usuário -> ");

                                                String newName;
                                                for (newName = scan.nextLine(); !isString(newName); newName = scan
                                                        .nextLine()) {
                                                    System.out.println("Nome inválido!");
                                                }

                                                System.out.print("Informe a nova idade do usuário -> ");

                                                while (true) {
                                                    while (scan.hasNextInt()) {
                                                        int newAge = scan.nextInt();
                                                        if (newAge > 0) {
                                                            scan.nextLine();
                                                            System.out.println(
                                                                    "\n|-------------------------------------------------|");
                                                            System.out.println(
                                                                    "|          ATENÇÃO! - [INFORME O CARGO DO USUÁRIO] |");
                                                            System.out.println(
                                                                    "|-------------------------------------------------|");
                                                            System.out.println(
                                                                    "|  01   |    ADMINISTRADOR - [TOTAL ACESSO]        |");
                                                            System.out.println(
                                                                    "|-------------------------------------------------|");
                                                            System.out.println(
                                                                    "|  02   |    VENDEDOR - [ACESSO PARCIAL]           |");
                                                            System.out.println(
                                                                    "|-------------------------------------------------|\n");
                                                            int newFunctionOpt = scan.nextInt();
                                                            String newFunction = null;
                                                            switch (newFunctionOpt) {
                                                                case 1:
                                                                    newFunction = "Admin";
                                                                    break;
                                                                case 2:
                                                                    newFunction = "Vendedor";
                                                                    break;
                                                                default:
                                                                    System.out.println("Opção inválida");
                                                            }

                                                            System.out.print("Informe a nova senha -> ");

                                                            String newPassword;
                                                            for (newPassword = scan
                                                                    .next(); !isString(newPassword); newPassword = scan
                                                                            .next()) {
                                                                System.out.println("Senha inválida!");
                                                            }

                                                            userToEdit.setName(newName);
                                                            userToEdit.setAge(newAge);
                                                            userToEdit.setRole(newFunction);
                                                            userToEdit.setPassword(newPassword);
                                                            userDao.editar_user(userToEdit);
                                                            System.out.println("Usuário editado com sucesso!");
                                                            isValidEdit = true;
                                                            break;
                                                        }
                                                    }

                                                    if (isValidEdit) {
                                                        break;
                                                    }

                                                    System.out.println("Idade inválida");
                                                    scan.nextLine();
                                                }
                                            }
                                            break;
                                        case 11:
                                            List<User> users = new ArrayList<>();
                                            users = userDao.getUser();

                                            for (User u : users) {
                                                System.out.println("ID: " + u.getId());
                                                System.out.println("Nome: " + u.getName());
                                                System.out.println("Idade: " + u.getAge());
                                                System.out.println("Função: " + u.getRole());
                                                System.out.println("");
                                            }
                                            break;

                                        case 12:
                                            System.out.print("Informe o ID do User que deseja excluir: ");
                                            int deleteUserId = scan.nextInt();
                                            scan.nextLine();
                                            User userToDelete = userDao.getUserById(deleteUserId);
                                            if (userToDelete != null) {
                                                userDao.excluir_usuario(userToDelete);
                                                
                                                System.out.println("User excluído com sucesso!");
                                            } else {
                                                System.out.println("User não encontrado!");
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                } while (opcao != 0);

                                break;

                            default:
                                break;
                        }

                    } while (opcao != 99);

                    break;
                default:
                    switchOn = false;
                    break;
            }
        }
        scan.close();
    }
}