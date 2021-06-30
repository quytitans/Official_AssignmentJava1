package view;

import controller.OderController;
import controller.OrderControllerActual;

import java.util.Scanner;

public class OrderViewActual implements OrderView {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void generateMenu() {
        OderController oderController = new OrderControllerActual();
        while (true) {
            System.out.println("ORDER MANAGERMENT - NYC COMPANY");
            System.out.println("-----------------------------------------");
            System.out.println("1. Add new order");
            System.out.println("2. Show all order storage");
            System.out.println("3. Search order by id");
            System.out.println("4. Revenue by time");
            System.out.println("5. Show paid orders");
            System.out.println("0. Exit program");
            System.out.println("-----------------------------------------");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Add new order");
                    oderController.addOrder();
                    break;
                case 2:
                    System.out.println("Show all order storage");
                    oderController.findAll();
                    break;
                case 3:
                    System.out.println("Search order by id");
                    oderController.findOrderByID();
                    break;
                case 4:
                    System.out.println("Revenue by time");
                    oderController.findOrderByTime();
                    break;
                case 5:
                    System.out.println("Show paid orders");
                    oderController.showPaidOrders();
                    break;
                default:
                    System.out.println("Please choose from 1 to 5, try one more time !!!");
                    break;
            }
            if (choice == 0) {
                break;
            }
        }
    }
}
