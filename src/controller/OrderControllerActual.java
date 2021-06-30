package controller;

import entity.Order;
import model.OderModel_Actual;
import model.OrderModel;
import util.CheckIntergerInput;
import util.DateTimeMilisecond;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderControllerActual implements OderController {
    OrderModel orderModel = new OderModel_Actual();
    Scanner scan = new Scanner(System.in);

    //nhap order moi
    @Override
    public void addOrder() {
        int status = 3;
        int totalPrice = 0;
        String orderId;
        String customerName;
        List<Order> listAllOrder = new ArrayList<>();
        listAllOrder = orderModel.findAll();
        //kiem tra orderID co ton tai chua hay co phai mot khoang trong khong
        while (true) {
            System.out.println("Enter order ID, example oder009: ");
            orderId = scan.nextLine();
            int flag1 = 0;
            for (int i = 0; i < listAllOrder.size(); i++) {
                if (listAllOrder.get(i).getID().equals(orderId) || orderId.equals("")) {
                    flag1++;
                }
            }
            if (flag1 != 0) {
                System.out.println("this orderID already exist or null, pls try with another ID");
                scan.nextLine();
                continue;
            } else {
                break;
            }
        }
        //kiem tra do dai cua ten khach hang phai dai hon 3 ki tu
        while (true) {
            System.out.println("Enter Customer's Name: ");
            customerName = scan.nextLine();
            if (customerName.length() <= 3) {
                System.out.println("name is too short, must be over 3 letters");
                continue;
            } else {
                break;
            }
        }

        System.out.println("Enter product: ");
        String product = scan.nextLine();

        //kiem tra gia tien nhap vao phai la 1 so
        while (true) {
            System.out.println("Enter total price: ");
            String strTotalPrice = scan.nextLine();
            if (CheckIntergerInput.checkIntergerInput(strTotalPrice)) {
                totalPrice = Integer.parseInt(strTotalPrice);
                break;
            } else {
                System.out.println("price must be an number, pls try again!!!");
                continue;
            }
        }

        //kiem tra lua chon phai la 1 2 hoac 0 va phai nhap vao la 1 number

        while (true) {
            System.out.println("Enter order status (1. Un-Paid. 2. Paid. 0. Deleted): ");
            String strStatus = scan.nextLine();
            if (CheckIntergerInput.checkIntergerInput(strStatus) && !strStatus.equals("")) {
                status = Integer.parseInt(strStatus);
                if (status == 1 || status == 2 || status == 0) {
                    break;
                } else {
                    System.out.println("please choose status from 0 to 2, 1. Un-Paid. 2. Paid. 0. Deleted");
                    continue;
                }
            } else {
                System.out.println("enter number only, 0 1 or 2 for next step");
                continue;
            }

        }
        Order obj = new Order(orderId, customerName, product, totalPrice, status);
        orderModel.saveOrder(obj);
    }

    @Override
    public void findAll() {
        List<Order> list01 = new ArrayList<>();
        list01 = orderModel.findAll();
        System.out.printf("|%5s%10s%5s|%5s%20s%5s|%5s%15s%5s|%5s%10s%5s|%5s%10s%5s|%5s%15s%5s|\n",
                "", "OrderID", "",
                "", "customer", "",
                "", "product", "",
                "", "totalPrice", "", "", "status", "", "", "createdAt", ""
        );
        for (int i = 0; i < list01.size(); i++) {
            System.out.println(list01.get(i).toString());
        }
        scan.nextLine();
    }

    @Override
    public void findOrderByID() {
        System.out.println("Please enter oderID: ");
        String findID = scan.nextLine();
        Order obj = new Order();
        obj = orderModel.findOrderById(findID);
        if (obj.getID() == null) {
            System.out.println("Not found");
            scan.nextLine();
        } else {
            System.out.printf("|%5s%10s%5s|%5s%20s%5s|%5s%15s%5s|%5s%10s%5s|%5s%10s%5s|%5s%15s%5s|\n",
                    "", "OrderID", "",
                    "", "customer", "",
                    "", "product", "",
                    "", "totalPrice", "", "", "status", "", "", "createdAt", ""
            );
            System.out.println(obj.toString());
            scan.nextLine();
        }
    }

    @Override
    public void findOrderByTime() {
        System.out.println("Start date (example: 1992/01/30):");
        String strDateStart = scan.nextLine();
        String strDateEnd;
        long DateStart = DateTimeMilisecond.convertToMillisec(strDateStart);
        long DateEnd;
        while (true) {
            System.out.println("End date (example: 1992/01/30):");
            strDateEnd = scan.nextLine();
            DateEnd = DateTimeMilisecond.convertToMillisec(strDateEnd);
            if (DateEnd < DateStart) {
                System.out.println("The end date must be after the start date, please re-enter !!!");
            } else {
                break;
            }
        }
        List list02 = new ArrayList();
        list02 = orderModel.findOrderByTime(DateStart, DateEnd);
        if (list02.size() < 1) {
            System.out.printf("List empty from %s to %s", strDateStart, strDateEnd);
        } else {
            System.out.printf("List order from %s to %s is: \n", strDateStart, strDateEnd);
            System.out.printf("|%5s%10s%5s|%5s%20s%5s|%5s%15s%5s|%5s%10s%5s|%5s%10s%5s|%5s%15s%5s|\n",
                    "", "OrderID", "",
                    "", "customer", "",
                    "", "product", "",
                    "", "totalPrice", "", "", "status", "", "", "createdAt", ""
            );
            for (int i = 0; i < list02.size(); i++) {
                System.out.println(list02.get(i).toString());
            }
        }
        scan.nextLine();
    }

    @Override
    public void showPaidOrders() {
        int totalPrice = 0;
        List<Order> list06 = new ArrayList<>();
        list06 = orderModel.showPaidOrder();
        if (list06.size() < 1) {
            System.out.printf("List paid orders is empty");
        } else {
            System.out.printf("|%5s%10s%5s|%5s%20s%5s|%5s%15s%5s|%5s%10s%5s|%5s%10s%5s|%5s%15s%5s|\n",
                    "", "OrderID", "",
                    "", "customer", "",
                    "", "product", "",
                    "", "totalPrice", "", "", "status", "", "", "createdAt", ""
            );
            for (int i = 0; i < list06.size(); i++) {
                System.out.println(list06.get(i).toString());
                totalPrice += list06.get(i).getTotalPrice();
            }
            System.out.printf("Total money: %d (vnd)", totalPrice);
        }
        scan.nextLine();
    }
}
