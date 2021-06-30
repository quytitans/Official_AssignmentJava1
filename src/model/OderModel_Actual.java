package model;
import entity.Order;
import java.util.ArrayList;
import java.util.List;

public class OderModel_Actual implements OrderModel {
    List<Order> ListOrder = new ArrayList<>();

    {
        ListOrder = new ArrayList<>();
        ListOrder.add(new Order("order001", "Nguyen Van Quy", "1 hop Milo", 100, 1, 1561907248000l));
        ListOrder.add(new Order("order002", "Dang Thi Xoa", "1 bo dia", 200, 2, 1530371248000l));
        ListOrder.add(new Order("order003", "Luong Giang Nam", "10kg mit", 300, 0, 1498835248000l));
        ListOrder.add(new Order("order004", "Vu Duy Anh", "2 goi Xoi xeo", 400, 1, 1467299248000l));
        ListOrder.add(new Order("order005", "Dao Hong Luyen", "2 lon Bia", 500, 2, 1435676848000l));
        ListOrder.add(new Order("order006", "Nguyen Van Binh", "2 lon Coca", 200, 1, 1404140848000l));
        ListOrder.add(new Order("order007", "Vu Minh Tan", "1 lon Pepsi", 500, 2, 1372579648000l));
        ListOrder.add(new Order("order008", "Nguyen Xuan Kiem", "30 hop ca", 300, 1, 1341043648000l));
        ListOrder.add(new Order("order009", "Nguyen Quan", "2 bao cat", 200, 1, 1309421248000l));
    }

    @Override
    public List<Order> findAll() {
        return ListOrder;
    }

    @Override
    public List<Order> showPaidOrder() {
        List<Order> list05 = new ArrayList<>();
        for (int i = 0; i < ListOrder.size(); i++) {
            if (ListOrder.get(i).getStatus().equals("Paid")) {
                list05.add(ListOrder.get(i));
            } else {
                continue;
            }
        }
        return list05;
    }

    @Override
    public Boolean saveOrder(Order obj) {
        ListOrder.add(obj);
        return true;
    }

    @Override
    public Order findOrderById(String ID) {
        Order order = new Order();
        int flag = -1;
        for (int i = 0; i < ListOrder.size(); i++) {
            if (ListOrder.get(i).getID().equals(ID)) {
                order = ListOrder.get(i);
            }
        }
        return order;
    }

    @Override
    public List<Order> findOrderByTime(long startTime, long endTime) {
        List<Order> list03 = new ArrayList<>();
        for (int i = 0; i < ListOrder.size(); i++) {
            if (ListOrder.get(i).getCreatedAt() > startTime && ListOrder.get(i).getCreatedAt() < endTime) {
                list03.add(ListOrder.get(i));
            } else {
                continue;
            }
        }
        return list03;
    }

}
