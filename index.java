import java.util.Scanner;

public class coffeeMachine {

    //having local variables

    static int water = 1200, milk = 540, coffeeBeans = 120, disposableCups = 9, money = 550;
    static Scanner input = new Scanner(System.in);

    // espresso 
    public static void espresso(int cup) {
        if (250 * cup > water) {//checks if there's enough water
            System.out.println("Not enough water resource, please refill");
        }
        if (16 * cup > coffeeBeans) {//checks if there's enough coffee beans
            System.out.println("Not enough coffee beans resource, please refill");
        }
        if (cup > disposableCups) {//checks if there's enough cups
            System.out.println("Not enough cups resource, please refill");
        }
        if (250 * cup < water && 16 * cup < coffeeBeans && cup < disposableCups) {
            System.out.println("Enough resorce, making cup of coffee, please wait.\n");

            water -= 250 * cup;
            coffeeBeans -= 16 * cup;
            disposableCups -= cup;
            money += 4 * cup;//adding to the value
            remaining();
        }
    }

    // latte
    public static void latte(int cup) {
        if (350 * cup > water) {//checks if there's enough water
            System.out.println("Not enough water resource, please refill");
        }
        if (75 * cup > milk) {//checks if there's enough milk
            System.out.println("Not enough milk resource, please refill");
        }
        if (20 * cup > coffeeBeans) {//checks if there's enough coffee beans
            System.out.println("Not enough coffee beans resource, please refill");
        }
        if (cup > disposableCups) {//checks if there's enough disposable cups
            System.out.println("Not enough disposable cups resource, please refill");
        }
        if (350 * cup < water && 75 * cup < milk && 20 * cup < coffeeBeans && cup < disposableCups) {
            System.out.println("Enough resorce, making cup of coffee, please wait.\n");

            water -= 350 * cup;
            milk -= 75 * cup;
            coffeeBeans -= 20 * cup;
            disposableCups -= cup;
            money += 7 * cup;
            remaining();
        }
    }

    // cappuccino
    public static void cappuccino(int cup) {
        if (200 * cup > water) {//checks if there's enough water
            System.out.println("Not enough water resource, please refill");
        }
        if (100 * cup > milk) {//checks if there's enough milk
            System.out.println("Not enough milk resource, please refill");
        }
        if (12 * cup > coffeeBeans) {//checks if there's enough coffee beans
            System.out.println("Not enough coffee beans resource, please refill");
        }
        if (cup > disposableCups) {//checks if there's enough disposable cups
            System.out.println("Not enough cups resource, please refill");
        }
        if (200 * cup < water && 100 * cup < milk && 12 * cup < coffeeBeans && cup < disposableCups) {
            System.out.println("Enough resource, making cup of coffee, please wait.\n");

            water -= 200 * cup;
            milk -= 100 * cup;
            coffeeBeans -= 12 * cup;
            disposableCups -= cup;
            money += 6 * cup;
            remaining();
        }
    }

    // refill
    public static void fill() {
        System.out.println("How much do you want to refill by?\n");

        System.out.println("How much water: ");
        water += input.nextInt();//Adding to the total of water

        System.out.println("How much milk: ");
        milk += input.nextInt();//adding to the total of milk

        System.out.println("How much coffee beans: ");
        coffeeBeans += input.nextInt();//adding to the total of coffee beans

        System.out.println("How much disposable cups: ");
        disposableCups += input.nextInt();//adding to the total of disposable cups

        remaining();

    }

    public static void remaining() {
        System.out.println("\nResources in the coffee machine");
        System.out.println(water + " Water remaining in the machine");
        System.out.println(milk + " Milk remaining in the machine");
        System.out.println(coffeeBeans + " Coffee Beans remaining in the machine");
        System.out.println(disposableCups + " Disposable cups remaining in the machine");
        System.out.println("$" + money + " Money in the machine\n");
    }

    // buying
    public static void buy() {

        System.out.println("What would you like to purchase:");
        System.out.println("1 - espresso\n" + "2 - latee\n" + "3 - cappuccino\n" + "back - Main Menu");
        String choice = input.next();
        int cup;

        if (choice.equals("1")) {//if "1" it fall into the statement and calls the method(espresso)
            System.out.println("How many cups would you like? \n");
            cup = input.nextInt();//prompts user for the amount he wishes to purchase

            espresso(cup);

        } else if (choice.equals("2")) {//if "2" it fall into the statement and calls the method(latte)
            System.out.println("How many cups would you like? ");
            cup = input.nextInt();//prompts user for the amount he wishes to purchase

            latte(cup);

        } else if (choice.equals("3")) {//if "3" it fall into the statement and calls the method(cappucino)
            System.out.println("How many cups would you like? ");
            cup = input.nextInt();//prompts user for the amount he wishes to purchase

            cappuccino(cup);
        } else if (!choice.equals("back")) {//if the input is not back it will prompt the question at the start

        }
    }

    // removing money
    public static void take() {
        System.out.println("Currently you have a balance of $" + money);
        money -= money;

        System.out.println("You have taken money from register your current balance is of $" + money);
    }

    public static void main(String[] args) {
        System.out.println("Welcome please choose what would you like (buy, take, fill, remaining, exit)");
        String choice = input.next();

        while (!choice.equals("exit"))//if the choice doesn't equal exit than the loop continues
        {

            if (choice.equals("buy")) {//if "buy" than it calls the method(buy)
                buy();
            }
            else if (choice.equals("take")) {//if "take" than it calls the method(take)
                take();
            }
            else if (choice.equals("fill")) {//if "fill" than it calls the method(fill)
                fill();
            }
            else if (choice.equals("remaining")) {//if "remaining" than it calls the method(remaining)
                remaining();
            }
            else if (!choice.equals("exit")) {//if any other choice is given then it falls under this condition
                System.out.println("Wrong input, please try again (buy, take, fill, remaining, exit)\n");
                choice = input.next();
            }
            System.out.println("\nPlease choose what would you like (buy, take, fill, remaining, exit");
            choice = input.next();
        }
    }

}
