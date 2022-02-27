package com.tekwill.practice.management.stock.data;

public class OrderList {
    private Order[] orders;

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId)
                return order;
        }
        return null;
    }

    public void insertAnOrder(Order order) {
        int length = this.orders.length;

        Order[] updatedOrderList = new Order[length + 1];

        System.arraycopy(this.orders, 0, updatedOrderList, 0, length);
        updatedOrderList[length] = order;

        this.orders = updatedOrderList;
    }

    public void deleteOrder(int id) {
        Order[] newOrdersList = new Order[orders.length - 1];
        for (int i = 0, j = 0; i < orders.length; i++) {
            if (orders[i].getId() != id) {
                newOrdersList[j++] = orders[i];
            }
        }
        this.orders = newOrdersList;
    }

    public void deletePickedProductFromOrder(Order order, Product product) {
        order.setProductsList(order.deleteProduct(product));
    }

    public void printOrders() {
        if (this.orders != null && this.orders.length > 0) {
            for (Order order : this.orders) {
                System.out.println(order.toString());
            }
        } else {
            System.out.println("No orders found!");
        }
    }
}
